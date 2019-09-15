package javadaili;

public class AchieveStudent implements Student {

	@Override
	public void login() {
		System.out.println("授予权限");
		System.out.println("登陆");
		System.out.println("进行修改");
		
		
	}

	@Override
	public void rergist() {
		System.out.println("授予权限");
		System.out.println("注册");
		System.out.println("进行修改");
	}

	@Override
	public void Fpassword() {
		System.out.println("授予权限");
		System.out.println("找回密码");
		System.out.println("进行修改");
	}

}
