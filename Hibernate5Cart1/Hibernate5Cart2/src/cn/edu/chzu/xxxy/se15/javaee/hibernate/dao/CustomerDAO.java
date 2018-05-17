package cn.edu.chzu.xxxy.se15.javaee.hibernate.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.query.Query;

import cn.edu.chzu.xxxy.se15.javaee.hibernate.po.Customer;

public class CustomerDAO extends BaseHibernateDAO{
	private static final Log log = LogFactory.getLog(CustomerDAO.class);
	
	public void save(Customer instance) {
		log.debug("saving Customer instance");
		try {
			getSession().save(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(Customer instance) {
		log.debug("saving Customer instance");
		try {
			getSession().update(instance);
			//getSession().merge(instance);
			log.debug("saveOrUpdate successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Customer instance) {
		log.debug("deleting Customer instance");
		try {
			getSession().delete(instance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public List findByHql(String hql) {
		log.debug("finding Customer instance by hql");
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
		}
	}
	
	public Customer findById(java.lang.Integer id) {
		log.debug("getting Customer instance with id: " + id);
		try {
			Customer instance = (Customer) getSession().get("cn.edu.chzu.xxxy.se15.javaee.hibernate.po.Customer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Customer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Customer as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

}
