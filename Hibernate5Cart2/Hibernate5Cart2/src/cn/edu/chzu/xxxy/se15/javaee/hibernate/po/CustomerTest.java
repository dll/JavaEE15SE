package cn.edu.chzu.xxxy.se15.javaee.hibernate.po;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    @Before
    public void setUp() throws Exception
    {
        // 创建配置文件
        Configuration config = new Configuration().configure();
        // 创建会话工厂对象
        sessionFactory = config.buildSessionFactory();
        // 创建会话对象
        session = sessionFactory.openSession();
        // 开启事务
        transaction = session.beginTransaction();
    }
    @After
    public void tearDown() throws Exception
    {
        // 提交事务
        transaction.commit();
        // 关闭会话
        session.close();
        // 关闭会话工厂
        sessionFactory.close();
    }
    @Test
    public void testSaveCustomer()
    {
        //生成顾客对象
    	Customer cutomer = new Customer();
    	cutomer.setAccount("javase");
    	cutomer.setPassword("123456");
    	//...
        //保存对象进入数据库
        session.save(cutomer);
    }
}
