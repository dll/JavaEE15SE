package cn.edu.chzu.xxxy.se15.javaee.struts.action;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.chzu.xxxy.se15.javaee.hibernate.po.CustomerPO;
import cn.edu.chzu.xxxy.se15.javaee.hibernate.util.HibernateSessionFactory;

public class CustomerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7480076162614232311L;

	@Override
	public String execute() throws Exception{
		CustomerPO c = new CustomerPO();
		c.setAccount("javaee0");c.setPassword("123456");c.setName("dll");c.setGender("男");
		c.setBirthday(new Date());c.setAddress("9-1-102"); c.setPhone("138");c.setEmail("czldl@tom.com");
		c.setHobby("打球");c.setIntroduction("my...");
		System.out.println(c.toString());
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.save(c);
		tx.commit();		
		HibernateSessionFactory.closeSession();
		return null;
	}
	@Test
	public void add(){
		CustomerPO c = new CustomerPO();
		c.setAccount("javae");c.setPassword("123456");c.setName("dll");c.setGender("男");
		c.setBirthday(new Date());c.setAddress("9-1-102"); c.setPhone("138");c.setEmail("czldl@tom.com");
		c.setHobby("打球");c.setIntroduction("my...");
		System.out.println(c.toString());
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.save(c);
		tx.commit();		
		HibernateSessionFactory.closeSession();
	}
	
}
