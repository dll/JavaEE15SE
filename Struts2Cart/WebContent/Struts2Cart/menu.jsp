<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="cn.edu.chzu.xxxy.se15.javaee.struts.service.OnlineCounter"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();//getContextPath获取application的名称:Struts2Cart,请求URI：getRequestURI
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//basePath="http://localhost:8080/Struts2Cart/"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- baseaPath就是绝对路径 -->
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title>
</head>
<body>
	<center>
		<!-- if else逻辑标签 -->
	    <s:if test="%{#session.user!=null}">
	    	欢迎您，<s:property value="#session.user" /><!-- session对象的user值（K-V） -->
	    </s:if>
	    <s:else>
	    	欢迎您，<!-- bean标签 -->
	    	<s:bean name="cn.edu.chzu.xxxy.se15.javaee.struts.bean.UserBean" var="session">  
         		<s:param name="account">游客</s:param> <!-- 设置参数 --> 
         		<s:property value="#session.account"/><!-- 获取属性 -->  
     		</s:bean> 
     		|| 当前在线人数: <!-- ServLet监听器实现 -->
			<%=String.valueOf(OnlineCounter.getCounter()) %>
	    </s:else>| 
	    <a href="index.jsp">0.index</a>
		<a href="Struts2Cart/User/login.jsp">1.Login</a>
		<a href="Struts2Cart/user.jsp">2.User</a>
		<!-- 使用s:url action 请求动作allItems -->
		<a href="<s:url action="allItems"></s:url>">3.Item</a>
		<a href="Struts2Cart/cart.jsp">4.Cart</a>
		<a href="Struts2Cart/card.jsp">5.Card</a>
		<a href="Struts2Cart/customer.jsp">6.Customer</a>
		<a href="Struts2Cart/order.jsp">7.Order</a>||
		<a href="Struts2Cart/admin.jsp">8.Admin</a>||
		<!-- 使用html超链接a的href 请求动作userLogout -->
		<a href="userLogout">9.logout</a>
	</center>
	<hr />
</body>
</html>