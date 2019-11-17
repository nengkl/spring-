package top.neng.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.neng.Dao.XxDao;
import top.neng.entity.Xxx;
import top.neng.Service.Xx1Service;

@Service
public class Xx1ServiceImpl implements Xx1Service{

    @Autowired
    private XxDao xxDao;

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
