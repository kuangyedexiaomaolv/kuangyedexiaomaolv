package KeHouXiTiLianXi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class usethread implements Runnable {
	private Socket socket;
	private static boolean temp;
	private static boolean temp1;
	public usethread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket=socket;
		temp=true;
		temp1=true;
	}
	@Override
	public void run() {
		
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        BufferedWriter Writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("t.txt",true)));
			BufferedReader rea=new BufferedReader(new InputStreamReader(new FileInputStream("t.txt")));
			BufferedReader rea1=new BufferedReader(new InputStreamReader(new FileInputStream("t.txt")));
                 String name=null; 
			     name=reader.readLine();
			     System.out.println(name);
			     
			     if(name.equals("ZhuCe")) {
			    	     String test=null;
			    	     name=reader.readLine(); 
			    	     while((test=rea.readLine())!=null) {
			    	    	 if(name.equals(test))
			    	    	 {
			    	    		 System.out.println("���˺��Ѿ�ע�����");
			    	    		 temp=false;
		    	    		     break;
		    	         }
		    	     }
			    	   if(temp==true) {
			    	   System.out.println(name);
			    	   Writer.append(name);
			           Writer.newLine();
			    	   Writer.flush();
			    	   }
			    	   else {
			    		   temp=true;
			    	   }
			     }
			    if(name.equals("DengLu")) {
			    	
			    	 name=reader.readLine();
			    	 String dl=null;
			    	
			    	 while((dl=rea.readLine())!=null) {
			    		 if(name.equals(dl)) {
			    			  System.out.println("��½�ɹ�");
			    			   temp1=false;break;
			    		 }
			    	 }
			    	 if(temp1==true) {
			    		 System.out.println("��½ʧ��");
			    		 temp1=true;
			    	 }
			    	 
			    }
			    if(name.equals("MessageTest")) {  
			    	name=reader.readLine();
			    	System.out.println(name);
			    	String test=null;
			    	while((test=rea.readLine())!=null)
			    	{
                        if(name.equals(test)) {
                            temp=false;
                        	String test1=null;
                        	System.out.println(name+"���ҳɹ�");
                        	name=reader.readLine();
                        	System.out.println(name);
                        		while((test1=rea1.readLine())!=null) {  
                        			System.out.println(test1);
                        			if(name.equals(test1))
                        			{  
                        				System.out.println(name+"���ҳɹ�");
                        				name=reader.readLine();
                        				System.out.println(name+"��Ϣ���ͳɹ�");
                        				temp1=false;
                        				break;
                        			}
                        		}
                        	  if(temp1==true) {
                        		  System.out.println(name+"���޴���");
                        	  }		
                        }
                    
                        } 
			    	if(temp==true) {
                        	System.out.println(name+"���޴���"  );
			    	}
			    temp=true;
			    temp1=true;
			    }
			 if(name.equals("ZhuXiao")) {
				 ArrayList<String>list=new ArrayList<String>();
				 name=reader.readLine();
				 String test=null;
				 while((test=rea.readLine())!=null) {	
					 list.add(test);
				 }
				  for(int m=0;m<list.size();m++) {
					 if(list.get(m).equals(name)) {
						 list.remove(m);
					     BufferedWriter Write=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("t.txt")));
						 temp=false;
						 for(int i=0;i<list.size();i++) {
							 System.out.println(list.get(i));
							 Write.append(list.get(i));
						     Write.newLine();
						     Write.flush();
						 
					     } Write.close();
					 }   
				  }
				 if(temp==true)
					 System.out.println(name+"���޴����޷�ע��");
			 }
			 rea1.close();
			 rea.close();
			 Writer.close();
			socket.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		
	}

}
