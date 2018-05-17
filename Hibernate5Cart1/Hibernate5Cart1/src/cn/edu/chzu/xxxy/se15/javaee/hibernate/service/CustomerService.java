package cn.edu.chzu.xxxy.se15.javaee.hibernate.service;

import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.hibernate.dao.CustomerDAO;
import cn.edu.chzu.xxxy.se15.javaee.hibernate.po.Customer;

public class CustomerService {
	
	public boolean login(Customer loginUser) {
		String account = loginUser.getAccount();
		String password = loginUser.getPassword();
		String hql = "from Customer where account='" +account+ "' and password='" + password +"'";
		CustomerDAO dao = new CustomerDAO();				
		List list = dao.findByHql(hql);	
		if(list.isEmpty())
			return false;
		else
			return true;	
	}
}
