package top.nengkl.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import top.nengkl.dao.CustomerDao;
import top.nengkl.entity.Customer;
import top.nengkl.service.CustomerService;

@Service("customerService")
public class customerServiceImpl implements CustomerService{
	
	@Autowired
	@Qualifier("customerDao")
	CustomerDao customerDao = null;
	
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
		return customerDao.find(customerId);
	}
	

}
