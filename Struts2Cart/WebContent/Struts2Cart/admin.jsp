<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员页面</title>
</head>
<body>
<center>
<%@ include file="menu.jsp"%>
<form action="initCartDb" name="dbform" method="post">
	请先选择是否初始化Struts2Cart所有数据库及表数据！
	<input type="radio" name="initdb" value="initcartdb" checked/>初始化 |
	<input type="radio" name="initdb" value="notinitcartdb" />不初始化，跳过！|
	<input type="submit" name="initdbBtn" value="提交初始化" />
</form>
<form action="i18nCart" name="i18nform" method="post">
	<br>
	请先选择国际化语言：中文或英文！
	<input type="radio" name="i18n" value="chinese" checked/>中文 |
	<input type="radio" name="i18n" value="english" />英文|
	<input type="submit" name="i18nBtn" value="提交国际化" />
</form>
</center>
</body>
</html>