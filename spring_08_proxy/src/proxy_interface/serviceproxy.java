package proxy_interface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @author Administrator
 * ���ڽӿڵĴ���
 * 	Ҫ�󣺱�����������ʵ��һ���ӿ�
 * 	�ṩ�ߣ�JDK�ٷ�
 * 	�漰���ࣺProxy
 * 	�����������ķ�����new ProxyInstance(ClassLoader(),Class[],InvocationHandler)
 * 			����:ClassLoader(): ����������̶���ʽ��xxx.getClass().getClassLoader()
 * 				Class[]: �ֽ������飬д��������ʵ�ֵĽӿڣ��̶���ʽ��xxx.getClass().getInterface()
 * 				InvocationHandler:һ���ӿڣ������ṩҪ��ǿ�Ĵ��룬��Ҫд�ýӿڵ�ʵ���࣬ʵ��������������ڲ���
 * 								  һ��д�ɣ� 
 * 										new InvocationHandler() {
 *											@Override
 *											public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
 *												//д���Ӵ���
 *											}
 *			�����ڲ����е�ʵ�ַ�����public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {}
 *					 ���У�Object proxy:�����������ã��̶�д����
 *						 Method method: Ҫִ�еķ������̶�д����
 *						 Object[] args:ִ�з���ʱ�����Ĳ������̶�д����
 *					invoke���������������ã�ִ�б���������κη��������Ⱦ����÷�����
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
						System.out.println("��"+obj.getClass().getName()+"doFirst");
						if(key=="Y") {
							System.out.println("���Ӱ࣬���Ը�");
							rtValue=method.invoke(obj, key);
						}
						else {
							System.out.println("�Ӱ಻��");
						}
					}
					if("doSecond".equals(method.getName())) {
						System.out.println("��"+obj.getClass().getName()+"doFirst");
						if(key=="Y") {
							System.out.println("���Ӱ࣬���Ը�");
							rtValue=method.invoke(obj, key);
						}
						else {
							System.out.println("�Ӱ಻��");
						}
					}
					if("eatFirst".equals(method.getName())) {
						System.out.println("��"+obj.getClass().getName()+"doFirst");
						if(key=="Y") {
							System.out.println("���Ӱ࣬���Ը�");
							rtValue=method.invoke(obj, key);
						}
						else {
							System.out.println("�Ӱ಻��");
						}
					}
					if("eatSecond".equals(method.getName())) {
						System.out.println("��"+obj.getClass().getName()+"doFirst");
						if(key=="Y") {
							System.out.println("���Ӱ࣬���Ը�");
							rtValue=method.invoke(obj, key);
						}
						else {
							System.out.println("�Ӱ಻��");
						}
					}
					if("eatAll".equals(method.getName())) {
						System.out.println("��"+obj.getClass().getName()+"doFirst");
						if(key=="Y") {
							System.out.println("���Ӱ࣬���Ը�");
							rtValue=method.invoke(obj, key);
						}
						else {
							System.out.println("�Ӱ಻��");
						}
					}
					return rtValue;
				}
			});
	}
}

