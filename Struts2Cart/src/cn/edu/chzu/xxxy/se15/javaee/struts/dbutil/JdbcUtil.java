package cn.edu.chzu.xxxy.se15.javaee.struts.dbutil;
/**
 * 连接数据库，复习、巩固JDBC，可以只使用DBCP数据库连接池的
 * 另外，学习接口性方法的编写：抛出异常
 */
	
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	//数据库驱动名字
	private static String jdbcName = "com.mysql.jdbc.Driver";
	//数据库协议地址
	private static String is_dbUrl = "jdbc:mysql://localhost:3306/information_schema";
	private static String sc_dbUrl = "jdbc:mysql://localhost:3306/struts2cartdb";
	//数据库用户名
	private static String dbUser = "root";
	//数据库密码
	private static String dbPassword = "";	
	/**
	 * 获取连接
	 * @return
	 * @throws Exception
	 */
	public static Connection is_getCon() throws Exception{
		Class.forName(jdbcName);
		Connection conn = DriverManager.getConnection(is_dbUrl, dbUser, dbPassword);
		return conn;
	}
	public static Connection sc_getCon() throws Exception{
		Class.forName(jdbcName);
		Connection conn = DriverManager.getConnection(sc_dbUrl, dbUser, dbPassword);
		return conn;
	}
	/**
	 * 关闭连接
	 * @param stmt
	 * @param conn
	 * @throws Exception
	 */
	public static void close(Statement stmt,Connection conn) throws Exception{
		if(stmt!=null){
			stmt.close();
			if(conn!=null){
				conn.close();
			}
		}
	}
	/**
	 * 关闭连接
	 * @param cstmt
	 * @param conn
	 * @throws Exception
	 */
	public static void close(CallableStatement cstmt, Connection conn) throws Exception{
		if(cstmt!=null){
			cstmt.close();
			if(conn!=null){
				conn.close();
			}
		}
	}	
	/**
	 * 关闭连接
	 * @param pstmt
	 * @param conn
	 * @throws SQLException
	 */
	public static void close(PreparedStatement pstmt, Connection conn) throws SQLException{
		if(pstmt!=null){
			pstmt.close();
			if(conn!=null){
				conn.close();
			}
		}
	}
	/**
	 * 重载关闭方法
	 * @param pstmt
	 * @param conn
	 * @throws Exception
	 */
	public void close(ResultSet rs,PreparedStatement pstmt, Connection conn) throws Exception{
		if(rs!=null){
			rs.close();
			if(pstmt!=null){
				pstmt.close();
				if(conn!=null){
					conn.close();
				}
				
			}
		}
	}
}
