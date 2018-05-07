package cn.edu.chzu.xxxy.se15.javaee.struts.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.struts.bean.ItemBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.dbutil.DbcpPool;

public class ItemDaoImpl implements IItemDao{

	@Override
	public int delete(String itemID) {
		String sql = "DELETE FROM items WHERE itemID = '" + itemID + "'";
		int result = 0 ;
		result = DbcpPool.executeUpdate(sql);
		DbcpPool.close();
		return result;
	}

	@Override
	public List<ItemBean> findAll() {
		String sql = "SELECT * FROM items ORDER BY itemID";
		List<ItemBean> list = new ArrayList<ItemBean>();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			while(rs.next())
			{
				ItemBean item = new ItemBean();
				item.setItemID(rs.getString("itemID"));
				item.setTitle(rs.getString("title"));
				item.setDescription(rs.getString("description"));	
				item.setCost(rs.getDouble("cost"));
				item.setInventory(rs.getInt("inventory"));
				item.setImage(rs.getString("image"));
				list.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}

	

	@Override
	public int save(ItemBean item) {
		String sql="INSERT INTO items(itemID, title, description, cost, inventory, image) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1, item.getItemID());
			ps.setString(2, item.getTitle());
			ps.setString(3, item.getDescription());
			ps.setDouble(4, item.getCost());
			ps.setInt(5, item.getInventory());
			ps.setString(6, item.getImage());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public int update(String itemID, ItemBean item) {
		String sql = "UPDATE items SET title=?, description=?, cost=?,inventory=?, image=? WHERE itemID=?";
		
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0 ;
		try {
	
			ps.setString(1, item.getTitle());
			ps.setString(2, item.getDescription());
			ps.setDouble(3, item.getCost());
			ps.setInt(4, item.getInventory());
			ps.setString(5, item.getImage());
			result = ps.executeUpdate();
			System.out.println("result:" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public ItemBean findByName(String itemID ) {
		String sql = "SELECT * FROM items WHERE itemID ='" + itemID + "'";
		ItemBean item = new ItemBean();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			if(rs.next())
			{				
				item.setItemID(rs.getString("itemID"));
				item.setTitle(rs.getString("title"));
				item.setDescription(rs.getString("description"));	
				item.setCost(rs.getDouble("cost"));
				item.setInventory(rs.getInt("inventory"));
				item.setImage(rs.getString("image"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbcpPool.close();
		return item;
	}
}