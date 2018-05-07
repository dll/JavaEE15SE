<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="cn.edu.chzu.xxxy.se15.javaee.struts.service.ItemService,java.util.List,
		cn.edu.chzu.xxxy.se15.javaee.struts.bean.ItemBean"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Struts2Cart主页</title>
</head>
<body>
	<center>
	<s:include value="Struts2Cart/menu.jsp" />
	<s:hidden name="user" value="4" />
	<s:hidden name="usertype" value="4" />
	<%
		ItemService itemServ = new ItemService();
		List<ItemBean> items = itemServ.getAllItems();
	%>
		JSP VS显示商品列表
		<table border=1>
			<tr>
				<th>编号</th>
				<th>名称</th>
				<th>说明</th>
				<th>单价</th>
				<th>库存</th>
				<th>图片</th>
			</tr>
			<% 
				if(items.size()==0)
					out.write("<tr>数据库中无商品！</tr>");
				else{
					for(int i=0;i<items.size();i++){
						out.write("<tr><td>");
						out.write(items.get(i).getItemID());
						out.write("</td><td>");
						out.write(items.get(i).getTitle());
						out.write("</td><td>");
						out.write(items.get(i).getDescription());
						out.write("</td><td>");
						out.write(String.valueOf(items.get(i).getCost()));
						out.write("</td><td>");
						out.write(String.valueOf(items.get(i).getInventory()));
						out.write("</td><td>");
						//out.write(items.get(i).getImage());
						out.write("<img src='"+items.get(i).getImage());
						out.write("' width=50 height=50 alt='暂无图片'/></td></tr>");
					}				
				}					
			%>
		</table>		
	</center>
</body>
</html>