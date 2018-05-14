package cn.edu.chzu.xxxy.se15.javaee.struts.bean;

public class ItemOrderBean {
	private ItemBean item;
	private int numItems;

	//构造订单
	public ItemOrderBean(ItemBean item) {
		setItem(item);//设置商品
		setNumItems(1);//数量为1
	}

	public ItemBean getItem() {
		return (item);
	}

	protected void setItem(ItemBean item) {
		this.item = item;
	}

	public String getItemID() {
		return (getItem().getItemID());
	}

	public String getTitle() {
		return (getItem().getTitle());
	}

	public String getDescription() {
		return (getItem().getDescription());
	}

	public double getUnitCost() {
		return (getItem().getCost());
	}

	public int getNumItems() {
		return (numItems);
	}
	//添加n件商品到订单中
	public void setNumItems(int n) {
		this.numItems = n;
	}
	//添加1件商品数量
	public void incrementNumItems() {
		setNumItems(getNumItems() + 1);
	}
	//取消订单
	public void cancelOrder() {
		setNumItems(0);
	}
	//得到订单总金额
	public double getTotalCost() {
		return (getNumItems() * getUnitCost());
	}
}
