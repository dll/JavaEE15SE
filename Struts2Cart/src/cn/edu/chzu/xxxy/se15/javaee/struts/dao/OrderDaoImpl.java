package cn.edu.chzu.xxxy.se15.javaee.struts.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.struts.bean.OrderBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.dbutil.DbcpPool;

public class OrderDaoImpl implements IOrderDao{

	@Override
	public int delete(String orderid) {
		String sql = "DELETE FROM orders WHERE orderid = '" + orderid + "'";
		int result = 0 ;
		result = DbcpPool.executeUpdate(sql);
		DbcpPool.close();
		return result;
	}

	@Override
	public List<OrderBean> findAll() {
		String sql = "SELECT * FROM orders ORDER BY orderid ";
		List<OrderBean> list = new ArrayList<OrderBean>();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			while(rs.next())
			{
				OrderBean order = new OrderBean();
				order.setOrderid(rs.getString("orderid"));
				order.setProductname(rs.getString("productname"));
				order.setProductnum(rs.getString("productnum"));
				order.setUsername(rs.getString("username"));
				order.setSetstate(rs.getString("setstate"));
				order.setPaystate(rs.getString("paystate"));
				order.setReceiver(rs.getString("receiver"));
				order.setSettime(rs.getString("settime"));		
				order.setGettime(rs.getString("gettime"));
				order.setEmail(rs.getString("email"));
				order.setTelephone(rs.getString("telephone"));
				order.setAddress(rs.getString("address"));
				
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}

	

	@Override
	public int save(OrderBean order) {
		String sql = "INSERT INTO orders (orderid,productname,"
				+ "productnum,username,setstate,paystate,receiver,"
				+ "settime,gettime,email,telephone,address) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1, order.getOrderid());
			ps.setString(2, order.getProductname());
			ps.setString(3, order.getProductnum());
			ps.setString(4, order.getUsername());
			ps.setString(5, order.getSetstate());
			ps.setString(6, order.getPaystate());
			ps.setString(7, order.getReceiver());
			ps.setString(8, order.getSettime());
			ps.setString(9, order.getGettime());
			ps.setString(10, order.getEmail());
			ps.setString(11, order.getTelephone());
			ps.setString(12, order.getAddress());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public int update(String orderid, OrderBean order) {
		String sql = "UPDATE orders SET productname=?, productnum=?,"
				+ "username=?,setstate=?,paystate=?,receiver=?,"
				+ "settime=?,gettime=?,email=?,telephone=?,address=? WHERE orderid=?";
		
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1, order.getOrderid());
			ps.setString(2, order.getProductname());
			ps.setString(3, order.getProductnum());
			ps.setString(4, order.getUsername());
			ps.setString(5, order.getSetstate());
			ps.setString(6, order.getPaystate());
			ps.setString(7, order.getReceiver());
			ps.setString(8, order.getSettime());
			ps.setString(9, order.getGettime());
			ps.setString(10, order.getEmail());
			ps.setString(11, order.getTelephone());
			ps.setString(12, order.getAddress());
			result = ps.executeUpdate();
			System.out.println("result:" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public OrderBean findByOrderid(String orderid) {
		String sql = "SELECT * FROM orders WHERE orderid ='" + orderid + "'";
		OrderBean order = new OrderBean();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			if(rs.next())
			{
				order.setOrderid(rs.getString("orderid"));
				order.setProductname(rs.getString("productname"));
				order.setProductnum(rs.getString("productnum"));
				order.setUsername(rs.getString("username"));
				order.setSetstate(rs.getString("setstate"));
				order.setPaystate(rs.getString("paystate"));
				order.setReceiver(rs.getString("receiver"));
				order.setSettime(rs.getString("settime"));		
				order.setGettime(rs.getString("gettime"));
				order.setEmail(rs.getString("email"));
				order.setTelephone(rs.getString("telephone"));
				order.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbcpPool.close();
		return order;
	}
}