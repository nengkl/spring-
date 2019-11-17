package spring_02_serviceimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_02_dao.userDao;
import spring_02_service.service;

public class serviceImpl implements service{
	userDao userDao = null;
	public void setuserDao(userDao userdao) {
		this.userDao = userdao;
	}
	@Override
	public void getuser() {
		userDao.getUser();
	}
}
