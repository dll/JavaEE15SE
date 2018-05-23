package cn.edu.chzu.xxxy.se15.javaee.spring.bean;

public class Item implements IItem{

	  private String itemID;
	  private String title;
	  private String description;
	  private double cost;
	  
//	  public Item(){
//			System.out.println("create Item.");
//		}

	  public Item(String itemID, String title,
	              String description, double cost) {
	    this.itemID = itemID;
	    this.title = title;
	    this.description = description;
	    this.cost = cost;
		System.out.println("create Item.");
	  }

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItem#getItemID()
	 */
	@Override
	public String getItemID() {
		return itemID;
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItem#setItemID(java.lang.String)
	 */
	@Override
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItem#getTitle()
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItem#setTitle(java.lang.String)
	 */
	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItem#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItem#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItem#getCost()
	 */
	@Override
	public double getCost() {
		return cost;
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItem#setCost(double)
	 */
	@Override
	public void setCost(double cost) {
		this.cost = cost;
	}
}
