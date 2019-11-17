package top.nengkl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springConfiguration.springConfiguration;
import top.nengkl.controller.customerController;
import top.nengkl.entity.Customer;

/**
 * @author nengkl
 * 1.声明bean的注解：
 * 			@Component
 * 			@Controller
 * 			@RestController
 * 			@Service
 * 			@Repository
 * 2.注入bean的注解：
 * 			@AutuWired
 * 				自动装配
 * 			@Qualifier
 * 				自动装配基础上根据id装配,或形参前根据id注入(@Qualifier("ds1") DataSource ds)
 * 			@Resource
 * 				根据id装配(属性：name)
 * 3.注入值de注解:
 * 			@value
 * 				如：@value("${jdbc.driver}")从xxx.properties配置文件中找jdbc.driver
 * 4.声明bean作用范围的注解：
 * 			@Scope
 * 				singleton:单例、prototype：多例、request、session、globalsession
 * 5.声明spring配置类
 * 			@Configuration
 * 				声明该类是一个spring配置类
 * 6.把返回值作为bean
 * 			@bean
 * 				把方法返回值对象作为bean放进spring容器
 * 7.指示spring扫描包
 *    		@ComponentScan
 *    			@ComponentScan("top.nengkl")扫描top.nengkl目录下的包注解
 * 8.导入其他spring配置类
 * 			@Import
 * 				@Import(jdbcConfiguration.class)导入jdbcConfiguration配置类
 * 9.加载properties配置文件
 * 			@PropertySource
 * 				@PropertySource("classpath:springConfiguration/jdbc.properties")
 * 				加载类路径下springConfiguration目录下的dbc.properties配置文件
 * 10.注解方式取得bean
 * 			ApplicationContext ac = new AnnotationConfigApplicationContext(springConfiguration.class);
 * 11.spring整合Junit
 * 			第一步：导jar包：spring-test
 * 					如：spring-test-5.0.7.RELEASE.jar
 * 			第二步：使用@RunWith注解把测试用的main函数换成spring提供的main函数：SpringJUnit4ClassRunner
 * 					@RunWith(SpringJUnit4ClassRunner.class)
 * 			第三步：用注解@ContextConfiguration告诉spring配置文件或者注解类所在的位置
 * 					如：@ContextConfiguration(classes= {springConfiguration.class})
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {springConfiguration.class})
public class customerControllerTest {
	
	@Autowired
	private customerController customerController;
	
	@Autowired
	private Customer customer;

	@Test
	public void testDeleteApi() {
		customerController.deleteApi(235);
	}

	@Test
	public void testUpdateApi() {
		customer.setId(235);
		customer.setName("付之猪");
		customer.setAge(21);
		customerController.updateApi(customer);
	}

	@Test
	public void testInsert() {
		customer.setId(235);
		customer.setName("付之猪头");
		customer.setAge(22);
		customerController.insert(customer);
	}

	@Test
	public void testFindByIdApi(){
		System.out.println(customerController.findByIdApi(235).toString());
	}
	
	
}
