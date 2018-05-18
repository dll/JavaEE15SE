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
}
