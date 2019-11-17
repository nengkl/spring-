package proxy_Method;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author Administrator
 * ��������Ķ�̬����
 * 		�������಻���������࣬��������final����
 * 		�ṩ�ߣ�������CGLib����Ҫ����cglib.jar��asm.jar
 * 		�漰�����ࣺEnhancer
 * 		�������������ķ�����create(class,Callback)
 * 				����:class:����������ֽ��룺�̶���ʽ��xxx.getClass()
 * 					Callback:��InvocationHandler����һ����ʹ��ʱһ��Ҳ���������ڲ���
 * 					һ��д��: new MethodInterceptor() {
 *								@Override
 *								public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
 *									//Ҫ��ǿ�Ĵ��룻
 *								}
 *					ǰ����������InvocationHandler������������˼һ����
 *					���ĸ���MethodProxy methodProxy��ǰִ�з������������һ�㲻��
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
				return rtValue;
			}
		});
	}
}
