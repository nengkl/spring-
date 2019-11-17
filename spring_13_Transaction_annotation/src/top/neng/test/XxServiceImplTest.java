package top.neng.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.neng.configuration.springConfiguration;
import top.neng.entity.Xxx;
import top.neng.service.XxxService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {springConfiguration.class})
public class XxServiceImplTest {

    @Autowired
    XxxService service ;
    Xxx xxx ;

    @org.junit.Test
    public void insert() {
        xxx=new Xxx();
        xxx.setName("namei");
        xxx.setPw(1234);
        System.out.println(service.insert(xxx));
    }

    @org.junit.Test
    public void deleteById() {
        System.out.println(service.deleteById("1"));
    }

    @org.junit.Test
    public void update() {
        xxx=new Xxx();
        xxx.setId(8);
        xxx.setName("wusuopu");
        xxx.setPw(333);
        System.out.println(service.update(xxx));
    }

    @org.junit.Test
    public void findById() {
        System.out.println(service.findById("5"));
    }

    @org.junit.Test
    public void findAll() {
        System.out.println(service.findAll());
    }
}