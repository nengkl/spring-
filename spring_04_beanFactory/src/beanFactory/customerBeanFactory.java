package beanFactory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;



public class customerBeanFactory {
	//1.当没有线程安全情况的时候用Map创建bean容器，不用每次调用都创建新的
	private static ResourceBundle bundle = ResourceBundle.getBundle("bean");
	private static Map<String,Object> beans = new HashMap<String, Object>(); 
	
	//2/使用静态代码框初始化Map
	static {
		try {
			Enumeration<String> keys = bundle.getKeys();
			while(keys.hasMoreElements()) {
				String key = keys.nextElement();
				Object value = Class.forName(bundle.getString(key)).newInstance();
				beans.put(key,value);
				System.out.println("创建"+beans.get(key));
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError("创建容器失败！"+e);
		}
	}
	
	public static Object getBean(String name) {
		return beans.get(name);
	}
	

	// 第一种.ResourceBundle
//	private static ResourceBundle bundle = ResourceBundle.getBundle("bean");
//
//	public static Object ResourceBundleGetBean(String name) {
//		try {
//			return Class.forName(bundle.getString(name)).newInstance();
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}

	// 第二种.InputStream

//	private static Properties properties = null;
//	static {
//		try {
//			//1.类路径下都找到（最优）
//			InputStream inputStream = customerBeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
//			//2.自定义路径
//			InputStream inputStream = customerBeanFactory.class.getResourceAsStream("src/bean.properties");
//			//3.web使用
//			InputStream inputStream=context.getResourceAsStream("/WEB-INF/classes/init.properties");
//			properties.load(inputStream);
//		} catch (Exception e) {
//			throw new ExceptionInInitializerError("读取配置文件失败" + e);
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
