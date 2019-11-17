package beanFactory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;



public class customerBeanFactory {
	//1.��û���̰߳�ȫ�����ʱ����Map����bean����������ÿ�ε��ö������µ�
	private static ResourceBundle bundle = ResourceBundle.getBundle("bean");
	private static Map<String,Object> beans = new HashMap<String, Object>(); 
	
	//2/ʹ�þ�̬������ʼ��Map
	static {
		try {
			Enumeration<String> keys = bundle.getKeys();
			while(keys.hasMoreElements()) {
				String key = keys.nextElement();
				Object value = Class.forName(bundle.getString(key)).newInstance();
				beans.put(key,value);
				System.out.println("����"+beans.get(key));
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError("��������ʧ�ܣ�"+e);
		}
	}
	
	public static Object getBean(String name) {
		return beans.get(name);
	}
	

	// ��һ��.ResourceBundle
//	private static ResourceBundle bundle = ResourceBundle.getBundle("bean");
//
//	public static Object ResourceBundleGetBean(String name) {
//		try {
//			return Class.forName(bundle.getString(name)).newInstance();
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}

	// �ڶ���.InputStream

//	private static Properties properties = null;
//	static {
//		try {
//			//1.��·���¶��ҵ������ţ�
//			InputStream inputStream = customerBeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
//			//2.�Զ���·��
//			InputStream inputStream = customerBeanFactory.class.getResourceAsStream("src/bean.properties");
//			//3.webʹ��
//			InputStream inputStream=context.getResourceAsStream("/WEB-INF/classes/init.properties");
//			properties.load(inputStream);
//		} catch (Exception e) {
//			throw new ExceptionInInitializerError("��ȡ�����ļ�ʧ��" + e);
//		}
//	}
//
//	public static Object InputStreamGetBean(String name) {
//		try {
//			return Class.forName(properties.getProperty(name)).newInstance();
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}

}
