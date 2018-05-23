package cn.edu.chzu.xxxy.se15.javaee.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseHibernateDAO{
	 
    private SessionFactory sessionFactory;
	
	public Session getSession(){  
        //return sessionFactory.openSession(); 
        return sessionFactory.getCurrentSession(); 
    }

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}