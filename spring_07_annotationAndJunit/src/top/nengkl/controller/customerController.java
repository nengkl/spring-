package top.nengkl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import top.nengkl.entity.Customer;
import top.nengkl.service.CustomerService;

@Controller
public class customerController {
	
	@Autowired
	CustomerService customerservice;
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
