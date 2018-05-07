
package cn.edu.chzu.xxxy.se15.javaee.struts.action;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.chzu.xxxy.se15.javaee.struts.bean.CartBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.bean.UserBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.service.UserService;

public class LoginAction extends ActionSupport{
	
	private static final long serialVersionUID = 8153220869598441387L;
	private UserBean loginUser;
	private Map<String, Object> request,session,application;
	
	public UserBean getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(UserBean loginUser) {
		this.loginUser = loginUser;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		//获取ActionContext对象
		ActionContext ctx= ActionContext.getContext();
		//通过ActionContext对象获取请求、会话和上下文对象相关联的Map对象
		request=(Map<String, Object>) ctx.get("request");
		session=(Map<String, Object>) ctx.getSession();
		application=(Map<String, Object>) ctx.getApplication();
		//访问application范围的属性值:计数
		Integer counter = (Integer)application.get("counter");
		if(counter==null) counter=1;
		else counter=counter+1;
		//设置application范围的属性
		application.put("counter", counter);
		UserService userServ = new UserService();
		try {
			//session.remove("user");//登录前注销
			if(userServ.login(loginUser)){
				//this.addActionMessage("登录成功！");
				this.addActionMessage(this.getText("login.success"));
				session.put("user", loginUser.getAccount());//与account只要保留一个
				session.put("account", loginUser.getAccount());
				session.put("password", loginUser.getPassword());
				session.put("usertype", loginUser.getUsertype());
				session.put("CartBean", new CartBean());
				request.put("tip", "您已登录成功！");
				if(1==loginUser.getUsertype())
					return "admin";
				else
					return "success";
			}else{
				//this.addActionError("用户名或密码错误，请重新输入！");
				this.addActionError(this.getText("login.error"));
				//设置request范围的属性
				request.put("tip", "登录失败，欢迎您浏览商品！");
				return "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(this.getText("login.exception"));
			System.out.println("登录异常！");
			return "exception";
		}
	}
	//手工验证
	public void validateLogin() {
		String account = loginUser.getAccount();
		String pwd = loginUser.getPassword();
		int type=loginUser.getUsertype();

		if (account == null || account.equals("")) {
			this.addFieldError("loginUser.account", this.getText("login.account.null"));
		}
		if (pwd == null || pwd.equals("")) {
			this.addFieldError("loginUser.password", this.getText("login.password.null"));
		}
		if(type==3){
			this.addFieldError("loginUser.usertype", this.getText("login.usertype.3"));
		}
	}
	/**
	 * 注销用户
	 * */
	public String logout(){
		ActionContext ctx= ActionContext.getContext();
		//通过ActionContext对象获取请求、会话和上下文对象相关联的Map对象
		session=(Map<String, Object>) ctx.getSession();
		if(session!=null ){
			session.remove("user");
			session.remove("account");
			return "success";
		}
		else
			return "exception";
	}
	
	/**
	 * 下载本站war文件
	 * */
	private String fileName;//用户请求的文件名  
     
    private String inputPath;//下载资源的路径(在struts配置文件中设置)  
      
    public void setInputPath(String inputPath) {  
        this.inputPath = inputPath;  
    }  
  
    public String getInputPath() {  
        return inputPath;  
    }  
  
    public void setFileName(String fileName) {  
        this.fileName = fileName;  
    }  
  
    public String getFileName() {  
        return fileName;  
    }  
    /**
     * 响应下载的动作调用的方法
     * */
    public String downloadFile() throws Exception {  
        ServletContext context = ServletActionContext.getServletContext();  
          
        String downloadDir = context.getRealPath("/download");  
        String downloadFile = context.getRealPath(inputPath);  
        //防止用户请求不安全的资源  
        if(!downloadFile.startsWith(downloadDir)) {  
            return null;  
        }  
        return "success";  
    }  
    /*  
     * 获取输入流资源  
     */  
    public InputStream getInputStream() throws Exception {  
        String path = inputPath + File.separatorChar + new String(fileName.getBytes("ISO-8859-1"), "UTF-8");  
        return ServletActionContext.getServletContext().getResourceAsStream(path);  
    }  
    /*  
     * 获取下载时文件默认的文件名  
     */  
    public String getDownloadFileName() {  
        String downloadFileName = fileName;  
        try {  
            downloadFileName = URLEncoder.encode(downloadFileName, "ISO-8859-1");  
        } catch (UnsupportedEncodingException e) {  
            e.getMessage();  
            e.printStackTrace();  
        }  
        return downloadFileName;  
    }  
}