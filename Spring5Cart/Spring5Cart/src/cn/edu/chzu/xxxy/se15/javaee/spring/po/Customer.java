package cn.edu.chzu.xxxy.se15.javaee.spring.po;


import java.util.Date;

@SuppressWarnings("serial")
public class Customer implements java.io.Serializable {

	private int customerId;
	private String account;
	private String password;
	private String name;
	private Boolean sex;
	private Date birthday;
	private String phone;
	private String email;
	private String address;
	private String zipcode;
	private String fax;

	public Customer() {
	}

	public Customer(int customerId) {
		this.customerId = customerId;
	}

	public Customer(int customerId, String account, String password,
			String name, Boolean sex, Date birthday, String phone, 
			String email, String address, String zipcode, String fax) {
		this.customerId = customerId;
		this.account = account;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.zipcode = zipcode;
		this.fax = fax;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

}