package test;

import controller.customerController;

/**
 * @author nengkl
 * 1.beanFactoryͨ�����䴴�������Class.forName("daoImpl.customerDaoImpl").newInstance();
 * 2.��properties�����ļ���ȡ��ʽ
 * 		��һ��.��ResourceBundle(ֻ��)���˷�ʽ���
 * 				private static ResourceBundle bundle = ResourceBundle.getBundle("bean");
 * 		�ڶ���.��InputStream
 * 				//1.��·���¶��ҵ������ţ�
 * 				InputStream inputStream = customerBeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
 * 				//2.�Զ���·��
 * 				InputStream inputStream = customerBeanFactory.class.getResourceAsStream("src/bean.properties");
 * 				//3.web��Ŀ��ʹ��
 * 				InputStream inputStream=context.getResourceAsStream("/WEB-INF/classes/init.properties");
 * 3.beanFactoryÿ��ʹ�ö����´����������Ե�û���̰߳�ȫ�������ʱ����һ��Map��Ϊbean������أ����þ�̬������ʼ��Map
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
