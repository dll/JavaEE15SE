package cn.edu.chzu.xxxy.se15.javaee.struts.dao;

import java.util.List;

import cn.edu.chzu.xxxy.se15.javaee.struts.bean.CardBean;

public interface ICardDao {

	public int save(CardBean card);
	public int delete(String name);
	public int update(String name, CardBean card);
	public List<CardBean> findAll();
	public CardBean findByName(String name);
}
