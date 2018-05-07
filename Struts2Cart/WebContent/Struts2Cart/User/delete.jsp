<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除用户</title>
</head>
<body>
<s:include value="/Struts2Cart/menu.jsp" />
	本站访问次数为[
	<s:property value="#application.counter" />]  亲{ 
	<s:property value="#session.user" /> }
	<s:property value="#request.tip" />
	<s:submit name="deleteUser" ></s:submit>
</body>
</html>