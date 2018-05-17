package cn.edu.chzu.xxxy.se15.javaee.hibernate.po;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//新增代理主鍵
	private Integer id=0;
	
	public Customer(int id, String account, String password, String name, String gender, Date birthday,
			String address, String phone, String email, Integer usertype, String hobby, String introduction) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.usertype = usertype;
		this.hobby = hobby;
		this.introduction = introduction;
	}
	public Customer() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getUsertype() {
		return usertype;
	}
	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	private String account="";
	private String password="";
	//注册属性
	private String name="";
	private String gender="";
	private Date birthday=null;
	private String address="";
	private String phone="";
	private String email="";
	
	//新增字段
	private Integer usertype=0;
	private String hobby="";
	private String introduction="";

	@Override
	public String toString() {
		return "Customer [id=" + id + ", account=" + account + ", password=" + password + ", name=" + name
				+ ", gender=" + gender + ", birthday=" + birthday + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", usertype=" + usertype + ", hobby=" + hobby + ", introduction=" + introduction
				+ "]";
	}

}
