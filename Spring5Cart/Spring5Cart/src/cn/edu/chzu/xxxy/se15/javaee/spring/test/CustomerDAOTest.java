package cn.edu.chzu.xxxy.se15.javaee.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.chzu.xxxy.se15.javaee.spring.dao.ICustomerDAO;
import cn.edu.chzu.xxxy.se15.javaee.spring.po.Customer;
import cn.edu.chzu.xxxy.se15.javaee.spring.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CustomerDAOTest {
	@Autowired 
	ICustomerDAO userDao;
	IUserService userService;
	Customer cust;
	
	@Test
	public void testSave() {
		//fail("Not yet implemented");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("before ctx.getBean.");
		userDao = (ICustomerDAO) ctx.getBean("userDAO");
		System.out.println("after ctx.getBean.");
		cust = new Customer();
		cust.setAccount("SPRING");
		cust.setPassword("SPRING");
		userDao.save(cust);  
	}
	@Test
	public void testAdd() {
		//初始化spring容器，加载配置文件
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		//通过容器获取userService实例
		userService = (IUserService) ctx.getBean("userService");
		cust = new Customer();
		cust.setAccount("SPRING");
		cust.setPassword("SPRING");
		//调用userService的addUser()方法
		userService.addUser(cust);  
	}
	
	@Test
	public void testTransaction() {
		//初始化spring容器，加载配置文件
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext10.xml");
		//通过容器获取userService实例
		userService = (IUserService) ctx.getBean("userService");
		cust = new Customer();
		cust.setAccount("SPRING");
		cust.setPassword("SPRING");
		//调用userService的addUser()方法
		userService.addUser(cust);  
	}
}
