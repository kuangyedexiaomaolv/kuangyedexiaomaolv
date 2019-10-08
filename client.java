package KeHouXiTiLianXi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket(InetAddress.getByName("YU-SIR-PC").getHostAddress(),8888);
		BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedWriter Writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		
		System.out.println("请输入你的操作命令");
		System.out.print("1、注册   2、登陆   3、消息测试   4、注销  (经输入命令对应的数字)");
		int operation=-1;
		Scanner scan=new Scanner(System.in);
		operation=scan.nextInt();
	
		switch(operation) {
		case 1: System.out.print("请输入姓名:    "); String name=scan.next(); Writer.write("ZhuCe\n"+name);Writer.flush(); break;
		case 2: System.out.print("请输入姓名:    ");  String name1=scan.next(); Writer.write("DengLu\n"+name1);Writer.flush();break;
		case 3: System.out.println("请输入姓名:    "); String name2=scan.next();  System.out.println("请输入收信人的名字：");
		        String name3=scan.next();System.out.println("请输入信息：");
		        String message=scan.next();Writer.write("MessageTest\n"+name2+"\n"+name3+"\n"+message);Writer.flush();break;
		case 4:System.out.println("请输入姓名：");String name4=scan.next();Writer.write("ZhuXiao\n"+name4);Writer.flush();break;
		default : ;	 
		}
		
		reader.close();
		scan.close();
	    socket.close();
		

	}
 
}
