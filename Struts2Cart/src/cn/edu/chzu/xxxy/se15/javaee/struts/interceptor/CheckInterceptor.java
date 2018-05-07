package cn.edu.chzu.xxxy.se15.javaee.struts.interceptor;

import java.util.Locale;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = -1112495747942034188L;

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		ActionContext ac = ai.getInvocationContext();
		Map<String, Object> session = ac.getSession();
		Locale locale = (Locale)session.get("WW_TRANS_I18N_LOCALE");
		if(locale==null){
			locale = new Locale("zh","CN");
			session.put("WW_TRANS_I18N_LOCALE",locale);
		}
		return ai.invoke();
	}

}