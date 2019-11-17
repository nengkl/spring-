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
 * 1.����bean��ע�⣺
 * 			@Component
 * 			@Controller
 * 			@RestController
 * 			@Service
 * 			@Repository
 * 2.ע��bean��ע�⣺
 * 			@AutuWired
 * 				�Զ�װ��
 * 			@Qualifier
 * 				�Զ�װ������ϸ���idװ��,���β�ǰ����idע��(@Qualifier("ds1") DataSource ds)
 * 			@Resource
 * 				����idװ��(���ԣ�name)
 * 3.ע��ֵdeע��:
 * 			@value
 * 				�磺@value("${jdbc.driver}")��xxx.properties�����ļ�����jdbc.driver
 * 4.����bean���÷�Χ��ע�⣺
 * 			@Scope
 * 				singleton:������prototype��������request��session��globalsession
 * 5.����spring������
 * 			@Configuration
 * 				����������һ��spring������
 * 6.�ѷ���ֵ��Ϊbean
 * 			@bean
 * 				�ѷ�������ֵ������Ϊbean�Ž�spring����
 * 7.ָʾspringɨ���
 *    		@ComponentScan
 *    			@ComponentScan("top.nengkl")ɨ��top.nengklĿ¼�µİ�ע��
 * 8.��������spring������
 * 			@Import
 * 				@Import(jdbcConfiguration.class)����jdbcConfiguration������
 * 9.����properties�����ļ�
 * 			@PropertySource
 * 				@PropertySource("classpath:springConfiguration/jdbc.properties")
 * 				������·����springConfigurationĿ¼�µ�dbc.properties�����ļ�
 * 10.ע�ⷽʽȡ��bean
 * 			ApplicationContext ac = new AnnotationConfigApplicationContext(springConfiguration.class);
 * 11.spring����Junit
 * 			��һ������jar����spring-test
 * 					�磺spring-test-5.0.7.RELEASE.jar
 * 			�ڶ�����ʹ��@RunWithע��Ѳ����õ�main��������spring�ṩ��main������SpringJUnit4ClassRunner
 * 					@RunWith(SpringJUnit4ClassRunner.class)
 * 			����������ע��@ContextConfiguration����spring�����ļ�����ע�������ڵ�λ��
 * 					�磺@ContextConfiguration(classes= {springConfiguration.class})
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
		customer.setName("��֮��");
		customer.setAge(21);
		customerController.updateApi(customer);
	}

	@Test
	public void testInsert() {
		customer.setId(235);
		customer.setName("��֮��ͷ");
		customer.setAge(22);
		customerController.insert(customer);
	}

	@Test
	public void testFindByIdApi(){
		System.out.println(customerController.findByIdApi(235).toString());
	}
	
	
}
