package Xiaolv;
import java.lang.StringBuilder;

public class xiaolv {
public static void main(String[] args) {
	
	
	long startTime = System.nanoTime();
	String a="hello";
	String c="hello";
	c=c+a;
	long endTime = System.nanoTime();

	long n1=(endTime - startTime);
	System.out.println("��������ʱ�䣺" +  n1+ "����"); 
	System.out.println(c);
	
	long startTime2 = System.nanoTime(); 
	
	////��ʼ����
	String w="hello";
	StringBuilder m=new StringBuilder(w);
	String o= m.append(a).toString();
	long endTime2 = System.nanoTime();
	////��������
	
	
	
    long n2=endTime2 - startTime2;
	System.out.println("��������ʱ�䣺" + n2 + "����"); 	
	System.out.println(o);
	
	long n3=n1-n2;
	System.out.println(n3+"����");
}
}
