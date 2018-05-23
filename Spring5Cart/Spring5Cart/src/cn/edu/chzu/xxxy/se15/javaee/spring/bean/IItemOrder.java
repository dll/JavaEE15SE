package cn.edu.chzu.xxxy.se15.javaee.spring.bean;

public interface IItemOrder {

	public abstract IItem getItem();

	public abstract String getItemID();

	public abstract String getTitle();

	public abstract String getDescription();

	public abstract double getUnitCost();

	public abstract int getNumItems();
	
	public abstract void setItem(IItem item);

	public abstract void setNumItems(int n);

	public abstract void incrementNumItems();

	public abstract void cancelOrder();

	public abstract double getTotalCost();

}