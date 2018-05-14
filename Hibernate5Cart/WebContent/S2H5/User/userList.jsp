<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.opensymphony.xwork2.util.ValueStack,cn.edu.chzu.xxxy.se15.javaee.struts.bean.ItemBean,
            java.util.List,java.util.Iterator"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
</head>
<body>
	<center>
	<%@ include file="../menu.jsp"%>
		OGNL用户列表
		<table border=1>
			<tr>
				<th>账号</th>
				<th>密码</th>
				<th>类型</th>
			</tr>
			<s:iterator value="users">
				<tr>
					<td><s:property value="account" /></td>
					<td><s:property value="password" /></td>
					<td><s:property value="usertype" /></td>
				</tr>
			</s:iterator>
		</table>
	</center>
</body>
</html>