package cn.edu.chzu.xxxy.se15.javaee.struts.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.struts.bean.UserBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.dbutil.DbcpPool;

public class UserDaoImpl implements IUserDao{

	@Override
	public boolean save(UserBean user) throws Exception{
		String sql = "INSERT INTO users (account,password,usertype) "
				+ "VALUES (?,?,?)";
		/*1)代码的可读性和可维护性 2)尽最大可能提高性能3)最重要的一点是极大地提高了安全性4)相同操作批量数据效率较高 */
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		
		int result = 0 ;

		ps.setString(1, user.getAccount());
		ps.setString(2, user.getPassword());
		ps.setInt(3, user.getUsertype());
		result = ps.executeUpdate();

		DbcpPool.close();
		
        if (result >= 1) {
            return true;
        } else {
            return false;
        }
	}

	@Override
	public boolean delete(String account) throws Exception{
		String sql = "DELETE FROM users WHERE account = '" + account + "'";
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
	public boolean update(String account, UserBean user) throws Exception{
		String sql = "UPDATE users SET password=?,usertype=? WHERE account=?";
		
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0 ;
		ps.setString(1, user.getPassword());
		ps.setInt(2, user.getUsertype());
		//ps.setString(3, account);
		result = ps.executeUpdate();

		DbcpPool.close();
        if (result >= 1) {
            return true;
        } else {
            return false;
        }
	}

	@Override
	public UserBean findByAccount(String account) throws Exception{
		String sql = "SELECT * FROM users WHERE account ='" + account + "'";
		UserBean user = new UserBean();
		ResultSet rs = DbcpPool.executeQuery(sql);
		if(rs.next())
		{
			user.setPassword(rs.getString("password"));
			user.setAccount(rs.getString("account"));
			user.setUsertype(rs.getInt("usertype"));
		}
		
		DbcpPool.close();
		return user;
	}

	@Override
	public List<UserBean> findAll() throws Exception{
		String sql = "SELECT * FROM users ORDER BY account ";
		List<UserBean> list = new ArrayList<UserBean>();
		ResultSet rs = DbcpPool.executeQuery(sql);

		while(rs.next())
		{
			UserBean user = new UserBean();
			user.setPassword(rs.getString("password"));
			user.setAccount(rs.getString("account"));
			user.setUsertype(rs.getInt("usertype"));
			list.add(user);
		}

		DbcpPool.close();
		return list;
	}

	@Override
	public boolean login(String account, String password) throws Exception{
		String sql = "SELECT count(*) AS NUM FROM users WHERE account='" 
				+ account + "' AND password = '" + password + "'";
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