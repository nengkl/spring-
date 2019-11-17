package test;

import org.apache.commons.dbutils.handlers.BeanHandler;

import cotroller.customerController;
import entity.Customer;

/**
 * @author nengkl
 * 1.org.apache.commons.dbutils.QueryRunner�ǹ��췽��ע��(dataSource ds)
 * 2.dataSource������c3p0��set����ע��
 * 3.c3p0��dataSource��com.mchange.v2.c3p0.ComboPooledDataSource
 * 4.ʹ��C3P0����Դʱ��Ҫ���� mchange-commons-java-0.2.3.4.jar��,ȱ�ٸ�jar�����
 *   ��com.mchange.v2.ser.Indirector����
 * 5.��Xml�ļ���jdbUrl������?useUnicode=true&characterEncoding=utf-8"ʱҪ��&�������amp;
 * 		�磺?useUnicode=true&amp;characterEncoding=utf-8"(properties����Ҫ)
 * 6.c3p0�������ӳ������ַ�ʽ
 * 		1.ʹ��ComboPooledDataSource�е�set������Դ������ע��
 * 		2.��дset����Ĭ����c3p0-conflg.xml�����ļ��ж�ȡ
 * 		3.Ҳ���Դ�c3p0.properties�����ļ���
 * 7.DBUtils����:
 * 		1.����һ��QueryRunner����c3p0��һ��dataSource�����캯��;
 * 		2.runner.query()������ѯ
 * 			����return runner.query(sql,new BeanHandler<Customer>(Customer.class),customerId);
 * 			        ����new BeanHandler<Customer>(Customer.class)�Ѳ�ѯ�����װ��Customer������;
 * 			        ��BeanHandler����BeanListHandler���װ��List<Customer>
 * 		3.runner.update()��ɾ��
 * 			����runner.update("update customer set name=?,age=? where id=?"
 *				,customer.getName(),customer.getAge(),customer.getId());
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
