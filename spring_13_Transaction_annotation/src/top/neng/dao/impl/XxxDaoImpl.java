package top.neng.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import top.neng.dao.XxxDao;
import top.neng.entity.Xxx;

@Repository
public class XxxDaoImpl implements XxxDao {
	@Autowired
    JdbcTemplate jt;

    @Override
    public int insert(Xxx xxx) { return jt.update("insert into xxx (name,pw)values(?,?)",xxx.getName(),xxx.getPw());}

    @Override
    public int deleteById(String id) { return jt.update("delete from xxx where id = ?",id); }

    @Override
    public int update(Xxx xxx) { return jt.update("update xxx set name=?,pw=? where id=?",xxx.getName(),xxx.getPw(),xxx.getId()); }

    @Override
    public Xxx findById(String id) { return  jt.query("select * from xxx where id=?", new BeanPropertyRowMapper<Xxx>(Xxx.class),id).get(0); }

    @Override
    public List<Xxx> findAll() { return jt.query("select * from xxx",new BeanPropertyRowMapper<Xxx>(Xxx.class)); }
}
