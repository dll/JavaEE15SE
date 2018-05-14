<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
<s:include value="/S2H5/menu.jsp" />
	<s:property value="#request.tip" />
	当前用户信息：
	<table border=1>
		<tr>
			<th>账号</th>
			<th>密码</th>
			<th>类型</th>
		</tr>
		<tr>
			<td><s:property value="#session.account" /></td>
			<td><s:property value="#session.password" /></td>
			<td><s:property value="#session.usertype" /></td>
		</tr>
	</table>
	<hr/>
	所有用户信息：
	<a href="allUsers">查看所有用户信息...</a><br>
</body>
</html>