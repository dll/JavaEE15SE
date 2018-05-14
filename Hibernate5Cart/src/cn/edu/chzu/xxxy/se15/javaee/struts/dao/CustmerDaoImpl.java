package cn.edu.chzu.xxxy.se15.javaee.struts.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.struts.bean.CustomerBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.dbutil.DbcpPool;

public class CustmerDaoImpl implements ICustmerDao{

	@Override
	public boolean save(CustomerBean user) throws Exception{
		String sql = "INSERT INTO customers (account,password,"
				+ "gender,birthday"
				+ ",email,hobby,introduction,usertype) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		/*1)代码的可读性和可维护性 2)尽最大可能提高性能3)最重要的一点是极大地提高了安全性4)相同操作批量数据效率较高 */
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		
		int result = 0 ;

		ps.setString(1, user.getAccount());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getGender());
		ps.setDate(4, (java.sql.Date) user.getBirthday());
		ps.setString(5, user.getEmail());
		ps.setString(6, user.getHobby());
		ps.setString(7, user.getIntroduction());
		ps.setInt(8, user.getUsertype());
		result = ps.executeUpdate();

		DbcpPool.close();
		
        if (result >= 1) {
            return true;
        } else {
            return false;
        }
	}

	@Override
	public boolean delete(String username) throws Exception{
		String sql = "DELETE FROM customers WHERE account = '" + username + "'";
		int result = 0 ;
		result = DbcpPool.executeUpdate(sql);
		DbcpPool.close();
		
        if (result >= 1) {
            return true;
        } else {
            return false;
        }
	}

	@Override
	public boolean update(String username, CustomerBean user) throws Exception{
		String sql = "UPDATE customers SET password=?, gender=?,"
				+ "birthday=?,usertype=?,email=?,hobby=?,"
				+ "introduction=? WHERE account=?";
		
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0 ;
		ps.setString(1, user.getPassword());
		ps.setString(2, user.getGender());
		ps.setDate(3, (java.sql.Date) user.getBirthday());
		ps.setInt(4, user.getUsertype());
		ps.setString(5, user.getEmail());
		ps.setString(6, user.getHobby());
		ps.setString(7, user.getIntroduction());
		ps.setString(8, username);
		result = ps.executeUpdate();

		DbcpPool.close();
        if (result >= 1) {
            return true;
        } else {
            return false;
        }
	}

	@Override
	public CustomerBean findByCustName(String username) throws Exception{
		String sql = "SELECT * FROM customers WHERE account ='" + username + "'";
		CustomerBean user = new CustomerBean();
		ResultSet rs = DbcpPool.executeQuery(sql);
		if(rs.next())
		{
			user.setBirthday(rs.getDate("birthday"));
			user.setEmail(rs.getString("email"));
			user.setGender(rs.getString("gender"));
			user.setHobby(rs.getString("hobby"));
			user.setIntroduction(rs.getString("introduction"));
			user.setPassword(rs.getString("password"));
			user.setAccount(rs.getString("account"));
			user.setUsertype(rs.getInt("usertype"));
		}
		
		DbcpPool.close();
		return user;
	}

	@Override
	public List<CustomerBean> findAll() throws Exception{
		String sql = "SELECT * FROM customers ORDER BY account ";
		List<CustomerBean> list = new ArrayList<CustomerBean>();
		ResultSet rs = DbcpPool.executeQuery(sql);

		while(rs.next())
		{
			CustomerBean user = new CustomerBean();
			user.setBirthday(rs.getDate("birthday"));
			user.setEmail(rs.getString("email"));
			user.setGender(rs.getString("gender"));
			user.setHobby(rs.getString("hobby"));
			user.setIntroduction(rs.getString("introduction"));
			user.setPassword(rs.getString("password"));
			user.setAccount(rs.getString("account"));
			user.setUsertype(rs.getInt("usertype"));
			list.add(user);
		}

		DbcpPool.close();
		return list;
	}

	@Override
	public boolean login(String username, String password) throws Exception{
		String sql = "SELECT count(*) AS NUM FROM customers WHERE account='" 
				+ username + "' AND password = '" + password + "'";
		ResultSet rs = DbcpPool.executeQuery(sql);
		int result = 0;
		if(rs.next())
		{
			result = rs.getInt("NUM");
		}
		DbcpPool.close();
		if(result > 0)
			return true;
		else
			return false;
	}
}