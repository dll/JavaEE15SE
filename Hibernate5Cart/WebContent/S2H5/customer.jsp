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
	<s:form action="customer" method="post">
		<s:textfield name="account" label="请输入用户名" key="customer.account.lable"/>
		<s:password name="password" label="请输入密码" key="customer.password.lable"/>
		<s:password name="repassword" label="请再次输入密码"/>
		<s:textfield name="name" label="请输入真实姓名"/>
		<s:radio name="gender" list="#{1:'男',0:'女'}" label="请输入性别"/>
		<sx:datetimepicker name="birthday" displayFormat="yyyy-mm-dd" label="请输入生日"/> 
		<s:textfield name="address" label="请输入联系地址"/>
		<s:textfield name="phone" label="请输入联系电话"/>
		<s:textfield name="email" label="请输入电子邮箱"/><br/>
		<s:submit value="注册" key="customer.submit.button"/>
		<s:reset value="重置" key="customer.submit.button"/><br/>
	</s:form>   
	<hr/>
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