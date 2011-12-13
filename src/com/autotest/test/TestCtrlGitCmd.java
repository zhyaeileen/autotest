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
        
        Runtime run = Runtime.getRuntime();//�����뵱ǰ Java Ӧ�ó�����ص�����ʱ����   
        try  {  
        	for(int i=0;i<cmd.length;i++){
        		Process p = run.exec(cmd[i]);// ������һ��������ִ������   
        		 BufferedInputStream in = new  BufferedInputStream(p.getInputStream());  
                 BufferedReader inBr = new  BufferedReader(new  InputStreamReader(in));  
                 String lineStr;
                 while  ((lineStr = inBr.readLine ()) !=  null )  
                     //�������ִ�к��ڿ���̨�������Ϣ    
                     System.out.println(lineStr);// ��ӡ�����Ϣ   
                     //��������Ƿ�ִ��ʧ�ܡ�   
                 if  (p.waitFor() !=  0 ) {  
                     if  (p.exitValue() ==  1 ) //p.exitValue()==0��ʾ����������1������������   
                         System.err.println("����ִ��ʧ��!" );  
                 } 
                 inBr.close();  
                 in.close();  
        	}  
        } catch  (Exception e) {  
            e.printStackTrace();  
        }  
    }   
}
