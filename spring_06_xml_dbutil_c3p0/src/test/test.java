package test;

import org.apache.commons.dbutils.handlers.BeanHandler;

import cotroller.customerController;
import entity.Customer;

/**
 * @author nengkl
 * 1.org.apache.commons.dbutils.QueryRunner是构造方法注入(dataSource ds)
 * 2.dataSource可以用c3p0用set方法注入
 * 3.c3p0的dataSource：com.mchange.v2.c3p0.ComboPooledDataSource
 * 4.使用C3P0数据源时需要依赖 mchange-commons-java-0.2.3.4.jar包,缺少该jar包则会
 *   报com.mchange.v2.ser.Indirector错误
 * 5.在Xml文件中jdbUrl中配置?useUnicode=true&characterEncoding=utf-8"时要在&后面加上amp;
 * 		如：?useUnicode=true&amp;characterEncoding=utf-8"(properties则不需要)
 * 6.c3p0配置连接池有三种方式
 * 		1.使用ComboPooledDataSource中的set方法在源代码中注入
 * 		2.不写set方法默认在c3p0-conflg.xml配置文件中读取
 * 		3.也可以从c3p0.properties配置文件读
 * 7.DBUtils操作:
 * 		1.声明一个QueryRunner并用c3p0传一个dataSource到构造函数;
 * 		2.runner.query()用来查询
 * 			例：return runner.query(sql,new BeanHandler<Customer>(Customer.class),customerId);
 * 			        其中new BeanHandler<Customer>(Customer.class)把查询结果封装到Customer对象中;
 * 			        把BeanHandler换成BeanListHandler则封装到List<Customer>
 * 		3.runner.update()增删改
 * 			例：runner.update("update customer set name=?,age=? where id=?"
 *				,customer.getName(),customer.getAge(),customer.getId());
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
