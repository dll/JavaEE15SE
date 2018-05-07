package cn.edu.chzu.xxxy.se15.javaee.struts.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.struts.bean.ItemBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.bean.UserBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.dao.DaoFactory;
import cn.edu.chzu.xxxy.se15.javaee.struts.exception.UserException;

/**
 * 获取商品信息
 * 
 */
public class ItemService {
	private static List<ItemBean> items = new ArrayList<ItemBean>();

	public List<ItemBean> getAllItems() {
		items=DaoFactory.getItemDaoInstance().findAll();
		if(items.size()==0){
			items.add(new ItemBean("book001", "JAVAEE技术实验指导教程",
						"WEB程序设计知识回顾、" + "轻量级JAVAEE应用框架、" + "企业级EJB组件编程技术、" + "JAVAEE综合应用开发.", 19.95, 100,"images/064922-01.jpg"));
			items.add(new ItemBean("book002", "JAVAEE技术", "Struts框架、Hibernate框架、Spring框架、" + "会话Bean、实体Bean、消息驱动Bean",
						29.95, 100,"images/066867-02.jpg"));
		}
		return items;
	}

	public static ItemBean getItem(String itemID) {
		ItemBean item;
		Iterator<ItemBean> it = items.iterator();
		while (it.hasNext()) {
			item = (ItemBean) it.next();
			if (itemID.equals(item.getItemID())) {
				return (item);
			}
		}
		return (null);
	}
	
	public boolean register(ItemBean newItem) throws Exception{

		int result = DaoFactory.getItemDaoInstance().save(newItem);
		if(result>0)
			return true;
		else
			return false;
	}
}
