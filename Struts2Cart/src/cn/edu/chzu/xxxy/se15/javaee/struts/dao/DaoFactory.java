package cn.edu.chzu.xxxy.se15.javaee.struts.dao;
/**
 * 复习DAO模式
 * */
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
