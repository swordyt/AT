package com.yinting.test;
import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class Test4 {
    public static void main(String args[]) {
     try
  {
   
   Connection conn = new Connection("10.30.199.116");
   
   
   conn.connect();
   
   boolean isAuthenticated = conn.authenticateWithPassword("log","Devopslog2017");
   if (isAuthenticated == false)
    throw new IOException("Authentication failed. Please check hostname, username and password.");
   
   Session sess = conn.openSession();
   // sess.execCommand("uname -a && date && uptime && who");
   System.out.println("start exec command.......");
   
   //sess.execCommand("echo "Text on STDOUT"; echo "Text on STDERR" >&2");
   //sess.execCommand("env");
            sess.requestPTY("bash");
           
            sess.startShell();
           
           
   InputStream stdout = new StreamGobbler(sess.getStdout());
   InputStream stderr = new StreamGobbler(sess.getStderr());
 
   BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(stdout));
   BufferedReader stderrReader = new BufferedReader(new InputStreamReader(stderr));

   
   //if you want to use sess.getStdin().write(), here is a sample
   //byte b[]={'e','n','v','\n'};
   //byte b[]={'e','x','i','t','\n'};
   //sess.getStdin().write(b)

   //we used PrintWriter, it makes things simple
   PrintWriter out =new PrintWriter(sess.getStdin());

   out.println("/data/logs/mgw/fatLog.sh 630c4621989411e7b3a600163e0f1883 /data/logs/mgw/mgw-info.2017-09-13.0.log");
   out.println("exit");
   out.close();
   sess.waitForCondition(ChannelCondition.CLOSED | ChannelCondition.EOF | ChannelCondition.EXIT_STATUS, 30000);
   
   System.out.println("Here is the output from stdout:");
   
   while (true)
   {
    String line = stdoutReader.readLine();
    if (line == null)
     break;
    System.out.println(line);
   }
   System.out.println("Here is the output from stderr:");
   while (true)
   {
    String line = stderrReader.readLine();
    if (line == null)
     break;
    System.out.println(line);
   }
   
   System.out.println("ExitCode: " + sess.getExitStatus());
   sess.close();   
   conn.close();
  }
  catch (IOException e)
  {
   e.printStackTrace(System.err);
   System.exit(2);
  }
  }
    }