package cn.edu.chzu.xxxy.se15.javaee.spring.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.chzu.xxxy.se15.javaee.spring.bean.IItemOrder;

public class ItemOrderTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IItemOrder itemorder1 = (IItemOrder) ctx.getBean("itemorder1");
		assertEquals("JAVAEE技术实验指导教程", itemorder1.getItem().getTitle());
		assertEquals(1,itemorder1.getNumItems());		
	}
}
