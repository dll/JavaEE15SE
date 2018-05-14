package cn.edu.chzu.xxxy.se15.javaee.struts.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.chzu.xxxy.se15.javaee.struts.dbutil.JdbcUtil;

public class InitCartDbAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * 声明JDBC相关对象
	 */
	private static PreparedStatement st=null;
	private static Connection conn = null;
	/**
	 * 声明购物车数据库各表 
	 */
	private  final String users="CREATE TABLE users(account varchar(20) NOT NULL, password varchar(20),usertype int,PRIMARY KEY (account))ENGINE = INNODB";
	private  final String cards="CREATE TABLE cards(name varchar(20) NOT NULL, cardno varchar(20), password varchar(20),PRIMARY KEY (name))ENGINE = INNODB";	        	    
	private  final String orders="CREATE TABLE orders(orderid varchar(20) NOT NULL, productname varchar(20),productnum varchar(20), username varchar(20), setstate varchar(20),"
			+ " paystate varchar(20), receiver varchar(20), settime varchar(20), gettime varchar(20), email varchar(20), telephone varchar(20), address varchar(20),PRIMARY KEY (orderid))ENGINE = INNODB";
	private  final String items="CREATE TABLE items(itemID varchar(20) NOT NULL, title varchar(20),description nvarchar(255),cost double, inventory int, image varchar(100), PRIMARY KEY (itemID))ENGINE = INNODB";

	private String initdb="";
	
	@Override
	public String execute()throws Exception {

		/**
		 * 根据管理员的选择是否初始化数据库
		 * */
		if("initcartdb".equals(getInitdb()))
		{
			createDB();
			createTables();
			System.out.println("struts2cartdb数据库及表已经创建完成!");	
			initCardData();
			initUserData();
			System.out.println("初始化用户和银行卡数据已经完成!");
			return "success";
		}
		else if("notinitcartdb".equals(getInitdb())){
			System.out.println(" \n跳过创建或初始化数据库及数据!");
			return "fail";
		}else{
			System.out.println(" \n没有选择!");
			return "input";
		}
	}
	public void createDB(){
		try{
			conn= JdbcUtil.is_getCon();//连接MySQL的系统数据库：information_schema，其中有所有数据库、表、字段等所有信息
			String sql="DROP DATABASE IF EXISTS struts2cartdb";
	    	st = (PreparedStatement) conn.prepareStatement(sql);
	    	st.executeUpdate();
	    	sql="CREATE DATABASE struts2cartdb";
	    	st = (PreparedStatement) conn.prepareStatement(sql);
	    	st.executeUpdate();
	    	System.out.println("struts2cartdb 数据库创建成功!");
	    	JdbcUtil.close(st, conn);
		}catch (Exception  e) {
			e.printStackTrace();
			System.out.println(e +" \n创建或加载数据库驱动失败!");	
		}
	}
	public void createTables(){
		Savepoint sp=null;
	  	try {
			conn=JdbcUtil.sc_getCon();//连接本站数据库：struts2cartdb
	    	conn.setAutoCommit(false);
	    	sp = conn.setSavepoint("sp1");	    	 
	    	createDAOTable("users", users);
	    	createDAOTable("orders", orders);
	    	createDAOTable("cards", cards);
	    	createDAOTable("items", items);	 	
	    	conn.commit(); 
		}catch (Exception  e) {
			e.printStackTrace();
			System.out.println(e +" \n表创建失败!");
			try {
				System.out.println("提交事务失败,进行回滚!");
				conn.rollback(sp);
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("回滚失败,数据库可能存在问题!");	
				System.out.println("DDL语句无法被回滚，比如 create database/drop database, create/drop/alter table/routine");
			}
		}finally{
			try {
				conn.commit(); 
				conn.releaseSavepoint(sp);
				conn.setAutoCommit(true);
				JdbcUtil.close(st, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	    	    		
	}
	public void createDAOTable(String tablename, String sql) throws Exception{		
		String sql0="DROP TABLE IF EXISTS "+tablename;
    	st=conn.prepareStatement(sql0);
    	st.executeUpdate(); 
    	st=conn.prepareStatement(sql);
    	st.executeUpdate(); 
    	System.out.println(tablename+" 表创建成功!");
	}
	//MySQL数据库事务、保存点演示
	public void initCardData(){
		Savepoint sp=null;
	  	try {
			conn=JdbcUtil.sc_getCon();
			//使用事务、保存点插入银行卡表2条数据
	    	conn.setAutoCommit(false);
	    	sp = conn.setSavepoint("sp1");	    	 
	    	String sql="INSERT INTO cards(name, cardno, password) VALUES (?,?,?)";
	    	st = (PreparedStatement) conn.prepareStatement(sql);
	    	st.setString(1, "中国工商银行");
			st.setString(2, "1234567890123456");
			st.setString(3, "123456");
	    	st.executeUpdate();
	    	
	    	sql="INSERT INTO cards(name, cardno, password) VALUES (?,?,?)";
	    	st = (PreparedStatement) conn.prepareStatement(sql);
	    	st.setString(1, "中国农业银行");
			st.setString(2, "1234567890123456");
			st.setString(3, "123456");
	    	st.executeUpdate();	 	
	    	conn.commit(); 
		}catch (Exception  e) {
			e.printStackTrace();
			System.out.println(e +" \n表创建失败!");
			try {
				System.out.println("提交事务失败,进行回滚!");
				conn.rollback(sp);
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("回滚失败,数据库可能存在问题!");	
			}
		}finally{
			try {
				conn.commit(); 
				conn.releaseSavepoint(sp);
				conn.setAutoCommit(true);
				JdbcUtil.close(st, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	    	    		
	}
	public void initUserData(){
		Savepoint sp=null;
	  	try {
			conn=JdbcUtil.sc_getCon();
			//使用事务、保存点插入用户表1条数据
	    	conn.setAutoCommit(false);
	    	sp = conn.setSavepoint("sp1");	    	 
	    	String sql="INSERT INTO users(account, password, usertype) VALUES (?,?,?)";
	    	st = (PreparedStatement) conn.prepareStatement(sql);
	    	st.setString(1, "javaee");st.setString(2, "123456");st.setInt(3, 1);
	    	st.executeUpdate();
		}catch (Exception  e) {
			e.printStackTrace();System.out.println(e +" \n表创建失败!");
			try {
				System.out.println("提交事务失败,进行回滚!");
				conn.rollback(sp);
			} catch (SQLException e1) {
				e1.printStackTrace();System.out.println("回滚失败,数据库可能存在问题!");	
			}
		}finally{
			try {
				conn.commit(); 
				conn.releaseSavepoint(sp);
				conn.setAutoCommit(true);
				JdbcUtil.close(st, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	    	    		
	}
	public String getInitdb() {
		return initdb;
	}
	public void setInitdb(String initdb) {
		this.initdb = initdb;
	}
}
