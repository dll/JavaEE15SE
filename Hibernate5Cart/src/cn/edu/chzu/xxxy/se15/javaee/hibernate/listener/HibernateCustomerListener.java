package cn.edu.chzu.xxxy.se15.javaee.hibernate.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.net.URL;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
@WebListener
public class HibernateCustomerListener implements ServletContextListener {
    private Configuration config;
    private SessionFactory factory;
    private String path = "/hibernate.cfg.xml";
    private static Class<HibernateCustomerListener> clazz = HibernateCustomerListener.class;
 
    public static final String KEY_NAME = clazz.getName();
    
    /**
     * Default constructor. 
     */
    public HibernateCustomerListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	 try { 
 	        URL url = HibernateCustomerListener.class.getResource(path);
 	        config = new Configuration().configure(url);
 	        factory = config.buildSessionFactory();
 	        sce.getServletContext().setAttribute(KEY_NAME, factory);
 	  } catch (Exception e) {
 	         System.out.println(e.getMessage());
 	   }
 	}
	
}
