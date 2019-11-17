package proxy_Method;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author Administrator
 * 基于子类的动态代理
 * 		被代理类不能是最终类，即不能用final修饰
 * 		提供者：第三方CGLib，需要导入cglib.jar和asm.jar
 * 		涉及到的类：Enhancer
 * 		创建被代理对象的方法：create(class,Callback)
 * 				其中:class:被代理类的字节码：固定格式：xxx.getClass()
 * 					Callback:跟InvocationHandler作用一样，使用时一般也创建匿名内部类
 * 					一般写成: new MethodInterceptor() {
 *								@Override
 *								public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
 *									//要增强的代码；
 *								}
 *					前三个参数跟InvocationHandler的三个参数意思一样，
 *					第四个：MethodProxy methodProxy当前执行方法被代理对象，一般不用
 */
public class proxyService {
	Object obj = null;
	Object objproxy = null;
	public void setObj(Object obj) {
		this.obj = obj;
		objproxy = Enhancer.create(obj.getClass(),new MethodInterceptor() {
			@Override
			public Object intercept(Object arg0, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				String key = (String)args[0];
				Object rtValue = null;
				if("doFirst".equals(method.getName())) {
					System.out.println("找"+obj.getClass().getName()+"doFirst");
					if(key=="Y") {
						System.out.println("不加班，可以干");
						rtValue=method.invoke(obj, key);
					}
					else {
						System.out.println("加班不干");
					}
				}
				if("doSecond".equals(method.getName())) {
					System.out.println("找"+obj.getClass().getName()+"doFirst");
					if(key=="Y") {
						System.out.println("不加班，可以干");
						rtValue=method.invoke(obj, key);
					}
					else {
						System.out.println("加班不干");
					}
				}
				return rtValue;
			}
		});
	}
}
