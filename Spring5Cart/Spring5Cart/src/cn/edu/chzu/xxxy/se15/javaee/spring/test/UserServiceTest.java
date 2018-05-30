package cn.edu.chzu.xxxy.se15.javaee.spring.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.chzu.xxxy.se15.javaee.spring.dao.ICustomerDAO;
import cn.edu.chzu.xxxy.se15.javaee.spring.po.Customer;
import cn.edu.chzu.xxxy.se15.javaee.spring.service.IUserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {

	@Autowired 
	ICustomerDAO userDao;
	
	@Test
	public void testSave() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("before ctx.getBean.");
		IUserService userService = (IUserService) ctx.getBean("userService");
		//userService.register();
	}
	@Test
	public void testRegister() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("before ctx.getBean.");
		IUserService userService = (IUserService) ctx.getBean("userService");
		System.out.println("after ctx.getBean.");
		Customer cust = new Customer();
		cust.setAccount("SPRING");
		cust.setPassword("SPRING");
		userService.register(cust);
	}
}
