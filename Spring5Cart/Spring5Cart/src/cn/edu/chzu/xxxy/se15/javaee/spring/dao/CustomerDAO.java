package cn.edu.chzu.xxxy.se15.javaee.spring.dao;

import cn.edu.chzu.xxxy.se15.javaee.spring.po.Customer;

public class CustomerDAO extends BaseHibernateDAO implements ICustomerDAO{
	public CustomerDAO(){
		System.out.println("create CustomerDao.");
	}
	public void save(Customer transientInstance) {
		System.out.println("execute --save()-- method.");
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public void delete(Customer transientInstance) {
		System.out.println("execute --delete()-- method.");
	}
	public void update(Customer transientInstance) {
		System.out.println("execute --update()-- method.");
	}
	public void findAll() {
		System.out.println("execute --findAll()-- method.");
	}
	public void findByHQL(String hql) {
		System.out.println("execute --findByHQL()-- method.");
	}
}
