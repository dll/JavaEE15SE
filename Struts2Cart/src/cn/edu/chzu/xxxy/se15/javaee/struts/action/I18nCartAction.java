package cn.edu.chzu.xxxy.se15.javaee.struts.action;

import java.util.Locale;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class I18nCartAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private String i18n="";
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> session=null;  
		//获取ActionContext对象
		ActionContext ctx= ActionContext.getContext();
		//通过ActionContext对象获取请求、会话和上下文对象相关联的Map对象
		session=(Map<String, Object>) ctx.getSession();
		if("chinese".equals(getI18n()))
		{		
			System.out.println(" \n选择中文!");
            Locale locale = new Locale("zh","CN");  
            session.put("WW_TRANS_I18N_LOCALE",locale);  
			return "success";
		}
		else if("english".equals(getI18n())){
			System.out.println(" \n选择英文!");
	        Locale locale = new Locale("en","US");  
	        session.put("WW_TRANS_I18N_LOCALE",locale); 
			return "success";
		}else{
			System.out.println(" \n没有选择本地化语言!");
			return "input";
		}
	}

	public String getI18n() {
		return i18n;
	}

	public void setI18n(String i18n) {
		this.i18n = i18n;
	}
}
