package cn.edu.chzu.xxxy.se15.javaee.struts.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccessFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null 
				&& request.getRequestURI().indexOf("login.jsp") == -1
				&& request.getRequestURI().indexOf("register.jsp") == -1 
				&& request.getRequestURI().indexOf("index.jsp") == -1
				&& request.getRequestURI().indexOf("admin.jsp") == -1
				//&& request.getRequestURI().indexOf("itemList.jsp") == -1
				){
			response.sendRedirect("/Struts2Cart/Struts2Cart/User/login.jsp");
			return;
		}
		filterChain.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
