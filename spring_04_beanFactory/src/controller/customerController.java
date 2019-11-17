package controller;


import beanFactory.customerBeanFactory;
import service.customerService;

public class customerController {
	 
	 public customerController() {
		System.out.println("controller´´½¨");
	 }
	 private customerService service = (customerService)customerBeanFactory.getBean("CUSTOMERSERVICE");
	 public void insert() {
		 service.insert();
	 }
	 public void delete() {
		 service.delete();
	 }
	 public void update() {
		 service.update();
	 }
	 public void find() {
		 service.find();
	 }
}
