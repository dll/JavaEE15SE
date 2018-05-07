package cn.edu.chzu.xxxy.se15.javaee.struts.bean;


	/**
	 * 
	字段名	类型	主、索引或外键	描述
	Id	int	PrimaryKey	
	OrderID	varchar		订单编号
	Product	varchar		商品名称
	Num	Int		商品数量
	Username	Varchar	ForeginKey	用户名
	Setstate	Int		商家发货状态
	Paystate	int		顾客付款状态
	Receiver	Varchar		接货者
	Settime	Varchar		商家发货时间
	Gettime	Varchar		顾客收货时间
	Email	Varchar		邮政编码
	Tel	Varchar		联系电话
	Address	Varchar		地址
	*/
public class OrderBean {
		private String orderid;
		private String productname;
		private String productnum;
		private String username;
		private String setstate;
		private String paystate;
		private String receiver;
		private String settime;
		private String gettime;
		private String email;
		private String telephone;
		private String address;
		
		public String getOrderid() {
			return orderid;
		}
		public void setOrderid(String orderid) {
			this.orderid = orderid;
		}
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		public String getProductnum() {
			return productnum;
		}
		public void setProductnum(String productnum) {
			this.productnum = productnum;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getSetstate() {
			return setstate;
		}
		public void setSetstate(String setstate) {
			this.setstate = setstate;
		}
		public String getPaystate() {
			return paystate;
		}
		public void setPaystate(String paystate) {
			this.paystate = paystate;
		}
		public String getReceiver() {
			return receiver;
		}
		public void setReceiver(String receiver) {
			this.receiver = receiver;
		}
		public String getSettime() {
			return settime;
		}
		public void setSettime(String settime) {
			this.settime = settime;
		}
		public String getGettime() {
			return gettime;
		}
		public void setGettime(String gettime) {
			this.gettime = gettime;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
	}