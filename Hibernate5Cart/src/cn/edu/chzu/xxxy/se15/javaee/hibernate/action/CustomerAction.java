package cn.edu.chzu.xxxy.se15.javaee.hibernate.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.chzu.xxxy.se15.javaee.hibernate.listener.HibernateCustomerListener;
import cn.edu.chzu.xxxy.se15.javaee.hibernate.po.CustomerPO;
import cn.edu.chzu.xxxy.se15.javaee.hibernate.util.HibernateSessionFactory;

@SuppressWarnings("serial")
public class CustomerAction extends ActionSupport implements ModelDriven<CustomerPO> {

	CustomerPO customer = new CustomerPO();
	List<CustomerPO> customerList = new ArrayList<CustomerPO>();
	
	public String execute() throws Exception {
		return SUCCESS;
	}
	@Override
	public CustomerPO getModel() {
		return customer;
	}
	
	public List<CustomerPO> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerPO> customerList) {
		this.customerList = customerList;
	}

	//save customer
	public String addCustomer() throws Exception{
		
/*		//get hibernate session from the servlet context
		SessionFactory sessionFactory = 
	         (SessionFactory) ServletActionContext.getServletContext()
                     .getAttribute(HibernateCustomerListener.KEY_NAME);

		Session session = sessionFactory.openSession();

		//save it	 
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();*/
	 

		
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
		
		//reload the customer list
		customerList = null;
		customerList = session.createQuery("from CustomerPO").list();
		
		return "add";
	
	}
	
	//list all customers
	public String listCustomer() throws Exception{
		
		//get hibernate session from the servlet context
		SessionFactory sessionFactory = 
	         (SessionFactory) ServletActionContext.getServletContext()
                     .getAttribute(HibernateCustomerListener.KEY_NAME);

		Session session = sessionFactory.openSession();

		customerList = session.createQuery("from CustomerPO").list();
		
		return "list";
	
	}	
}
