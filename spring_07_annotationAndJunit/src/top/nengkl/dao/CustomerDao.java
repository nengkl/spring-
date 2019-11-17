package top.nengkl.dao;

import top.nengkl.entity.Customer;

public interface CustomerDao {
	Customer find(int customerId);
	void delete(int customerId);
	void insert(Customer customer);
	void update(Customer customer);
}
