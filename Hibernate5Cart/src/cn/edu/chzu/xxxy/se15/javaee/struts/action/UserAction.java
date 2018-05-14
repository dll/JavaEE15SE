package cn.edu.chzu.xxxy.se15.javaee.struts.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.chzu.xxxy.se15.javaee.struts.bean.CartBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.bean.UserBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.dao.DaoFactory;
import cn.edu.chzu.xxxy.se15.javaee.struts.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<UserBean>,
				RequestAware,SessionAware,ApplicationAware {
	
	private static final long serialVersionUID = 488211460727240815L;
	private UserBean registUser=new UserBean();
	
	private Map<String, Object> request,session,application;
	
	@Override
	public String execute() throws Exception{
		//璁块棶application鑼冨洿鐨勫睘鎬у��
		Integer counter = (Integer)application.get("counter");
		if(counter==null)
			counter=1;
		else
			counter=counter+1;
		application.put("counter", counter);
		UserService userServ=new UserService();
		if(userServ.register(registUser)){
			//this.addActionMessage("娉ㄥ唽鎴愬姛锛岃鐧诲綍锛�");
			this.addActionMessage(this.getText("register.success"));
			//璁剧疆session鑼冨洿鐨勫睘鎬�
			session.put("user", registUser.getAccount());
			session.put("cart", new CartBean());
			request.put("tip", "鎮ㄥ凡娉ㄥ唽鎴愬姛锛�");
			return "success";
		}
		else{
			//this.addActionMessage("娉ㄥ唽澶辫触锛岃閲嶆柊娉ㄥ唽锛�");
			this.addActionMessage(this.getText("register.fail"));
			//璁剧疆request鑼冨洿鐨勫睘鎬�
			request.put("tip", "娉ㄥ唽澶辫触锛�");
			return "fail";
		}
	}
	@Override
	public UserBean getModel() {
		return this.registUser;
	}
	
	public void validateRegister() {
 		String account = registUser.getAccount();
 		String pwd = registUser.getPassword();
		HttpServletRequest request = ServletActionContext.getRequest();
		//String uri = request.getRequestURI().toString();
		String servletPath = request.getServletPath();
		try {
			if (servletPath.contains("Userregister")) {
				if (account == null || account.equals("")) {
					this.addFieldError("registUser.account", "璇疯緭鍏ユ偍鐨勭敤鎴峰悕锛�");
				}
				if (pwd == null || pwd.equals("")) {
					this.addFieldError("registUser.password", "璇疯緭鍏ユ偍鐨勫瘑鐮侊紒");
				}
			}

		} catch (Exception e) {
			throw e;
		}
	}
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;		
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;		
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
	public String userDelete()throws Exception{
		String account=(String) session.get("user");
		boolean result=DaoFactory.getUserDaoInstance().delete(account);
		if(result){
			session.put("delUser", account);
			session.remove(account);
			return "success";
		}
		else
			return "fail";
	}
	public String userEdit()throws Exception{
		String account=(String) session.get("user");
		boolean result=DaoFactory.getUserDaoInstance().update(account, registUser);
		if(result){
			session.put("user", account);
			session.put("account", registUser.getAccount());
			session.put("password", registUser.getPassword());
			session.put("usertype", registUser.getUsertype());
			return "success";
		}
		else
			return "fail";
	}
	
	private List<UserBean> users;

	public List<UserBean> getUsers() {
		return users;
	}

	public void setUsers(List<UserBean> users) {
		this.users = users;
	}
	
	public String getAllUsers() {
		UserService userServ = new UserService();
		users=userServ.getAllUsers();
		return "success";
	}
}
