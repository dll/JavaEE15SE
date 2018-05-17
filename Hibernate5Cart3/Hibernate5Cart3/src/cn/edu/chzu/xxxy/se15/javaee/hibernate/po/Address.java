package cn.edu.chzu.xxxy.se15.javaee.hibernate.po;

public class Address {

	private int addressId;
	private String detail;
	private String zipcode;
	private String phone;
	private String type;
	
	private Customer customer;//1¶Ô¶àµÄ1
	
	public Address() {
	}
	public Address(int addressId) {
		super();
		this.addressId = addressId;
	}
	public Address(int addressId, String detail, String zipcode, String phone,
			String type, Customer customer) {
		super();
		this.addressId = addressId;
		this.detail = detail;
		this.zipcode = zipcode;
		this.phone = phone;
		this.type = type;
		this.customer = customer;
	}
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
