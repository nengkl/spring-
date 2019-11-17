package top.neng.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("notic")
@Aspect
public class notice {
    @Pointcut("execution(* top.neng.Service.ServiceImpl.*.*(..))")
    private void pt1(){}

    @Before("pt1()")
    public void before(){
        System.out.println("@Before");
    }
    @AfterReturning("pt1()")
    public void end(){
        System.out.println("@AfterReturning");
    }
    @After("pt1()")
    public void after(){
        System.out.println("@After");
    }
    @AfterThrowing("pt1()")
    public void Exception(){
        System.out.println("@AfterThrowing");
    }

   /* @Around("pt1()")
    public Object around(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            System.out.println("around开启事务");
            rtValue = pjp.proceed();
            System.out.println("around提交事务");
        } catch (Throwable throwable) {
            System.out.println("around回滚事务");
            throwable.printStackTrace();
        }finally {
            System.out.println("arround结束");
        }
        return rtValue;
    }*/
}
