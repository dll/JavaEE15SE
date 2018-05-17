package cn.edu.chzu.xxxy.se15.javaee.struts.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.hibernate.dao.CustomerDAO;
import cn.edu.chzu.xxxy.se15.javaee.hibernate.po.Customer;
import cn.edu.chzu.xxxy.se15.javaee.struts.bean.UserBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.dao.DaoFactory;
import cn.edu.chzu.xxxy.se15.javaee.struts.exception.UserException;

/**
 * UserService层完成JSP-》Action和DAO-》Bean-》DB之间的业务逻辑
 * */
public class CustomerService {
	
	public boolean register(Customer registUser) throws Exception{
		String account = registUser.getAccount();
		String password = registUser.getPassword();
		String hql = "from customers as user where account='" +account+ "' and password='" + password +"'";
		CustomerDAO dao = new CustomerDAO();				
		List list = dao.findByHql(hql);	
		if(list.isEmpty())
			return true;//顾客不存在，可以注册
		else
			return false;//顾客已存在，不可以注册
	}
}
