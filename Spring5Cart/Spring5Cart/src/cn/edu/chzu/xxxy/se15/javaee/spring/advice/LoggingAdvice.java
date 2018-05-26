package cn.edu.chzu.xxxy.se15.javaee.spring.advice;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;
import java.util.Date;

/*
public class LoggingAdvice implements MethodBeforeAdvice {

    public void before(Method m,Object[] args,Object target)
            throws Throwable {
    	String date1 = (new Date()).toLocaleString();
        System.out.println("��Ϣ��[logging before ]["+date1+"]�û� "+args[0]+" �����޸ĸ�����Ϣ...");
    }
}
*/
public class LoggingAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method,
            Object[] args, Object target) throws Throwable {
    	String date2 = (new Date()).toLocaleString();
        System.out.println("��Ϣ��[logging after ]["+date2+"]�û� "+args[0]+" �ɹ��޸ĸ�����Ϣ...");
        
    }

    @Override
    public void before(Method method, Object[] args, Object target)
            throws Throwable {
    	String date1 = (new Date()).toLocaleString();
        System.out.println("��Ϣ��[logging before ]["+date1+"]�û� "+args[0]+" �����޸ĸ�����Ϣ...");
        
    }

}
