<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银行卡信息</title>
</head>
<body>
<%@ include file="menu.jsp"%>
	<s:i18n name="message">
		<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/struts2cartdb?useUnicode=true&characterEncoding=utf-8"
			user="root" password="" />
		<sql:query dataSource="${snapshot}" var="result">
			SELECT * from cards;
		</sql:query>
		<center>
			<h2>JSTL标签库显示银行卡信息<br></h2>
			<c:if test="${empty result.rows}">
　　				没有银行卡信息！
			</c:if>
			<c:if test="${!empty result.rows}">
				<table border="1" cellpadding="10" cellspacing="0">
					<tr>
						<td>银行名称</td>
						<td>银行卡号</td>
						<td>银行卡密码</td>
						<td>*修改*</td>
						<td>*删除*</td>
					</tr>
					<c:forEach items="${result.rows}" var="row">
						<tr>
							<td>${row.name}</td>
							<td>${row.cardno}</td>
							<td>${row.password}</td>
							<td><a href="#">修改</a></td>
							<td><a href="#">删除</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</center>
	</s:i18n>
</body>
</html>