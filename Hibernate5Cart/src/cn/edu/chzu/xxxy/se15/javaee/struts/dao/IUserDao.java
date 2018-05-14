package cn.edu.chzu.xxxy.se15.javaee.struts.dao;

import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.struts.bean.UserBean;

public interface IUserDao {
	public boolean login(String account,String password) throws  Exception;
	public boolean save(UserBean user) throws  Exception;
	public boolean delete(String account) throws  Exception;
	public boolean update(String account,UserBean user) throws  Exception;
	public List<UserBean> findAll() throws  Exception;
	public UserBean findByAccount(String account) throws  Exception;
}
