package javadaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DaiLi implements InvocationHandler {
    private Object target;
    public DaiLi(Object targe) {
    	this.target=targe;
    }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	    
		System.out.println("授予权限");
		method.invoke(this.target,args);
		System.out.println("进行修改");
		return null;
	}

}
