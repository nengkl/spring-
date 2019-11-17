package top.neng.service;

import java.util.List;

import top.neng.entity.Template;

public interface XxxService {
	boolean insert(Template template);
	boolean deleteById(String id);
	boolean update(Template template);
	Template findById(String id);
	List<Template> findAll();
}
