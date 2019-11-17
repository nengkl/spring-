package service.serviceImpl;

import dao.CustomerDao;
import entity.Customer;
import service.CustomerService;

public class customerServiceImpl implements CustomerService{
	
	CustomerDao customerDao = null;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	@Override
	public void deleteById(int customerId) {
		customerDao.delete(customerId);
	}

	@Override
	public void insert(Customer customer) {
		customerDao.insert(customer);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public Customer findById(int customerId) {
		return	customerDao.find(customerId);
	}
	

}
