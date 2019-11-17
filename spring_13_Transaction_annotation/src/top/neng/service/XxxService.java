package top.neng.service;

import top.neng.entity.Xxx;

import java.util.List;

public interface XxxService {
    int insert(Xxx xxx);
    int deleteById(String id);
    int update(Xxx xxx);
    Xxx findById(String id);
    List<Xxx> findAll();
}

