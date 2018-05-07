<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<body>
	<center>
		<%@ include file="menu.jsp"%>
		您的购物车：
		<table border=1>
			<s:iterator value="#session.CartBean.itemsOrdered">
				<tr>
					<th>编号</th>	<th>名称</th>	<th>说明</th>	<th>单价</th>	<th>数量</th>
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
		<br> <a href="./allItems">查看所有商品信息</a><br>
	</center>
</body>
</html>