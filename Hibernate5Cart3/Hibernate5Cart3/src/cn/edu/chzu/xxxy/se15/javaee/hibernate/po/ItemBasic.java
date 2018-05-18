package cn.edu.chzu.xxxy.se15.javaee.hibernate.po;

public class ItemBasic {
	private String itemID;
	private String title;
	private String description;
	private float cost;

	public ItemBasic() {
	}

	public ItemBasic(String itemID) {
		this.itemID = itemID;
	}

	public ItemBasic(String itemID, String title, String description, float cost) {
		this.itemID=itemID;
		this.title=title;
		this.description=description;
		this.cost=cost;
	}

	public String getItemID() {
		return (itemID);
	}

	protected void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getTitle() {
		return (title);
	}

	protected void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return (description);
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	public float getCost() {
		return (cost);
	}

	protected void setCost(float cost) {
		this.cost = cost;
	}

}
