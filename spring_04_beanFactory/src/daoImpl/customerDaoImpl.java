package daoImpl;

import dao.customerDao;

public class customerDaoImpl implements customerDao {

	
	public customerDaoImpl() {
		System.out.println("dao创建");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("增");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("删");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("改");
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("查");	
	}

}
