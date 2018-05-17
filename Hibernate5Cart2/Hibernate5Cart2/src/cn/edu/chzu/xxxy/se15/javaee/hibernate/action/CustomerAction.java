package cn.edu.chzu.xxxy.se15.javaee.hibernate.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.chzu.xxxy.se15.javaee.hibernate.po.Customer;
import cn.edu.chzu.xxxy.se15.javaee.hibernate.service.CustomerService;

@SuppressWarnings("serial")
public class CustomerAction extends ActionSupport {
	
	private Customer loginUser;
	public Customer getLoginUser() {
			return loginUser;
	}
	public void setLoginUser(Customer loginUser) {
			this.loginUser = loginUser;
	}	
	public String login() {
		CustomerService userServ = new CustomerService();
		if (userServ.login(loginUser)) {
			return "loginsuccess";
		}
		return "loginfail";
	}		
	public String register() {
		CustomerService userServ = new CustomerService();
		if (userServ.register(loginUser))
			return "registersuccess";
		else
			return "registerfail";
	}
	
	public String update() {
		CustomerService userServ = new CustomerService();
		if (userServ.update(loginUser)) 
			return "updatesuccess";
		else
			return "updatefail";
	}
	
	public String delete() {
		CustomerService userServ = new CustomerService();
		if (userServ.delete(loginUser)) 
			return "deletesuccess";
		else
			return "deletefail";
	}
}
