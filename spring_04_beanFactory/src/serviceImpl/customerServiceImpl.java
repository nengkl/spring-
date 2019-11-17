package serviceImpl;

import dao.customerDao;
import service.customerService;

public class customerServiceImpl implements customerService {
	public customerServiceImpl() {
		System.out.println("service´´½¨");
	}
	
	private customerDao dao = (customerDao)beanFactory.customerBeanFactory.getBean("CUSTOMERDAO");
	@Override
	public void insert() {
		dao.insert();
	}

	@Override
	public void delete() {
		dao.delete();
	}

	@Override
	public void update() {
		dao.update();
	}

	@Override
	public void find() {
		dao.find();
	}

}
