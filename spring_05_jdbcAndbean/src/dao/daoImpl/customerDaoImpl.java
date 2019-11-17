package dao.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.CustomerDao;
import entity.Customer;

public class customerDaoImpl implements CustomerDao{
	
	@Override
	public Customer find(int customerId) {
		Customer customer = new Customer();
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection connection =DriverManager
					.getConnection("jdbc:mysql://localhost:3306/hahaha?useUnicode=true&characterEncoding=utf-8","root","123123");
			PreparedStatement ps = connection.prepareStatement("select * from customer where id="+customerId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer.setName(rs.getString("name"));
				customer.setId(rs.getInt("id"));
				customer.setAge(rs.getInt("age"));
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			throw new ExceptionInInitializerError("访问/操作数据库失败！");
		}
		return customer;
	}

	@Override
	public void delete(int customerId) {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection connection =DriverManager
					.getConnection("jdbc:mysql://localhost:3306/hahaha?useUnicode=true&characterEncoding=utf-8","root","123123");
			PreparedStatement ps = connection.prepareStatement("delete from customer where id="+customerId);
			ps.executeUpdate();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			throw new ExceptionInInitializerError("访问/操作数据库失败！");
		}
	}

	@Override
	public void insert(Customer customer) {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection connection =DriverManager
					.getConnection("jdbc:mysql://localhost:3306/hahaha?useUnicode=true&characterEncoding=utf-8","root","123123");
			Statement statement = connection
					.createStatement();
			statement.executeUpdate("insert into customer values("+customer.getId()
			+",'"+customer.getName()+"',"+customer.getAge()+")");
			statement.close();
			connection.close();
		}
		catch(Exception e) {
			throw new ExceptionInInitializerError("访问/操作数据库失败！");
		}
	}

	@Override
	public void update(Customer customer) {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection connection =DriverManager
					.getConnection("jdbc:mysql://localhost:3306/hahaha?useUnicode=true&characterEncoding=utf-8","root","123123");
			Statement statement = connection
					.createStatement();
			statement.executeUpdate("update customer set name='"+customer.getName()
			+"',age="+customer.getAge()+" where id="+customer.getId());
			statement.close();
			connection.close();
		}
		catch(Exception e) {
			throw new ExceptionInInitializerError("访问/操作数据库失败！");
		}		
	}
	
}
