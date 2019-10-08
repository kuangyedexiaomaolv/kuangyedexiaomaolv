package KeHouXiTiLianXi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
 public static void main(String[] args) throws IOException {
	 ServerSocket server=new ServerSocket(8888);
	 while(true)
	 {
		 Socket socket=server.accept();
		 Thread t=new Thread(new usethread(socket));
		 t.start();
	 }
}
}
