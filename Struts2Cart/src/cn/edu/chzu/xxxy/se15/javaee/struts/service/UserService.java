package cn.edu.chzu.xxxy.se15.javaee.struts.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.struts.bean.UserBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.dao.DaoFactory;
import cn.edu.chzu.xxxy.se15.javaee.struts.exception.UserException;

public class UserService {
	
	public boolean login(UserBean loginUser) throws Exception{
//		String account="javaee";
//		String password="123456";
		
		if (loginUser.getAccount().equalsIgnoreCase("admin")){
			throw new UserException("用户名不能为admin");
		}
		if (loginUser.getPassword().toUpperCase().contains(" AND ")||loginUser.getPassword().toUpperCase().contains(" OR ")){
			throw new java.sql.SQLException("密码不能包括' and '或' or '");
		}
		/*if(account.equals(loginUser.getAccount())
				&& password.equals(loginUser.getPassword()))*/
		boolean result = DaoFactory.getUserDaoInstance().login(loginUser.getAccount(),loginUser.getPassword());
		if(result)
			return true;
		else
			return false;
	}
	
	public boolean register(UserBean registUser) throws Exception{

		if (registUser.getAccount().equalsIgnoreCase("admin")){
			throw new UserException("用户名不能为admin");
		}
		if (registUser.getPassword().toUpperCase().contains(" AND ")||registUser.getPassword().toUpperCase().contains(" OR ")){
			throw new java.sql.SQLException("密码不能包括' and '或' or '");
		}
		if (registUser.getAccount()==""||registUser.getPassword()=="")
			return false;
		
		boolean result = DaoFactory.getUserDaoInstance().save(registUser);
		if(result)
			return true;
		else
			return false;
	}
	private static List<UserBean> users = new ArrayList<UserBean>();

	public List<UserBean> getAllUsers() {
		try {
			users=DaoFactory.getUserDaoInstance().findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(users.size()==0){
			users.add(new UserBean("admin","123",1));
			users.add(new UserBean("javaee", "123456", 1));
		}
		return users;
	}

	public static UserBean getUser(String account) {
		UserBean user;
		Iterator<UserBean> it = users.iterator();
		while (it.hasNext()) {
			user = (UserBean) it.next();
			if (account.equals(user.getAccount())) {
				return (user);
			}
		}
		return (null);
	}
}
