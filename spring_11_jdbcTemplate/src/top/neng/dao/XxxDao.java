package top.neng.dao;


import java.util.List;

import top.neng.entity.Template;

public interface XxxDao {
	int insert(Template template);
	int deleteById(String id);
	int Update(Template template);
	Template findById(String id);
	List<Template> findAll();
}
