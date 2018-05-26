package cn.edu.chzu.xxxy.se15.javaee.spring.advice;

import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation invo) throws Throwable {
		Object[] args = invo.getArguments();

		String date1 = (new Date()).toLocaleString();
		System.out.println("Interceptor��Ϣ��[logging before ][" + date1 + "]�û� " + args[0]
				+ " �����޸ĸ�����Ϣ...");

		Object returnObject = invo.proceed();

		String date2 = (new Date()).toLocaleString();
        System.out.println("Interceptor��Ϣ��[logging after ]["+date2+"]�û� "+args[0]+" �ɹ��޸ĸ�����Ϣ...");
        
		return args;
	}

}
