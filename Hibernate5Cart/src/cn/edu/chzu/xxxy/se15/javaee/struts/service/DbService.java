package cn.edu.chzu.xxxy.se15.javaee.struts.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.chzu.xxxy.se15.javaee.struts.dbutil.DbcpPool;
/**
 * 前面项目使用的，已经改写在InitCartDbAction中
 * */
public class DbService {
	
	public static void createDaoOrderTable(){
    	String sql="CREATE TABLE orders(orderid varchar(20) NOT NULL,"
    			+ " productname varchar(20),productnum varchar(20),"
    			+ " username varchar(20), setstate varchar(20),"
    			+ " paystate varchar(20), receiver varchar(20),"
    			+ " settime varchar(20), gettime varchar(20),"
    			+ " email varchar(20), telephone varchar(20),"
    			+ " address varchar(20),PRIMARY KEY (orderid))";
    	try {
			if(!isTableExist("orders"))
				createDaoTable(sql);
			else
				return;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
    @SuppressWarnings("null")
	public static boolean isTableExist(String tableName) throws SQLException{
    	Connection conn= DbcpPool.getConnection();
	    if(conn!=null) {
	        DatabaseMetaData dbmd = conn.getMetaData();
	        ResultSet rs = dbmd.getTables(null, null, tableName.toUpperCase(),null);
	        if(rs.next()) {
	            rs.close();
	            conn.close();
	            return true;
	        }
	        rs.close();conn.close();
	        return false;
            
	    }
	    else{
	    	conn.close();
	    	return false;
	    }
	}
	public static void createDaoTable(String ctbSQL){
		try{
			Connection con= DbcpPool.getConnection();
			Statement st=con.createStatement();
			 st.executeUpdate(ctbSQL);
			 st.close();
			 con.close();
	    }catch(SQLException e){
	         e.printStackTrace();
	    }
	}
	public static void initOrderTable(){
		String sql = "INSERT INTO orders (orderid,productname,"
				+ "productnum,username,setstate,paystate,receiver,"
				+ "settime,gettime,email,telephone,address) "
				+ " VALUES ('003','MP4','100','osgis','宸茶','宸蹭粯','dll','2018-04-01','2018-0413','czldl@tom.com','13866933928','9-1-102')";
		try{
			Connection con= DbcpPool.getConnection();
			Statement st=con.createStatement();
			 st.executeUpdate(sql);
			 st.close();
			 con.close();
	    }catch(SQLException e){
	         e.printStackTrace();
	    }
	}
}
