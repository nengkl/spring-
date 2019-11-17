package top.neng.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import top.neng.dao.XxxDao;
import top.neng.entity.Xxx;
import top.neng.service.XxxService;

@Service
public class XxxServiceImpl implements XxxService {
	
	@Autowired
    private XxxDao xx1dao;
	
    @Override
    @Transactional
    public int insert(Xxx xxx) { return xx1dao.insert(xxx); }

    @Override
    @Transactional
    public int deleteById(String id) { return xx1dao.deleteById(id); }

    @Override
    @Transactional
    public int update(Xxx xxx) { return xx1dao.update(xxx); }
    
    @Override
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public Xxx findById(String id) { return xx1dao.findById(id); }

    @Override
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public List<Xxx> findAll() { return xx1dao.findAll(); }
}
