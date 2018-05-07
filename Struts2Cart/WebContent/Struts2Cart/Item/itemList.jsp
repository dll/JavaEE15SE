<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.opensymphony.xwork2.util.ValueStack,cn.edu.chzu.xxxy.se15.javaee.struts.bean.ItemBean,
            java.util.List,java.util.Iterator"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品分页列表</title>
</head>
<body>
<center>
<%@ include file="../menu.jsp"%>
 <a href="Struts2Cart/Item/newItem.jsp">New Item</a>|
 <a href="Struts2Cart/Item/deleteItem.jsp">Delete Item</a>|
 <a href="Struts2Cart/Item/editItem.jsp">Edit Item</a>|
 <a href="Struts2Cart/Item/findItem.jsp">Find Item</a>
<hr/>
	VS商品分页列表
	<table border=1>
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>说明</th>
			<th>单价</th>
			<th>库存</th>
			<th>图片</th>
		</tr>
		<s:iterator value="items">
			<tr>
				<td><s:property value="itemID" /></td>
				<td><s:property value="title" /></td>
				<td><s:property value="description" /></td>
				<td><s:property value="cost" /></td>
				<td><s:property value="inventory"/></td>
				<td><s:property value="image"/></td>
				<td><img src="<%=request.getContextPath()%>/<s:property value="image"/>"
				  width="auto" height="auto" alt="<s:property value="image"/>" /> </td>
			</tr>
		</s:iterator>
	</table><br><br>
	价格低于20元的商品有：	<br>
	<s:iterator value="items.{?#this.cost<20}">
		<li><s:property value="title" />： <s:property value="cost" />元</li>
	</s:iterator><p>
		名称为《JAVAEE技术实验指导教程》的商品的价格为：
		<s:property value="items.{?#this.title=='JAVAEE技术实验指导教程'}.{cost}[0]" />元<p>
		<s:url value="%{items.{title}[0]}" />
</center>
</body>
</html>