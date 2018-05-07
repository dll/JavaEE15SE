package cn.edu.chzu.xxxy.se15.javaee.struts.bean;

public class UserBean {
	//登录属性
	private String account="";
	private String password="";
	//注册属性	
	//新增字段用户类型：1管理员 2VIP用户 3普通用户 4游客
	private Integer usertype=4;

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getUsertype() {
		return usertype;
	}
	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}
	public UserBean(String account, String password, Integer usertype) {
		super();
		this.account = account;
		this.password = password;
		this.usertype = usertype;
	}
	public UserBean() {
		super();
	}
}
