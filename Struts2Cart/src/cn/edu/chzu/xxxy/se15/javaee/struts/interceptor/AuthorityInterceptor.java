package cn.edu.chzu.xxxy.se15.javaee.struts.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class AuthorityInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		String user = (String)session.get("user");
		if(user!=null){
			return invocation.invoke();
		}
		else{
			ctx.put("tip", "您还没有登录，请输入用户名和密码登录系统");
			return Action.LOGIN;
		}
	}
}
