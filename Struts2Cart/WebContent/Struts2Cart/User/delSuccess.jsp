<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除成功</title>
</head>
<body>
<s:include value="../menu.jsp" />
	恭喜删除成功！
	<s:set var="user" value="registUser" scope="session" />
	您共访问本站次数为[
	<s:property value="#application.counter" />]  再次欢迎亲{ 
	<s:property value="#session.delUser" /> }光临本站！再见！！！
	<s:property value="#request.tip" />

</body>
</html>