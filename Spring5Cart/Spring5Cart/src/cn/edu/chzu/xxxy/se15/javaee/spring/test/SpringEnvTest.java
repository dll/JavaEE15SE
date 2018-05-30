package cn.edu.chzu.xxxy.se15.javaee.spring.test;

import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.chzu.xxxy.se15.javaee.spring.event.EmailEvent;
import cn.edu.chzu.xxxy.se15.javaee.spring.po.Customer;
import cn.edu.chzu.xxxy.se15.javaee.spring.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext9.xml")
public class SpringEnvTest {
		
	@Test
	public void testLocale() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext9.xml");
		Object[] objects=new Object[]{"HelloWorld", new Date()};
		String message=ctx.getMessage("HelloWorld", objects, Locale.CHINA);
		System.out.println(message);
		String message1=ctx.getMessage("HelloWorld", objects, Locale.US);
		System.out.println(message1);
	}
	@Test
	public void testEvent() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext9.xml");
		EmailEvent ele = new EmailEvent("hello", "czldl@tom.com", "this is a test");
		ctx.publishEvent(ele); 	
	}
	
	@Test
	public void testProxy() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext10.xml");
		IUserService userService = (IUserService) ctx.getBean("logProxy");
		Customer cust = new Customer();
		cust.setAccount("java");
		cust.setPassword("123");
		userService.addUser(cust);   
	}

}
