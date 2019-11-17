package top.neng.dao;

import top.neng.entity.Xxx;

import java.util.List;

public interface XxxDao {
    int insert(Xxx xxx);
    int deleteById(String id);
    int update(Xxx xxx);
    Xxx findById(String id);
    List<Xxx> findAll();
}
