<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="cn.edu.chzu.xxxy.se15.javaee.struts.service.OnlineCounter"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();//getContextPath获取application的名称:Struts2Cart,请求URI：getRequestURI +"/"
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//basePath="http://localhost:8080/Hibernate5Cart/"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title>
</head>
<body>
<s:i18n name="message">
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
     		|| 当前在线人数:
			<%=String.valueOf(OnlineCounter.getCounter()) %>
	    </s:else>| 
	    <a href="index.jsp"><s:text  name="menu.0.Index"><s:param >首页</s:param></s:text></a>
		<a href="S2H5/User/login.jsp"><s:text name="menu.1.Login"><s:param >登录</s:param></s:text></a>
		<a href="S2H5/user.jsp"><s:text name="menu.2.User"><s:param >用户管理</s:param></s:text></a>
		<!-- 使用s:url action 请求动作allItems -->
		<a href="<s:url action="allItems"></s:url>"><s:text name="menu.3.Item"><s:param >商品管理</s:param></s:text></a>
		<a href="S2H5/cart.jsp"><s:text name="menu.4.Cart"><s:param >购物车管理</s:param></s:text></a>
		<a href="S2H5/card.jsp"><s:text name="menu.5.Card"><s:param >银行卡管理</s:param></s:text></a>
		<a href="S2H5/customer.jsp"><s:text name="menu.6.Customer"><s:param >顾客管理</s:param></s:text></a>
		<a href="S2H5/order.jsp"><s:text name="menu.7.Order"><s:param >订单管理</s:param></s:text></a>||
		<a href="S2H5/admin.jsp"><s:text name="menu.8.Admin"><s:param >设置</s:param></s:text></a>||
		<!-- 使用html超链接a的href 请求动作userLogout -->
		<a href="userLogout"><s:text name="menu.9.Logout"><s:param >注销</s:param></s:text></a>
	</center>
	<hr />
	</s:i18n>
</body>
</html>