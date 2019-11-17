package top.neng.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.neng.Service.Xx1Service;
import top.neng.entity.Xxx;

import javax.annotation.Resource;

/*
*   要导入aspectjweaver-1.6.2.jar和spring-aop的jar
*   1.写好通知类，在spring中配置通知类
*   2.配置切入点表达式
*   3.配置切面
*       <aop:config>
*               切入点表达式：写在<aop:aspect></aop:aspect>内部则仅该切面有效，写在最上面所有切面有效
*               <aop:pointcut id="ServiceTransactions" expression="execution(* top.neng.Service.ServiceImpl.*.*(..))"/>
*               切面：
*               <aop:aspect id="Transactions" ref="notice">
*                   1.前置：<aop:before method="before" pointcut-ref="ServiceTransactions"/>
*                   2.后置：<aop:after-returning method="after" pointcut-ref="ServiceTransactions"/>
*                   3.异常：<aop:after-throwing method="Exception" pointcut-ref="ServiceTransactions"/>
*                   4.最终：<aop:after method="end" pointcut-ref="ServiceTransactions"/>
*
*                   环绕：<aop:around method="around" pointcut-ref="ServiceTransactions"></aop:around>-->
*               </aop:aspect>
*        </aop:config>
*   4.关于通知类环绕通知的方法：
*        //固定写法
*        public Object around(ProceedingJoinPoint pjp){
*            Object rtValue = null;
*            try{
*                1.前置
*                System.out.println("around开启事务");
*                rtValue = pjp.proceed();
*                2.后置
*                System.out.println("around提交事务");
*            } catch (Throwable throwable) {
*                3.异常
*                System.out.println("around回滚事务");
*                throwable.printStackTrace();
*            }finally {
*                4.最终
*                System.out.println("arround结束");
*            }
*            return rtValue;
*        }
*   5.关于切入点表达式通配符；
*       关键字：execution()
*       完整写法：访问修饰符 返回值 包名.包名...类名.方法名(参数列表)
*           public void top.neng.Service.ServiceImpl.XxServiceImpl.findById(Stirng)
*       1.public可以省略，返回值可以用通配符*代替，包名也可以用*代替，*..*代表及其子包的多个包、
*           * top.*.*.*.*.findById(String) or  * *..*.findById(String)
*       2.方法名可以用*代替，参数类型可以用*代表，..代表有参无参都可以
*           * *..*.*(*)  or  * *..*.*(..)
*       3.开发常用写法
*           * top.neng.Service.ServiceImpl.*.*(..)
* */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/aop.xml"})
public class Xx1ServiceImplTest {

    @Autowired
    @Qualifier("Xx1Service")
    private Xx1Service xx1Service;

    @Resource(name = "xxx")
    private Xxx xxx;

    @org.junit.Test
    public void insert() {
        xx1Service.insert(xxx);
    }

    @org.junit.Test
    public void update() {
        xx1Service.update(xxx);
    }

    @org.junit.Test
    public void delete() {
        xx1Service.delete("id");
    }

    @org.junit.Test
    public void findById() {
        xx1Service.findById("id");
    }

    @org.junit.Test
    public void findAll() {
        xx1Service.findAll();
    }
}