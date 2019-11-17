package proxy_interface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @author Administrator
 * 基于接口的代理
 * 	要求：被代理类至少实现一个接口
 * 	提供者：JDK官方
 * 	涉及的类：Proxy
 * 	创建代理对象的方法：new ProxyInstance(ClassLoader(),Class[],InvocationHandler)
 * 			其中:ClassLoader(): 类加载器，固定格式：xxx.getClass().getClassLoader()
 * 				Class[]: 字节码数组，写代理类所实现的接口：固定格式：xxx.getClass().getInterface()
 * 				InvocationHandler:一个接口，用于提供要增强的代码，需要写该接口的实现类，实现类可以是匿名内部类
 * 								  一般写成： 
 * 										new InvocationHandler() {
 *											@Override
 *											public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
 *												//写增加代码
 *											}
 *			匿名内部类中的实现方法：public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {}
 *					 其中：Object proxy:代理对象的引用，固定写法；
 *						 Method method: 要执行的方法，固定写法；
 *						 Object[] args:执行方法时所传的参数，固定写法；
 *					invoke方法具有拦截作用：执行被代理类的任何方法都会先经过该方法；
 *			
 */
public class serviceproxy {
	Object obj = null;
	Object objproxy = null;
	public serviceproxy(Object obj) {
		this.obj = obj;
	}
	public void setProxy() {
		objproxy = Proxy.newProxyInstance(obj.getClass().getClassLoader()
				, obj.getClass().getInterfaces(), new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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
					if("eatFirst".equals(method.getName())) {
						System.out.println("找"+obj.getClass().getName()+"doFirst");
						if(key=="Y") {
							System.out.println("不加班，可以干");
							rtValue=method.invoke(obj, key);
						}
						else {
							System.out.println("加班不干");
						}
					}
					if("eatSecond".equals(method.getName())) {
						System.out.println("找"+obj.getClass().getName()+"doFirst");
						if(key=="Y") {
							System.out.println("不加班，可以干");
							rtValue=method.invoke(obj, key);
						}
						else {
							System.out.println("加班不干");
						}
					}
					if("eatAll".equals(method.getName())) {
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

