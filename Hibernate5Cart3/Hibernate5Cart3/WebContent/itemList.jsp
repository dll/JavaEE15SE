<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Item List</title>
</head>
<body>
<center>商品列表</center>
<table border=1> 
<tr>
<th>编号</th>
<th>书名</th>
<th>说明</th>
<th>单价</th>
<th>图片？</th>
</tr>
<s:iterator value="items" >
<tr>
    <td><s:property value="itemID"/></td>
    <td><s:property value="title"/></td>
    <td><s:property value="description"/></td>  
    <td><s:property value="cost"/></td>
    <td><s:property value="image"/></td>
</tr>
</s:iterator>
</table>
</body>
</html>