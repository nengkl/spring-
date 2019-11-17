package top.neng.test;

import java.util.Iterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.neng.entity.Template;
import top.neng.service.XxxService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:top/neng/jdbcTemplate.xml"})
public class XxxServiceImplTest {
	ApplicationContext ac = new ClassPathXmlApplicationContext("top/neng/jdbcTemplate.xml");
	private XxxService xxxService = (XxxService)ac.getBean("XxxService");
	
	Template template;
	
	@Test
	public void testInsert() {
		template = new Template();
		template.setName("lufei");
		template.setJdbc(3);
		if (xxxService.insert(template)) {
			System.out.println("成功");
		} else {
			System.out.println("失败");
		}
	}

	@Test
	public void testDeleteById() {
		if (xxxService.deleteById("3")) {
			System.out.println("成功");
		} else {
			System.out.println("失败");
		}
	}

	@Test
	public void testUpdate() {
		template = new Template();
		template.setId(2);
		template.setName("suolong");
		template.setJdbc(2);
		if (xxxService.update(template)) {
			System.out.println("成功");
		} else {
			System.out.println("失败");
		}
	}

	@Test
	public void testFindById() {
		System.out.println(xxxService.findById("3"));
	}

	@Test
	public void testFindAll() {
		Iterator<Template> itrator = xxxService.findAll().iterator();
		while(itrator.hasNext()) {
			template = itrator.next();
			System.out.println(template.toString());
		}
	}

}
