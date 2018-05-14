package cn.edu.chzu.xxxy.se15.javaee.struts.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.struts.bean.CardBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.dbutil.DbcpPool;

public class CardDaoImpl implements ICardDao{

	@Override
	public int delete(String name) {
		String sql = "DELETE FROM cards WHERE name = '" + name + "'";
		int result = 0 ;
		result = DbcpPool.executeUpdate(sql);
		DbcpPool.close();
		return result;
	}

	@Override
	public List<CardBean> findAll() {
		String sql = "SELECT * FROM cards ORDER BY name ";
		List<CardBean> list = new ArrayList<CardBean>();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			while(rs.next())
			{
				CardBean card = new CardBean();
				card.setName(rs.getString("name"));
				card.setCardno(rs.getInt("cardno"));
				card.setPassword(rs.getString("password"));				
				list.add(card);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}

	

	@Override
	public int save(CardBean card) {
		String sql="INSERT INTO cards(name, cardno, password) VALUES (?,?,?)";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1, card.getName());
			ps.setInt(2, card.getCardno());
			ps.setString(3, card.getPassword());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public int update(String name, CardBean card) {
		String sql = "UPDATE cards SET cardno=?, password=?";
		
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1, card.getName());
			ps.setInt(2, card.getCardno());
			ps.setString(3, card.getPassword());
			result = ps.executeUpdate();
			System.out.println("result:" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public CardBean findByName(String name ) {
		String sql = "SELECT * FROM cards WHERE orderid ='" + name + "'";
		CardBean card = new CardBean();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			if(rs.next())
			{				
				card.setName(rs.getString("name"));
				card.setCardno(rs.getInt("cardno"));
				card.setPassword(rs.getString("password"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbcpPool.close();
		return card;
	}
}