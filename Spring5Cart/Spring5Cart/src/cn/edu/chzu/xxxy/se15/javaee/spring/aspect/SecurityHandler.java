package cn.edu.chzu.xxxy.se15.javaee.spring.aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecurityHandler {
      /** 定义Pointcut,Pointcut的名称是modify，
       * 此方法不能有返回值和参数，该方法只是一个标识*/
      @Pointcut("execution(* add*(..)) || execution(* del*(..)) || execution(* update*(..))")
      private void modify(){};
      /** 定义Advice，标识在那个切入点处织入此方法 */
      @Before("modify()")
      private void checkSecurity() { 
              System.out.println("---checkSecurity()---");  }
}
