package cn.edu.chzu.xxxy.se15.javaee.spring.service;

import cn.edu.chzu.xxxy.se15.javaee.spring.po.Customer;

public interface IUserService {
	public void addUser(Customer cust);
	public void delUser(Customer cust);
	public void updateUser(Customer cust);
	public void findUser(Customer cust);
	
	public void register(Customer cust);
}