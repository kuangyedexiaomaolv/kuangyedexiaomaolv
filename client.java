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
		
		
		System.out.println("��������Ĳ�������");
		System.out.print("1��ע��   2����½   3����Ϣ����   4��ע��  (�����������Ӧ������)");
		int operation=-1;
		Scanner scan=new Scanner(System.in);
		operation=scan.nextInt();
	
		switch(operation) {
		case 1: System.out.print("����������:    "); String name=scan.next(); Writer.write("ZhuCe\n"+name);Writer.flush(); break;
		case 2: System.out.print("����������:    ");  String name1=scan.next(); Writer.write("DengLu\n"+name1);Writer.flush();break;
		case 3: System.out.println("����������:    "); String name2=scan.next();  System.out.println("�����������˵����֣�");
		        String name3=scan.next();System.out.println("��������Ϣ��");
		        String message=scan.next();Writer.write("MessageTest\n"+name2+"\n"+name3+"\n"+message);Writer.flush();break;
		case 4:System.out.println("������������");String name4=scan.next();Writer.write("ZhuXiao\n"+name4);Writer.flush();break;
		default : ;	 
		}
		
		reader.close();
		scan.close();
	    socket.close();
		

	}
 
}
