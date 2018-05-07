package cn.edu.chzu.xxxy.se15.javaee.struts.dao;

public class DaoFactory {
	public static IUserDao getUserDaoInstance()
	{
		return new UserDaoImpl();
	}
	public static IOrderDao getOrderDaoInstance()
	{
		return new OrderDaoImpl();
	}
	public static IItemDao getItemDaoInstance(){
		return new ItemDaoImpl();
	}
}
