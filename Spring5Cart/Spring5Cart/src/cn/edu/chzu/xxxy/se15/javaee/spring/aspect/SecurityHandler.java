package cn.edu.chzu.xxxy.se15.javaee.spring.aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecurityHandler {
      /** ����Pointcut,Pointcut��������modify��
       * �˷��������з���ֵ�Ͳ������÷���ֻ��һ����ʶ*/
      @Pointcut("execution(* add*(..)) || execution(* del*(..)) || execution(* update*(..))")
      private void modify(){};
      /** ����Advice����ʶ���Ǹ�����㴦֯��˷��� */
      @Before("modify()")
      private void checkSecurity() { 
              System.out.println("---checkSecurity()---");  }
}
