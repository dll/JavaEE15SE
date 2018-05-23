package cn.edu.chzu.xxxy.se15.javaee.spring.dao;

import cn.edu.chzu.xxxy.se15.javaee.spring.po.Customer;

public interface ICustomerDAO {
	void save(Customer transientInstance);
	void delete(Customer transientInstance);
	void update(Customer transientInstance);
	void findAll();
	void findByHQL(String hql);
}
