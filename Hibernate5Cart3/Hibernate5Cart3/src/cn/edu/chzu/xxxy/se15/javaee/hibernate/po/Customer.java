package cn.edu.chzu.xxxy.se15.javaee.hibernate.po;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	private int customerId;
	private String account;
	private String password;
	////private String repassword;
	private String name;
	private Boolean sex;
	////private String sexStr;
	private Date birthday;
//	private String phone;
	////private String email;
//	private String address;
//	private String zipcode;
//	private String fax;

	//private Set addresses = new HashSet(0);//1对多的多

	private ContactInfo contactInfo;
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}

	public Customer() {
		super();
	}
	public Customer(int customerId, String account, String password, String name, Boolean sex, Date birthday,
			ContactInfo contactInfo) {
		super();
		this.customerId = customerId;
		this.account = account;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		//this.email = email;
		//this.addresses = addresses;
		this.contactInfo=contactInfo;
	}
	
/*	public Customer(int customerId, String account, String password, String name, Boolean sex, Date birthday,
			String email, Set addresses) {
		super();
		this.customerId = customerId;
		this.account = account;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		//this.email = email;
		this.addresses = addresses;
	}*/

//	public String getSexStr() {
//		System.out.println("getSexStr"+this.sex);
//		if(this.sex)
//			return "1";
//		else
//			return "0";
//	}
//
//	public void setSexStr(String sexStr) {
//		System.out.println("setSexStr"+this.sexStr);
//		if(this.sexStr.equals("1"))
//			this.sex = true;
//		else
//			this.sex = false;
//	}
//
//	public String getRepassword() {
//		return repassword;
//	}
//
//	public void setRepassword(String repassword) {
//		this.repassword = repassword;
//	}

/*	public Set getAddresses() {
		return addresses;
	}

	public void setAddresses(Set addresses) {
		System.out.println("Set addresses:"+addresses);
		this.addresses = addresses;
	}*/

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

}
