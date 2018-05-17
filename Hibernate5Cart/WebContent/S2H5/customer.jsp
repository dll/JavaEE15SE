<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新顾客注册</title>
<sx:head/>
</head>
<body>
<center>
<%@ include file="menu.jsp" %>
	<s:i18n name="message">
	<s:actionmessage/><!-- 输入校验 -->
	<s:actionerror/>
	<s:fielderror/>
	<center>
		<a href="S2H5/Customer/register.jsp">注册顾客</a><br />
		<s:url var="deleteurl" action="customerDelete">
			<s:param name="account">
				<s:property value="#session.customer" />
			</s:param>
		</s:url>
		<s:a href="%{deleteurl}">删除顾客</s:a>
		<br/> <a href="S2H5/Customer/edit.jsp">修改顾客</a>
		<br/> <a href="S2H5/Customer/find.jsp">查询顾客</a>
	</center>
	
	<s:if test="customerList.size() > 0">
	<table border="1px" cellpadding="8px">
		<tr>
			<th>account</th><th>password</th><th>name</th><th>gender</th>
			<th>birthday</th><th>address</th><th>phone</th><th>email</th>
			<th>usertype</th><th>hobby</th><th>introduction</th>
		</tr>
		<s:iterator value="customerList" status="userStatus">
			<tr>
				<td><s:property value="account" /></td>
				<td><s:property value="password" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="gender" /></td>
				<td><s:property value="birthday" /></td>
				<td><s:property value="address" /></td>
				<td><s:property value="phone" /></td>
				<td><s:property value="email" /></td>
				<td><s:property value="usertype" /></td>
				<td><s:property value="hobby" /></td>
				<td><s:property value="introduction" /></td>
			</tr>
		</s:iterator>
	</table>
	</s:if>
	</s:i18n> 
</center>
</body>
</html>