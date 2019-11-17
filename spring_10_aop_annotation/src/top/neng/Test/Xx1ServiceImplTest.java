package top.neng.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.neng.Service.Xx1Service;
import top.neng.common.SpringConfiguration;
import top.neng.entity.Xxx;

import javax.annotation.Resource;

/*
*   基于注解的aop
*       1.在配置文件中添加<aop:aspectj-autoproxy />或者在
*         配置类添加@EnableAspectjAutoProxy来支持aop的注解
*       2.在通知类添加@Component把通知类交给Spring管理
*       3.在通知类添加@Aspect注解
*       4.添加切入点表达式： @Pointcut("execution(* top.neng.Service.ServiceImpl.*.*(..))")
*                           private void pt1(){}
*       5.方法上添加对应注解：
*                   前置： @Before("pt1()")
*                   后置： @AfterReturning("pt1()")
*                   异常： @AfterThrowing("pt1()")
*                   最终： @After("pt1()")
*                   环绕： @Around("pt1()")
*       notice：通知类上@Component注解容易忘
*               AfterReturning与AfterThrowing不可能共存，异常时AfterReturning变成Afterthrowing
*       当不使用around通知时
*               在XML配置的aop中：		 try{
*                                   //Before
*                                   method.invoke(..)
*                                   //AfterReturning
*                               }catch(...){
*                                   //AfterThrowing
*                               }finally{
*                                   //After
*                               }
*               所以执行顺序：Before->原方法->AfterReturning->After
*
*               而在注解的aop中：try{
*                                   try{
*                                       @Before
*                                       method.invoke(..)
*                                   }finally{
*                                       @After
*                                   }
*                                   @AfterReturning
*                               }
*                               catch(...){
*                                   @AfterThrowing
*                               }
*               所以执行顺序：Before->原方法->After->AfterReturning
*
*       报错： error at ::0 can't find referenced pointcut pt1
*       原因： aspectjweaver.jar版本过低
* */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class Xx1ServiceImplTest {

    @Autowired
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