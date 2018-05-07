package cn.edu.chzu.xxxy.se15.javaee.struts.dao;

import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.struts.bean.OrderBean;

public interface IOrderDao {

	public int save(OrderBean order);
	public int delete(String orderid);
	public int update(String orderid, OrderBean order);
	public List<OrderBean> findAll();
	public OrderBean findByOrderid(String orderid);
}
