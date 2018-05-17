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
<%@ include file="../menu.jsp" %>
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
		<s:submit value="register" key="customer.submit.button"/>
		<s:reset value="reset" key="customer.submit.button"/><br/>
	</s:form>
	</s:i18n> 
</center>
</body>
</html>