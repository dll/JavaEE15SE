<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<!-- ���ݱ�ǩproperty -->
<s:property value="loginUser.name"/>
<!-- ���Ʊ�ǩif/else -->
<s:if test="loginUser.sex">
	<s:text name="������"/>
</s:if>
<s:else>
	<s:text name="Ůʿ��"/>
</s:else>
��ע��ɹ��ˣ�
</body>
</html>