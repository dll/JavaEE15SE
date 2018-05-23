package cn.edu.chzu.xxxy.se15.javaee.spring.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.chzu.xxxy.se15.javaee.spring.bean.IItem;

public class ItemTest {

	@Test
	public void testItem() {
		//fail("Not yet implemented");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IItem item1 = (IItem) ctx.getBean("item1");
		assertEquals(item1.getItemID(),"978-7-121-12345-1");
		assertEquals(item1.getTitle(),"JAVAEE技术实验指导教程");
		assertEquals(item1.getDescription(),"WEB程序设计知识回顾、轻量级JAVAEE应用框架、企业级EJB组件编程技术、JAVAEE综合应用开发");
		assertEquals(item1.getCost(),19.95,0.000001);
	}

}
