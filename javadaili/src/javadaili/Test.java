package javadaili;

import java.lang.reflect.Proxy;

public class Test {
  public static void main(String[] args) {
	System.out.println("----------��̬�������--------------");
	AchieveStudent stu=new AchieveStudent();
	stu.login();
	stu.rergist();
	stu.Fpassword();
	System.out.println("-----------��̬�������--------------");
	System.out.println("����ǰ�ĺ����������:::");
	AchieveStudent2 stu2=new AchieveStudent2();
	Student ud=new AchieveStudent2();
	stu2.login();
	stu2.rergist();
	stu2.Fpassword();
	System.out.println("����֮��ĺ����������:::");
	Student stu3=(Student)Proxy.newProxyInstance(ud.getClass().getClassLoader(), ud.getClass().getInterfaces() , new DaiLi(ud));

	stu3.login();	
	stu3.rergist();
	stu3.Fpassword();
}
}
