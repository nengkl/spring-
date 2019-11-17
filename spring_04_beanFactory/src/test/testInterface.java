package test;

import controller.customerController;

/**
 * @author nengkl
 * 1.beanFactory通过反射创建类对象Class.forName("daoImpl.customerDaoImpl").newInstance();
 * 2.从properties配置文件读取方式
 * 		第一种.用ResourceBundle(只读)：此方式最好
 * 				private static ResourceBundle bundle = ResourceBundle.getBundle("bean");
 * 		第二种.用InputStream
 * 				//1.类路径下都找到（最优）
 * 				InputStream inputStream = customerBeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
 * 				//2.自定义路径
 * 				InputStream inputStream = customerBeanFactory.class.getResourceAsStream("src/bean.properties");
 * 				//3.web项目可使用
 * 				InputStream inputStream=context.getResourceAsStream("/WEB-INF/classes/init.properties");
 * 3.beanFactory每次使用都重新创建对象，所以当没有线程安全的情况下时创建一个Map作为bean容器或池，并用静态代码块初始化Map
 */
public class testInterface {

	public static void main(String[] args) {
		customerController controller = new customerController();
		controller.insert();
		controller.delete();
		controller.update();
		controller.find();
	}
}
