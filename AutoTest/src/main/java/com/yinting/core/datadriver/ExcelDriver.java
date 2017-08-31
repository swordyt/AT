package com.yinting.core.datadriver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yinting.core.Log;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelDriver extends DataDriver {
	public static int publicPosition = 1;// 该参数在多线程下可能会出现问题，谨慎使用
	private String filePath = "";// excel 路径
	private String sheetName = "";
	private String[] cellName;
	private Workbook book = null;
	private Sheet sheet = null;
	// private int total = 0;// 数据表的有效行数
	private List<Integer> total = null;
	private int position = 1;

	public ExcelDriver(Method method) {
		this.parameter = DataDriver.parameteres.get(md5(method));
		this.totalParameter = parameter.length;
		filePath = parameter[0];// 第一个参数为filePath
		sheetName = parameter[1];// 第二个参数为sheetName
		initPara(filePath, sheetName);
	}

	public ExcelDriver(String path, String sheet) {
		initPara(path, sheet);
	}

	public boolean hasNext() {
		return position <= this.total.size();
	}

	public Object[] next() {
		Map<String, String> data = this.readRow(this.total.get(this.position - 1));
		publicPosition = this.position;
		this.position++;
		Log.log("====================用例：" + data.get("Description").toString() + "onStart========================");
		return new Object[] { data };
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void remove() {
		// TODO Auto-generated method stub

	}

	/**
	 * 根据传入的标识，判断当前标志所在的行，固定返回第一次发现的行号
	 * 如未发现将返回：0；
	 */
	public int getRowNumber(String flag) {
		Cell[] cell = this.sheet.getColumn(ExcelHeader.Description.getOrdinal());
		for (int i = 0; i < cell.length; i++) {
			if (cell[i].getContents().trim().equals(flag)) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * 读取指定的行，并封装成map返回。
	 */
	public Map<String, String> readRow(int rowNum) {
		Cell[] cells = this.sheet.getRow(rowNum);
		Map<String, String> data = new HashMap<String, String>();
		for (int i = 0; i < this.cellName.length; i++) {
			// 如果有为空的列该列就会被抛弃，不被载入。
			if (i >= cells.length || cells[i].getType() == CellType.EMPTY) {
				continue;
			}
			data.put(this.cellName[i], cells[i].getContents().toString());
		}
		return data;
	}

	// 初始化Excel数据
	private void initPara(String path, String sheet) {
		path = "src/main/resources/datadriver/excel/" + System.getProperty("ENV") + "/" + path;
		try {
			this.book = Workbook.getWorkbook(new File(path));
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// } catch (Exception e) {
		// throw new RuntimeException(path + "文件未发现");
		// }
		this.sheet = this.book.getSheet(sheet);
		Cell[] cells = this.sheet.getRow(0);
		this.cellName = new String[cells.length];
		for (int i = 0; i < cells.length; i++) {
			this.cellName[i] = cells[i].getContents().toString();
		}
		this.total = new ArrayList<Integer>();
		for (int rows = 1; rows < this.sheet.getRows(); rows++) {
			String run = this.sheet.getCell(ExcelHeader.Run.getOrdinal(), rows).getContents();
			if (run.equalsIgnoreCase("Y")) {
				this.total.add(rows);
			}
		}
	}

	public List<Integer> getTotal() {
		return total;
	}

	public void setTotal(List<Integer> total) {
		this.total = total;
	}

}
