package top.neng.Dao;

import top.neng.entity.Xxx;

public interface XxDao {
    void insert(Xxx xxx);

    void update(Xxx xxx);

    void delete(String id);

    void findById(String id);

    void findAll();
}
