package top.neng.Dao.DaoImpl;

import top.neng.Dao.XxDao;
import top.neng.entity.Xxx;

public class XxDaoImpl implements XxDao {

    @Override
    public void insert(Xxx xxx) {
        System.out.println("insert");
    }

    @Override
    public void update(Xxx xxx) {
        System.out.println("update");
    }

    @Override
    public void delete(String id) {
        System.out.println("delete");
    }

    @Override
    public void findById(String id) {
        System.out.println("findById");
    }

    @Override
    public void findAll() {
        System.out.println("findAll");
    }
}
