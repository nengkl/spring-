package service;

import entity.Customer;

public interface CustomerService {
	Customer findById(int customerId);
	void deleteById(int customerId);
	void insert(Customer customer);
	void update(Customer customer);
}
