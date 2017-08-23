package com.yinting.tools;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.yinting.core.Log;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;

public class Scpclient {
	static private Scpclient instance;

	static synchronized public Scpclient getInstance(String IP, String port, String username, String passward) {
		if (instance == null) {
			instance = new Scpclient(IP, port, username, passward);
		}
		return instance;
	}

	static public Scpclient getInstance(String serverName) {
		return getInstance(System.getProperty(serverName + ".ip"), System.getProperty(serverName + "port"),
				System.getProperty(serverName + ".username"), System.getProperty(serverName) + ".password");
	}

	private Scpclient(String IP, String port, String username, String password) {
		this.ip = IP;
		this.port = Integer.parseInt(port);
		this.username = username;
		this.password = password;
	}

	public void getFile(String remoteFile, String localTargetDirectory) {
		Connection conn = new Connection(ip, port);
		try {
			conn.connect();
			boolean isAuthenticated = conn.authenticateWithPassword(username, password);
			if (isAuthenticated == false) {
				Log.log("authentication failed");
			}
			SCPClient client = new SCPClient(conn);
			client.get(remoteFile, localTargetDirectory);
			conn.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void putFile(String localFile, String remoteTargetDirectory) {
		Connection conn = new Connection(ip, port);
		try {
			conn.connect();
			boolean isAuthenticated = conn.authenticateWithPassword(username, password);
			if (isAuthenticated == false) {
				Log.log("authentication failed");
			}
			SCPClient client = new SCPClient(conn);
			client.put(localFile, remoteTargetDirectory);
			conn.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void putFile(String localFile, String remoteFileName, String remoteTargetDirectory, String mode) {
		Connection conn = new Connection(ip, port);
		try {
			conn.connect();
			boolean isAuthenticated = conn.authenticateWithPassword(username, password);
			if (isAuthenticated == false) {
				Log.log("authentication failed");
			}
			SCPClient client = new SCPClient(conn);
			if ((mode == null) || (mode.length() == 0)) {
				mode = "0600";
			}
			client.put(localFile, remoteFileName, remoteTargetDirectory, mode);

			// 重命名
			ch.ethz.ssh2.Session sess = conn.openSession();
			String tmpPathName = remoteTargetDirectory + File.separator + remoteFileName;
			String newPathName = tmpPathName.substring(0, tmpPathName.lastIndexOf("."));
			sess.execCommand("mv " + remoteFileName + " " + newPathName);// 重命名回来

			conn.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// public void putFile(String localFile, String remoteFileName,String
	// remoteTargetDirectory) {
	// Connection conn = new Connection(ip,port);
	// try {
	// conn.connect();
	// boolean isAuthenticated = conn.authenticateWithPassword(username,
	// password);
	// if (isAuthenticated == false) {
	// System.err.println("authentication failed");
	// }
	// SCPClient client = new SCPClient(conn);
	// client.put(getBytes(localFile), remoteFileName, remoteTargetDirectory);
	// conn.close();
	// } catch (IOException ex) {
	// Logger.getLogger(SCPClient.class.getName()).log(Level.SEVERE, null,ex);
	// }
	// }

	public static byte[] getBytes(String filePath) {
		byte[] buffer = null;
		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream byteArray = new ByteArrayOutputStream(1024 * 1024);
			byte[] b = new byte[1024 * 1024];
			int i;
			while ((i = fis.read(b)) != -1) {
				byteArray.write(b, 0, i);
			}
			fis.close();
			byteArray.close();
			buffer = byteArray.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}

	private String ip;
	private int port;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * 格式化文件内容为list 忽略第一行内容
	 */
	public List<Map<String, String>> formatFileToList(String filePath) {
		// Scpclient scp = Scpclient.getInstance("10.30.199.71", "22", "log",
		// "Devopslog2017");
		// scp.getFile("/opt/files/fund/product/confirmorder/yingmi_1063_confirm_20170818.txt",
		// "E:\\Desktop");
		// File file=new File("E:\\Desktop\\yingmi_1063_confirm_20170818.txt");
		File file = new File(filePath);
		if (!file.exists()) {
			return null;
		}
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String lines = null;
		List<String> columnName = new ArrayList<String>();
		List<Map<String, String>> rows = new ArrayList<Map<String, String>>();// 解析后的所有数据
		int number = 1;// 记录当前行
		try {
			while ((lines = buffer.readLine()) != null) {
				if (number == 1) {
					number++;
					continue;
				}
				String[] keys = lines.split("\\|");
				if (number == 2) {// 如果是第二列就保存作为列明
					Collections.addAll(columnName, keys);
					number++;
					continue;
				}
				number++;
				Map<String, String> rowMap = new HashMap<String, String>();
				for (int i = 0; i < columnName.size(); i++) {
					if (keys.length > i) {// values值存在的情况
						if (keys[i].equals("")) {
							rowMap.put(columnName.get(i), "null");
							continue;
						} else {
							rowMap.put(columnName.get(i), keys[i]);
						}
					} else {// values不存在
						rowMap.put(columnName.get(i), "null");
					}
					rows.add(rowMap);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

		for (int i = 0; i < rows.size(); i++) {
			Map row = rows.get(i);
			Iterator<String> it = row.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				System.out.print(key + "=" + row.get(key));
			}
			System.out.println();
		}
		return rows;
	}

	/**
	 * 获取远端文件并转为list。 忽略第一行内容
	 */
	public static List<Map<String, String>> getContent(String serverName, String remoteFile) {
		Scpclient client = Scpclient.getInstance(serverName);
		client.getFile(remoteFile, System.getProperty("tmp"));
		return client.formatFileToList(System.getProperty("tmp"));
	}
}
