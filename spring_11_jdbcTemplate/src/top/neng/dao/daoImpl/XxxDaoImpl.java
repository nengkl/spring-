package top.neng.dao.daoImpl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import top.neng.dao.XxxDao;
import top.neng.entity.Template;

public class XxxDaoImpl implements XxxDao{

	JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	@Override
	public int insert(Template template) {
		return jt.update("insert into template (name,jdbc)values(?,?)",template.getName(),template.getJdbc());
	}

	@Override
	public int deleteById(String id) {
		return jt.update("delete from template where id=?",id);
	}

	@Override
	public int Update(Template template) {
		return jt.update("update template set name=?,jdbc=? where id=?",template.getName(),template.getJdbc(),template.getId());
	}

	@Override
	public Template findById(String id) {
		return jt.query("select * from template where id=?",new BeanPropertyRowMapper<Template>(Template.class),id).get(0);
	}

	@Override
	public List<Template> findAll() {
		return jt.query("select * from template",new BeanPropertyRowMapper<Template>(Template.class));
	}

}
