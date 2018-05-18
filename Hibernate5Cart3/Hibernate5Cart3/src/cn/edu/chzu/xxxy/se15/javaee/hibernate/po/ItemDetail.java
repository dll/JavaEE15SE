package cn.edu.chzu.xxxy.se15.javaee.hibernate.po;

import java.sql.Blob;

public class ItemDetail extends ItemBasic{
	private Blob image;

	public ItemDetail() {
	}

	public ItemDetail(String itemID, String title, String description,
			float cost, Blob image) {
		super(itemID, title, description, cost);
		this.setImage(image);
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

}
