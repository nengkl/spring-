package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cotroller.customerController;
import entity.Customer;


/**
 * @author nengkl
 * 1.jdbc操作：excuteQuery:查询，excuteUpdate:增删改
 * 2.jdbc：不能存中文解决办法：
 * 		第一步：把mysql数据库和对应的列设置字符集utf_8
 * 		第二步：在jdbcUrl后面加上?useUnicode=true&characterEncoding=utf-8
 * 				如：jdbc:mysql://localhost:3306/hahaha?useUnicode=true&characterEncoding=utf-8
 * 3.spring:bean容器里的类不能在用ApplicationContext加载配置文件读取类，只能用注入的方式注入其他类
 * 				如: CustomerServiceImpl中不能写：ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
 * 				          只能用set注入或者注解取得dao层;
 * 4.ClassPathXmlApplicationContext:只能加载类路径下的xml文件;
 *   FileSystemXmlApplicationContext:可以加载磁盘任意位置;
 * 5.bean对象的创建规则
 * 	 	BeanFactory:延迟加载,对象什么时候用什么时候创建;
 *   	ApplicationContext：立即加载,解析完配置文件就加载;
 * 6.bean的三种创建方式
 * 	 	1.常用：使用默认无参构造方法创建
 * 	 	2.使用静态工厂中的方法创建，要用factory-method指定创建bean的2方法;
 *   	3.使用实例工厂中的方法创建
 * 7.bean的作用范围:bean标签scope属性
 * 		1.singleton:单例的(默认值) 
 * 				生命周期：从容器创建到销毁;
 * 		2.prototype:多例的   
 * 				生命周期：创建后不销毁，长期不用由java垃圾回收机制回收
 * 		3.request:作用范围是一次请求和当前请求的转发
 * 		4.session：作用范围是一次会话
 * 		5.globalsession：作用范围是一次全局会话
 * 8.bean的xml注入方式
 * 		1.构造函数注入
 * 			<constructor-arg name="ds" ref="dataSource"></constructor-arg>
 * 			属性：name、type、index
 * 		2.set方法注入
 * 			<property name="user" value="root"></property>
 * 9.注入类型
 * 		1.value 普通类型与String类型
 * 		2.ref 其他bean类型(必须是配置文件里的)
 * 		3.复杂类型(集合)
 * 			例：<property name="xxx">
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
		customer.setName("付之猪");
		customer.setAge(22);
		System.out.println(customercontroller.findByIdApi(customer.getId()));
		customercontroller.updateApi(customer);
		System.out.println(customercontroller.findByIdApi(customer.getId()));
		customercontroller.deleteApi(customer.getId());
		System.out.println(customercontroller.findByIdApi(customer.getId()));
		customer.setName("付之猪头");
		customercontroller.insert(customer);
		System.out.println(customercontroller.findByIdApi(customer.getId()));
	}

}
