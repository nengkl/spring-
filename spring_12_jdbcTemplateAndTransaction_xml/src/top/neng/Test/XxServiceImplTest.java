package top.neng.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.neng.entity.Xxx;
import top.neng.service.XxService;

/*
* jdbcTemplate
*	与DButils用法一样，先配置jdbcTemplate
* 	注入数据源，用spring的datasource或c3p0或其他都可以
* ***使用jdbcTemplate报错，需要在datasource的url后面添加&amp;serverTimezone=UTC
* 
* spring事务管理
*	第一步：配置事务管理器
*       jdbc和mybatis用DataSourceTransactionManager
*       hibernate用HibernatetTransactionManager
*       Jpa用JpaTransactionManager
*	第二步
*  		给事务管理器注入数据源
*	第三步
*  		配置事务通知
*            <tx:advice id="txAdvice" transaction-manager="TransacionManager">
*               <tx:attributes>
*                   <!-- *表示所有方法，find*表示所有find开头的方法 -->
*                   <tx:method name="*"/>
*                   <tx:method name="find*" read-only="true" propagation="SUPPORTS"></tx:method>
*               </tx:attributes>
*           </tx:advice>
*  	第四步
* 		 配aop
*           <aop:config>
*               <aop:pointcut id="pt1" expression="execution(* top.neng.service.serviceImpl.*.*(..))"/>
*               <aop:advisor advice-ref="txAdvice" pointcut-ref="pt1"></aop:advisor>
*           </aop:config>
*
*  		关于事务通知的属性：
*           isolation:  配置事务的隔离级别，默认值：DEFAULT，即使用数据库的默认隔离级别。
*                       sqlserver、oracal等都是READ-COMMITTED，mysql是Repeatable read
*           propagation:配置事务的传播行为。默认值：REQUIRED（增删改方法一般的选择），查询
*                       	多用SUPPORTS。
*           timeout:    指定事务超时时间，默认值-1，单位s
*           read-only： 配置是否只读事务，默认值：false，读写型事务，当指定为ture表示只读，
*                       true只能用于查询
*           rollback-for：用于指定一个异常，当执行产生该异常时事务回滚，产生其他异常时不回滚
*           no-rollback-for:用于指定一个异常，除了该异常其他异常都回滚
*           				当不配置rollback-for 和 no-rollback-for的时候所有异常都回滚
*
*           propagation属性详细：1.REQUIRED：支持当前事务，如果当前有事务， 那么加入事务，
*                           	如果当前没有事务则新建一个(默认情况)
*                               2.NOT_SUPPORTED： 以非事务方式执行操作，如果当前存在事务
*                            	就把当前事务挂起，执行完后恢复事务（忽略当前事务）；
*                               3.MANDATORY：支持当前事务，如果当前没有事务，则抛出
*                           		 异常。（当前必须有事务）
*                               4.NEVER：以非事务方式执行，如果当前存在事务，则抛出
*                           		异常。（当前必须不能有事务）
*                               5.REQUIRES_NEW：支持当前事务，如果当前有事务，则挂
*                        			起当前事务，然后新创建一个事务，如果当前没有事务，
*                         			则自己创建一个事务
*                               6.NESTED(嵌套事务)：如果当前存在事务，则嵌套在当前
*                                	 事务中。如果当前没有事务，则新建一个事务自己执行
*                                	（和required一样）。嵌套的事务使用保存点作为回滚点
*                                 	，当内部事务回滚时不会影响外部事物的提交；但是外部
*                               	  回滚会把内部事务一起回滚回去（这个和新建一个事务的区别）
*
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:top/neng/bean.xml"})
public class XxServiceImplTest {

    @Autowired
    XxService service ;
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