<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 数据标签property -->
<s:property value="customer.name"/>
<!-- 控制标签if/else -->
<s:if test="customer.gender">
	<s:text name="先生，"/>
</s:if>
<s:else>
	<s:text name="女士，"/>
</s:else>
您注册成功了！
<!-- 数据标签set -->
<s:set var="user" value="customer" scope="session"/>
</body>
</html>