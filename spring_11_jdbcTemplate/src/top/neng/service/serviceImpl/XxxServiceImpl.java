package top.neng.service.serviceImpl;

import java.util.List;

import top.neng.dao.XxxDao;
import top.neng.entity.Template;
import top.neng.service.XxxService;


public class XxxServiceImpl implements XxxService{
	
	private XxxDao xxxDao;
	
	public void setXxxDao(XxxDao xxxDao) {
		this.xxxDao = xxxDao;
	}

	@Override
	public boolean insert(Template template){
		try {
			if(xxxDao.insert(template)>0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("运行时出现了异常",e);
		}
		return false;
	}

	@Override
	public boolean deleteById(String id) {
		try {
			if(xxxDao.deleteById(id)>0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("运行时出现了异常",e);
		}
		return false;
	}

	@Override
	public boolean update(Template template) {
		try {
			if(xxxDao.Update(template)>0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("运行时出现了异常",e);
		}
		return false;
	}

	@Override
	public Template findById(String id) {
		try{
			return xxxDao.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("运行时出现了异常",e);
		}
	}

	@Override
	public List<Template> findAll() {
		try{
			return xxxDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("运行时出现了异常",e);
		}
	}

}
