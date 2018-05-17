package cn.edu.chzu.xxxy.se15.javaee.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static Configuration configuration = new Configuration();    
    private static org.hibernate.SessionFactory sessionFactory;
    private static String configFile = CONFIG_FILE_LOCATION;

	static {
    	try {
			//configuration.configure(configFile);
    		configuration
    		    //通过setProperty方法设置Hibernate的连接属性
    		    .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
    		    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate5cartdb")
    		    .setProperty("hibernate.connection.username", "root")
    		    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect")
    		    //通过addResource方法添加映射文件
    		    .addResource("cn/edu/chzu/xxxy/se15/javaee/hibernate/po/Customer.hbm.xml")
    		    .addResource("cn/edu/chzu/xxxy/se15/javaee/hibernate/po/Item.hbm.xml");
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("Error Creating SessionFactory");
			e.printStackTrace();
		}
    }
	
    private HibernateUtil() {
    }
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession()
					: null;
			threadLocal.set(session);
		}

        return session;
    }
	public static void rebuildSessionFactory() {
		try {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("Error Creating SessionFactory");
			e.printStackTrace();
		}
	}
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }
	public static org.hibernate.SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void setConfigFile(String configFile) {
		HibernateUtil.configFile = configFile;
		sessionFactory = null;
	}
	public static Configuration getConfiguration() {
		return configuration;
	}

}
