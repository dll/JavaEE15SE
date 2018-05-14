package cn.edu.chzu.xxxy.se15.javaee.struts.dao;

import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.struts.bean.ItemBean;

public interface IItemDao {

	public int save(ItemBean item);
	public int delete(String itemID);
	public int update(String itemID, ItemBean item);
	public List<ItemBean> findAll();
	public ItemBean findByName(String itemID);
}
