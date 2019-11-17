package top.neng.Service.ServiceImpl;

import top.neng.Dao.XxDao;
import top.neng.entity.Xxx;
import top.neng.Service.Xx1Service;

public class Xx1ServiceImpl implements Xx1Service{

    private XxDao xxDao;

    public void setXxDao(XxDao xxDao) {
        this.xxDao = xxDao;
    }

    @Override
    public void insert(Xxx xxx) {
        xxDao.insert(xxx);
    }

    @Override
    public void update(Xxx xxx) {
        xxDao.update(xxx);
    }

    @Override
    public void delete(String id) {
        xxDao.delete(id);
    }

    @Override
    public void findById(String id) {
        xxDao.findById(id);
    }

    @Override
    public void findAll() {
        xxDao.findAll();
    }
}
