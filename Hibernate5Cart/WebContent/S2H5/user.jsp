<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户页面</title>
</head>
<body>
	<center>
		<%@ include file="menu.jsp"%>

		<a href="User/register.jsp">注册用户</a><br />

		<s:url var="deleteurl" action="userDelete">
			<s:param name="account">
				<s:property value="#session.user" />
			</s:param>
		</s:url>
		<s:a href="%{deleteurl}">删除用户</s:a>
		<br /> <a href="User/edit.jsp">修改用户</a><br /> <a href="User/find.jsp">查询用户</a>
	</center>
</body>
</html>