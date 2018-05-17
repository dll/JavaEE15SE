crud<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<!-- 数据标签property -->
<s:property value="loginUser.name"/>
<!-- 控制标签if/else -->
<s:if test="loginUser.sex">
	<s:text name="先生，"/>
</s:if>
<s:else>
	<s:text name="女士，"/>
</s:else>
操作成功!
<!-- 数据标签set -->
<s:set var="user" value="loginUser" scope="session"/>
</body>
</html>