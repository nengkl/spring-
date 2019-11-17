package spring_01_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_01_beans.hello;

public class spring_01_test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //解析beans.xml文件，生成管理对应的beans对象
        hello hello = (hello)context.getBean("hello");
        hello.show();
	}

}
