package cn.edu.chzu.xxxy.se15.javaee.struts.dao;

import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.struts.bean.CustomerBean;

public interface ICustmerDao {
	public boolean login(String custmername,String password) throws  Exception;
	public boolean save(CustomerBean user) throws  Exception;
	public boolean delete(String custmername) throws  Exception;
	public boolean update(String custmername, CustomerBean user) throws  Exception;
	public List<CustomerBean> findAll() throws  Exception;
	public CustomerBean findByCustName(String custmername) throws  Exception;
}
