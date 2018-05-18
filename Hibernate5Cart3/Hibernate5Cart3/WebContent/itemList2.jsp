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
	<table border=1>
		<tr>
			<th>书名</th>
		</tr>
		<s:iterator value="items" id="object">
			<tr>
				<td><s:property value="object" /></td>
			</tr>
		</s:iterator>
	</table>
	<hr>
	<table border=1>
		<tr>
			<th>书名</th>
			<th>单价</th>
		</tr>
		<s:iterator value="items" id="object">
			<tr>
				<td><s:property value="#object[0]" /></td>
				<td><s:property value="#object[1]" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>