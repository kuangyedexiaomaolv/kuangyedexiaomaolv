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
	System.out.println("程序运行时间：" +  n1+ "纳秒"); 
	System.out.println(c);
	
	long startTime2 = System.nanoTime(); 
	
	////开始计算
	String w="hello";
	StringBuilder m=new StringBuilder(w);
	String o= m.append(a).toString();
	long endTime2 = System.nanoTime();
	////结束计算
	
	
	
    long n2=endTime2 - startTime2;
	System.out.println("程序运行时间：" + n2 + "纳秒"); 	
	System.out.println(o);
	
	long n3=n1-n2;
	System.out.println(n3+"纳秒");
}
}
