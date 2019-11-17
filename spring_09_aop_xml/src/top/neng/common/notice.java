package top.neng.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class notice {
    public void before(){
        System.out.println("@before");
    }
    public void afterReturning(){
        System.out.println("@after-returning");
    }
    public void afterThrowing(){
        System.out.println("@after-throwing");
    }
    public void after(){
        System.out.println("@after");
    }
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
    }
}
