package cn.edu.chzu.xxxy.se15.javaee.spring.service;

import cn.edu.chzu.xxxy.se15.javaee.spring.dao.ICustomerDAO;
import cn.edu.chzu.xxxy.se15.javaee.spring.po.Customer;

public class UserService implements IUserService {
	private ICustomerDAO customerDAO = null;
	
	public UserService(){
		System.out.println("create UserService.");
	}

	public void setCustomerDAO(ICustomerDAO customerDAO) {
		System.out.println("call setCustomerDAO in UserService.");
		this.customerDAO = customerDAO;
	}
	
	public void addUser(Customer cust) {
		System.out.println("execute --addUser()-- method.");
		customerDAO.save(cust);
	}
	
	public void delUser(Customer cust) {
		System.out.println("execute --delUser()-- method.");
		customerDAO.delete(cust);
	}
	
	public void updateUser(Customer cust) {
		System.out.println("execute --updateUser()-- method.");
		customerDAO.update(cust);
	}
	
	public void findUser(Customer cust) {
		System.out.println("execute --findUser()-- method.");
		String account = cust.getAccount();
		String password = cust.getPassword();
		String hql = "from Customer as user where account='" + account
				+ "' and password='" + password + "'";
		customerDAO.findByHQL(hql);
	}

	@Override
	public void register(Customer cust) {
		System.out.println("execute --register()-- method.");
		customerDAO.save(cust);
	}
}
