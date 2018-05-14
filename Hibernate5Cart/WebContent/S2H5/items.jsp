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
<%@ include file="menu.jsp"%>
	<%
		ValueStack vs = (ValueStack) request.getAttribute("struts.valueStack");
		List<ItemBean> items = (List<ItemBean>) vs.findValue("items");
	%>
	VS商品列表
	<table border=1>
		<tr>
			<th>编号</th><th>名称</th>	<th>说明</th><th>单价</th><th>库存</th><th>图片</th>
		</tr>
		<% Iterator<ItemBean> it=items.iterator(); 
	   	   while(it.hasNext()){
	   			ItemBean item = (ItemBean)it.next(); %> 
			<tr>
		    <td><%=item.getItemID() %></td>
		    <td><%=item.getTitle() %></td>
		    <td><%=item.getDescription() %></td>  
		    <td><%=item.getCost() %></td>
		    <td><%=item.getInventory() %></td>
		    <td><%=item.getImage() %>
		    	<img src='<%=item.getImage() %>' width=50 height=50/>
		    </td>
			</tr>
		<%} %>
  </table>
</center>
</body>
</html>