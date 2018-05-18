package cn.edu.chzu.xxxy.se15.javaee.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ItemDAO extends BaseHibernateDAO{
	private static final Log log = LogFactory.getLog(ItemDAO.class);
		
	public List findAll() {
		log.debug("finding all Item instances");
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		try {
			//String queryString = "from Item";
			String queryString = "from ItemBasic";
			Query queryObject = session.createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} finally{
			session.close();
		}
	}
	
	public List findByHql(String hql) {
		log.debug("finding Item instance by hql");
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
		}
	}
}
