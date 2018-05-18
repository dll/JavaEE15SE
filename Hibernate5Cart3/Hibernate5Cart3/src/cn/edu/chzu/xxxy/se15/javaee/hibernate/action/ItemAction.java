package cn.edu.chzu.xxxy.se15.javaee.hibernate.action;

import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.hibernate.service.ItemService;

public class ItemAction{
	private List items;

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}
	
	public String getAllItems() {
		ItemService itemServ = new ItemService();
		items=itemServ.getAllItems();
		System.out.println("Item Action executed!");
		return "success";
	}

	public String findItems() {
		ItemService itemServ = new ItemService();
		items=itemServ.findByHql();
		System.out.println("Item Action executed!");
		return "success";
	}
}
