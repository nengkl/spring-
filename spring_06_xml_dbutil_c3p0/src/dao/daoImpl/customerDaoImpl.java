package dao.daoImpl;



import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.CustomerDao;
import entity.Customer;

public class customerDaoImpl implements CustomerDao{
	Customer customer = null;
	QueryRunner runner= null;

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setRunner(QueryRunner runner) {
		this.runner = runner;
	}

	@Override
	public Customer find(int customerId) {
		try {
			return runner.query("select * from customer where id=?",new BeanHandler<Customer>(Customer.class),customerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(int customerId) {
		try {
			runner.update("delete from customer where id = ?",customerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Customer customer) {
		try {
			runner.update("insert into customer(id,name,age) values(?,?,?)"
					,customer.getId(),customer.getName(),customer.getAge());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Customer customer) {
		try {
			runner.update("update customer set name=?,age=? where id=?"
					,customer.getName(),customer.getAge(),customer.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
}
