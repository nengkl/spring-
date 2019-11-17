package spring_02_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_02_service.service;

public class spring_02_test {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/*
		 * serviceImpl service = new serviceImpl(); service.setDao(new
		 * userBoyDaoImpl()); service.getuser(); service.setDao(new userGirlDaoImpl());
		 * service.getuser();
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		service service = (service)context.getBean("service");
		service.getuser();
	}

}
