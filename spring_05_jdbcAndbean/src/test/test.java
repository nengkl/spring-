package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cotroller.customerController;
import entity.Customer;


/**
 * @author nengkl
 * 1.jdbc������excuteQuery:��ѯ��excuteUpdate:��ɾ��
 * 2.jdbc�����ܴ����Ľ���취��
 * 		��һ������mysql���ݿ�Ͷ�Ӧ���������ַ���utf_8
 * 		�ڶ�������jdbcUrl�������?useUnicode=true&characterEncoding=utf-8
 * 				�磺jdbc:mysql://localhost:3306/hahaha?useUnicode=true&characterEncoding=utf-8
 * 3.spring:bean��������಻������ApplicationContext���������ļ���ȡ�ֻ࣬����ע��ķ�ʽע��������
 * 				��: CustomerServiceImpl�в���д��ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
 * 				          ֻ����setע�����ע��ȡ��dao��;
 * 4.ClassPathXmlApplicationContext:ֻ�ܼ�����·���µ�xml�ļ�;
 *   FileSystemXmlApplicationContext:���Լ��ش�������λ��;
 * 5.bean����Ĵ�������
 * 	 	BeanFactory:�ӳټ���,����ʲôʱ����ʲôʱ�򴴽�;
 *   	ApplicationContext����������,�����������ļ��ͼ���;
 * 6.bean�����ִ�����ʽ
 * 	 	1.���ã�ʹ��Ĭ���޲ι��췽������
 * 	 	2.ʹ�þ�̬�����еķ���������Ҫ��factory-methodָ������bean��2����;
 *   	3.ʹ��ʵ�������еķ�������
 * 7.bean�����÷�Χ:bean��ǩscope����
 * 		1.singleton:������(Ĭ��ֵ) 
 * 				�������ڣ�����������������;
 * 		2.prototype:������   
 * 				�������ڣ����������٣����ڲ�����java�������ջ��ƻ���
 * 		3.request:���÷�Χ��һ������͵�ǰ�����ת��
 * 		4.session�����÷�Χ��һ�λỰ
 * 		5.globalsession�����÷�Χ��һ��ȫ�ֻỰ
 * 8.bean��xmlע�뷽ʽ
 * 		1.���캯��ע��
 * 			<constructor-arg name="ds" ref="dataSource"></constructor-arg>
 * 			���ԣ�name��type��index
 * 		2.set����ע��
 * 			<property name="user" value="root"></property>
 * 9.ע������
 * 		1.value ��ͨ������String����
 * 		2.ref ����bean����(�����������ļ����)
 * 		3.��������(����)
 * 			����<property name="xxx">
 * 				   <Array>
 * 						<value>AAA</value>
 * 						<value>BBB</value>
 * 						<value>CCC</value>
 * 				   </Array>
 * 			   </property>
 * 			   <property name="xxx">
 * 				   <Map>
 * 						<entry key="aaa" value="AAA"></entry>
 * 						<entry key="bbb" value="BBB"></entry>
 * 						<entry key="ccc" value="CCC"></entry>
 * 				   </Map>
 * 			   </property>
 * 		       <property name="xxx">
 * 				   <props>
 * 						<prop key="aaa" value="AAA"></prop>
 * 						<prop key="bbb" value="BBB"></prop>
 * 						<prop key="ccc" value="CCC"></prop>
 * 				   </props>
 * 			   </property>
 */
public class test {

	public static void main(String[] args) {
		customerController customercontroller = new customerController();
		Customer customer = new Customer();
		customer.setId(235);
		customer.setName("��֮��");
		customer.setAge(22);
		System.out.println(customercontroller.findByIdApi(customer.getId()));
		customercontroller.updateApi(customer);
		System.out.println(customercontroller.findByIdApi(customer.getId()));
		customercontroller.deleteApi(customer.getId());
		System.out.println(customercontroller.findByIdApi(customer.getId()));
		customer.setName("��֮��ͷ");
		customercontroller.insert(customer);
		System.out.println(customercontroller.findByIdApi(customer.getId()));
	}

}
