package cn.edu.chzu.xxxy.se15.javaee.spring.bean;

public class ItemOrderFactory {
	
	public static ItemOrder createItemOrder() {
		System.out.println("调用静态工厂方法创建bean...");
		return new ItemOrder();
	}
	
	public ItemOrder createItemOrder2() {
		System.out.println("调用实例工厂方法创建bean...");
		return new ItemOrder();
	}
	
}
