package cn.edu.chzu.xxxy.se15.javaee.hibernate.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.chzu.xxxy.se15.javaee.hibernate.dao.CustomerDAO;
import cn.edu.chzu.xxxy.se15.javaee.hibernate.dao.ItemDAO;
import cn.edu.chzu.xxxy.se15.javaee.hibernate.listener.HibernateCustomerListener;
import cn.edu.chzu.xxxy.se15.javaee.hibernate.po.Customer;
import cn.edu.chzu.xxxy.se15.javaee.hibernate.util.HibernateSessionFactory;
import cn.edu.chzu.xxxy.se15.javaee.struts.service.CustomerService;

@SuppressWarnings("serial")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	Customer customer = new Customer();

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	List<Customer> customerList = new ArrayList<Customer>();

	public String execute() throws Exception {
		return SUCCESS;
	}

	@Override
	public Customer getModel() {
		return customer;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	// save customer
	public String register() throws Exception{
	//public boolean register() throws Exception{
		CustomerService userServ = new CustomerService();
		if (userServ.register(customer)) {
			return "regSuccess";
		}
		return "regFail";
		/*String account = customer.getAccount();
		String password = customer.getPassword();
		String hql = "from customers as user where account='" +account+ "' and password='" + password +"'";
		CustomerDAO dao = new CustomerDAO();				
		List list = dao.findByHql(hql);	
		if(list.isEmpty())
			return true;
		else
			return false;*/
	}

	// list all customers
	public boolean listCustomer() throws Exception {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		customerList = session.createQuery("from customers").list();
		if(customerList.isEmpty())
			return false;
		else
			return true;
	}
	
	@Test
	public void add(){
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx = session.beginTransaction();
		Customer c = new Customer();
		c.setAccount("javae");c.setPassword("123456");c.setName("dll");c.setGender("男");
		c.setBirthday(new Date());c.setAddress("9-1-102"); c.setPhone("138");c.setEmail("czldl@tom.com");
		c.setHobby("打球");c.setIntroduction("my...");
		
		session.save(c);
		tx.commit();		
		session.close();
	}
}
