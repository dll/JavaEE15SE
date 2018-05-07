<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新用户注册</title>
<sx:head/>
</head>
<body>
	<s:i18n name="message">
	<s:actionmessage/>
	<s:actionerror/>
	<s:fielderror/>
	<s:form action="userRegister" method="post">
		<s:textfield name="account" label="请输入账号" key="login.account.lable"/>
		<s:password name="password" label="请输入密码" key="login.password.lable"/>
 		<s:select  name="usertype" list="#{1:'管理员',2:'VIP用户',3:'普通用户',4:'游客'}"  label="请选择用户类型" listKey="key" listValue="value"  headerKey="0" headerValue="==请选择=="/>
		<s:submit value="注册" key="login.submit.button"/>
		<s:reset value="重置" key="login.submit.button"/><br/>
	</s:form>   
	</s:i18n> 
</body>
</html>