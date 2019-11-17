package spring_02_daoimpl;

import spring_02_dao.userDao;

public class userBoyDaoImpl implements userDao {

	@Override
	public void getUser() {
        System.out.println("i am a good boy");		
	}

}
