package cn.edu.chzu.xxxy.se15.javaee.spring.bean;

public class ItemOrderFactory {
	
	public static ItemOrder createItemOrder() {
		System.out.println("���þ�̬������������bean...");
		return new ItemOrder();
	}
	
	public ItemOrder createItemOrder2() {
		System.out.println("����ʵ��������������bean...");
		return new ItemOrder();
	}
	
}
