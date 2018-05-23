package cn.edu.chzu.xxxy.se15.javaee.spring.bean;

public interface IItem {

	public abstract String getItemID();

	public abstract void setItemID(String itemID);

	public abstract String getTitle();

	public abstract void setTitle(String title);

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract double getCost();

	public abstract void setCost(double cost);

}