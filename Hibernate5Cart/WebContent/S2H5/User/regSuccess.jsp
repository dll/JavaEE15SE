<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
</head>
<body>
<s:include value="../menu.jsp" />
	恭喜： 
	<s:property value="name" />
	<s:if test="sex">
		<s:text name="先生，" />
	</s:if>
	<s:else>
		<s:text name="女士，" />
	</s:else>
	<%-- <s:property value="sex" /> --%>
	注册成功！
	<s:set var="user" value="registUser" scope="session" />
	本站访问次数为[
	<s:property value="#application.counter" />]  亲{ 
	<s:property value="#session.user" /> }
	<s:property value="#request.tip" />
	<hr/>您的购物车：
	<table border=1>
		<s:iterator value="#session.shoppingcart.itemsOrdered">
			<tr>
				<th>编号</th>
				<th>书名</th>
				<th>说明</th>
				<th>单价</th>
				<th>数量</th>
			</tr>
			<tr>
				<td><s:property value="itemID" /></td>
				<td><s:property value="title" /></td>
				<td><s:property value="description" /></td>
				<td><s:property value="unitCost" /></td>
				<td><s:property value="numItems" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>