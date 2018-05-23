package cn.edu.chzu.xxxy.se15.javaee.spring.bean;

public class ItemOrder implements IItemOrder {
	private IItem item;
	private int numItems;

	public ItemOrder() {
	}
	
	public void init() {
		System.out.println("正在执行初始化方法  init...");
	}
	
	public void afterPropertiesSet() throws Exception {
		System.out.println("正在执行初始化方法  afterPropertiesSet...");
		
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItemOrder#getItem()
	 */
	@Override
	public IItem getItem() {
		return (item);
	}

	public void setItem(IItem item) {
		this.item = item;
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItemOrder#getItemID()
	 */
	@Override
	public String getItemID() {
		return (getItem().getItemID());
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItemOrder#getTitle()
	 */
	@Override
	public String getTitle() {
		return (getItem().getTitle());
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItemOrder#getDescription()
	 */
	@Override
	public String getDescription() {
		return (getItem().getDescription());
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItemOrder#getUnitCost()
	 */
	@Override
	public double getUnitCost() {
		return (getItem().getCost());
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItemOrder#getNumItems()
	 */
	@Override
	public int getNumItems() {
		return (numItems);
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItemOrder#setNumItems(int)
	 */
	@Override
	public void setNumItems(int n) {
		this.numItems = n;
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItemOrder#incrementNumItems()
	 */
	@Override
	public void incrementNumItems() {
		setNumItems(getNumItems() + 1);
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItemOrder#cancelOrder()
	 */
	@Override
	public void cancelOrder() {
		setNumItems(0);
	}

	/* (non-Javadoc)
	 * @see cn.edu.zjut.bean.IItemOrder#getTotalCost()
	 */
	@Override
	public double getTotalCost() {
		return (getNumItems() * getUnitCost());
	}
}
