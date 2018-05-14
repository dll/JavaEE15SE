package cn.edu.chzu.xxxy.se15.javaee.struts.bean;

/**
 * 商品信息
 */
public class ItemBean {
	private String itemID;
	private String title;
	private String description;
	private double cost;
	private int inventory;
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ItemBean() {
	}

	public ItemBean(String itemID, String title, String description, double cost, int inventory, String image) {
		setItemID(itemID);
		setTitle(title);
		setDescription(description);
		setCost(cost);
		setImage(image);
		setInventory(inventory);
	}

	public String getItemID() {
		return (itemID);
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getTitle() {
		return (title);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return (description);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return (cost);
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
}
