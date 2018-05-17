package cn.edu.chzu.xxxy.se15.javaee.hibernate.dao;

import org.hibernate.Session;

public class BaseHibernateDAO{
	
	public Session getSession() {
		return HibernateUtil.getSession();
	}
	
}