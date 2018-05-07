<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<center>
		<s:i18n name="message">
			<%@ include file="../menu.jsp"%>
			<s:actionmessage />
			<s:actionerror />
			<s:fielderror />
			<s:form action="userLogin" method="post">
				<s:textfield name="loginUser.account" key="login.account.lable" />
				<s:password name="loginUser.password" key="login.password.lable" />
				<s:hidden name="loginUser.usertype" value="3" />
				<s:submit name="submit" key="login.submit.button" />
			</s:form>
			<hr />
			<a href="download?fileName=Struts2Cart.war">下载本站WAR文件:
				Struts2Cart.war</a>
		</s:i18n>
	</center>
</body>
</html>