package cn.edu.chzu.xxxy.se15.javaee.spring.action;

import cn.edu.chzu.xxxy.se15.javaee.spring.po.Customer;
import cn.edu.chzu.xxxy.se15.javaee.spring.service.IUserService;

public class UserAction {
	private Customer loginUser;
	private IUserService userService = null;
	
	public Customer getLoginUser() {
			return loginUser;
	}
	
	public void setLoginUser(Customer loginUser) {
			this.loginUser = loginUser;
	}
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public String execute() {
		userService.register(loginUser);
		return "success";
	}

}
