package cn.edu.chzu.xxxy.se15.javaee.hibernate.po;

import java.io.Serializable;
import java.sql.Blob;

public class Item implements Serializable {
	
	private ItemPK ipk;	
	//private String itemID;
	//private String title;
	private String description;
	private float cost;
	private Blob image;

	public Item() {
	}

//	public Item(String itemID) {
//		this.itemID = itemID;
//	}

//	public Item(String itemID, String title, String description, float cost, Blob image) {
//		this.itemID=itemID;
//		this.title=title;
//		this.description=description;
//		this.cost=cost;
//		this.image=image;
//	}

//	public String getItemID() {
//		return (itemID);
//	}
//
//	protected void setItemID(String itemID) {
//		this.itemID = itemID;
//	}
//
//	public String getTitle() {
//		return (title);
//	}
//
//	protected void setTitle(String title) {
//		this.title = title;
//	}

	public Item(ItemPK ipk, String description, float cost, Blob image) {
		this.ipk=ipk;
		this.description=description;
		this.cost=cost;
		this.image=image;
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

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public ItemPK getIpk() {
		return ipk;
	}

	public void setIpk(ItemPK ipk) {
		this.ipk = ipk;
	}
}
