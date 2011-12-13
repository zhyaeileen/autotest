package com.autotest.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader; 
import java.io.InputStreamReader;

public class TestCtrlGitCmd {

 
	public static void main(String[] args) {  

        String cmd[] =new String[]{ 
        		"cmd /c mkdir gittest",
        		"cmd /c cd gittest",
        		"cmd /c git init",
        		"cmd /c ls -a",
        		"cmd /c cat .git/HEAD",
        		"cmd /c echo \"Hello Autotest\">hello",
        		"cmd /c ls -a",
        		"cmd /c git add hello",
        		"cmd /c git status",
        		"cmd /c git commit -m \"hello first commit\"",
        		"cmd /c  echo 'It's new day for git'>>hello",
        		"cmd /c git update-index hello",
        		"cmd /c git status" }; 
        
        Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象   
        try  {  
        	for(int i=0;i<cmd.length;i++){
        		Process p = run.exec(cmd[i]);// 启动另一个进程来执行命令   
        		 BufferedInputStream in = new  BufferedInputStream(p.getInputStream());  
                 BufferedReader inBr = new  BufferedReader(new  InputStreamReader(in));  
                 String lineStr;
                 while  ((lineStr = inBr.readLine ()) !=  null )  
                     //获得命令执行后在控制台的输出信息    
                     System.out.println(lineStr);// 打印输出信息   
                     //检查命令是否执行失败。   
                 if  (p.waitFor() !=  0 ) {  
                     if  (p.exitValue() ==  1 ) //p.exitValue()==0表示正常结束，1：非正常结束   
                         System.err.println("命令执行失败!" );  
                 } 
                 inBr.close();  
                 in.close();  
        	}  
        } catch  (Exception e) {  
            e.printStackTrace();  
        }  
    }   
}
