package cotroller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Customer;
import service.CustomerService;

public class customerController {
	ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
	CustomerService customerservice = (CustomerService)ac.getBean("customerService");
	public void deleteApi(int customerId){
		customerservice.deleteById(customerId);
	}
	public void updateApi(Customer customer) {
		customerservice.update(customer);
	}
	public void insert(Customer customer) {
		customerservice.insert(customer);
	}
	public Customer findByIdApi(int customerId) {
		return customerservice.findById(customerId);
	}
}
