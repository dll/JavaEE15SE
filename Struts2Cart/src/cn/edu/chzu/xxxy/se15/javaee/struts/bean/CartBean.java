package cn.edu.chzu.xxxy.se15.javaee.struts.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.struts.service.ItemService;

public class CartBean {
	private List<ItemOrderBean> itemsOrdered;

	/** 构建一个空购物车. */
	public CartBean() {
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
	 * 返回商品订单的商品及数据
	 */

	public List<ItemOrderBean> getItemsOrdered() {
		return (itemsOrdered);
	}

	/**
	 * Looks through cart to see if it already contains an order entry
	 * corresponding to item ID. If it does, increments the number ordered. If
	 * not, looks up Item in catalog and adds an order entry for it.
	 * 向购物车中添加商品。如果商品id存在则数量递增，否则向订单中添加该商品
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
	 * 设置订单商品的数量，如是合法的正数则保存，0或负数则删除
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
