package javadaili;

import java.lang.reflect.Proxy;

public class Test {
  public static void main(String[] args) {
	System.out.println("----------静态代理输出--------------");
	AchieveStudent stu=new AchieveStudent();
	stu.login();
	stu.rergist();
	stu.Fpassword();
	System.out.println("-----------动态代理输出--------------");
	System.out.println("代理前的函数操作结果:::");
	AchieveStudent2 stu2=new AchieveStudent2();
	Student ud=new AchieveStudent2();
	stu2.login();
	stu2.rergist();
	stu2.Fpassword();
	System.out.println("代理之后的函数操作结果:::");
	Student stu3=(Student)Proxy.newProxyInstance(ud.getClass().getClassLoader(), ud.getClass().getInterfaces() , new DaiLi(ud));

	stu3.login();	
	stu3.rergist();
	stu3.Fpassword();
}
}
