package cn.edu.chzu.xxxy.se15.javaee.struts.bean;

import java.util.*;

import cn.edu.chzu.xxxy.se15.javaee.struts.service.ItemService;

public class ShoppingCartBean {
	private List<ItemOrderBean> itemsOrdered;

	/** 构建一个空购物车. */
	public ShoppingCartBean() {
		itemsOrdered = new ArrayList<ItemOrderBean>();
		ItemBean item = new ItemBean("book001", "JAVAEE技术实验指导教程",
				"WEB程序设计知识回顾  、" + "轻量级JAVAEE应用框架、"
						+ "企业级EJB组件编程技术、" + "JAVAEE综合应用开发.", 19.95,10, "images/066867-02.jpg");
		ItemOrderBean itemorder = new ItemOrderBean(item);
		itemorder.setNumItems(1);
		itemsOrdered.add(itemorder);
	}

	/**
	 * Returns Vector of ItemOrderBean entries giving Item and number ordered.
	 */

	public List<ItemOrderBean> getItemsOrdered() {
		return (itemsOrdered);
	}

	/**
	 * Looks through cart to see if it already contains an order entry
	 * corresponding to item ID. If it does, increments the number ordered. If
	 * not, looks up Item in catalog and adds an order entry for it.
	 */

	public synchronized void addItem(String itemID) {
		ItemOrderBean order;
		Iterator<ItemOrderBean> it = itemsOrdered.iterator();
		while (it.hasNext()) {
			order = (ItemOrderBean) it.next();
			if (order.getItemID().equals(itemID)) {
				order.incrementNumItems();
				return;
			}
		}
		ItemOrderBean newOrder = new ItemOrderBean(ItemService.getItem(itemID));
		itemsOrdered.add(newOrder);
	}

	/**
	 * Looks through cart to find order entry corresponding to item ID listed.
	 * If the designated number is positive, sets it. If designated number is 0
	 * (or, negative due to a user input error), deletes item from cart.
	 */

	public synchronized void setNumOrdered(String itemID, int numOrdered) {
		ItemOrderBean order;
		Iterator<ItemOrderBean> it = itemsOrdered.iterator();
		while (it.hasNext()) {
			order = (ItemOrderBean) it.next();
			if (order.getItemID().equals(itemID)) {
				if (numOrdered <= 0) {
					itemsOrdered.remove(order);
				} else {
					order.setNumItems(numOrdered);
				}
				return;
			}
		}
		ItemOrderBean newOrder = new ItemOrderBean(ItemService.getItem(itemID));
		itemsOrdered.add(newOrder);
	}
}
