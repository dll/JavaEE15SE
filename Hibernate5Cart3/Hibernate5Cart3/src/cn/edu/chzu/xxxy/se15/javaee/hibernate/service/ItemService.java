package cn.edu.chzu.xxxy.se15.javaee.hibernate.service;

import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.hibernate.dao.ItemDAO;

import java.util.ArrayList;


public class ItemService {
	private List items = new ArrayList();

	public List getAllItems() {
		ItemDAO dao = new ItemDAO();
		List items = dao.findAll();
		return items;
	}
	
	public List findByHql() {
		ItemDAO dao = new ItemDAO();
		String hql = "from cn.edu.chzu.xxxy.se15.javaee.hibernate.po.Item";//1
		//String hql = "from Item";
		//String hql = "from Item as item";
		//String hql = "select item.title from Item as item";
		//String hql = "select item.title, item.cost from Item as item";
		List list = dao.findByHql(hql);
		dao.getSession().close();
		return list;
	}
}
