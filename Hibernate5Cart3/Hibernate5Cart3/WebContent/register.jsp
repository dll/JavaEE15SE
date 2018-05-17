<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>register page</title>
<sx:head/>
</head>
<body>
<s:form action="Customerregister" method="post" namespace="/Customer">
    <s:textfield name="loginUser.account" label="请输入用户名"/>
    <s:password name="loginUser.password" label="请输入密码"/>
    <s:password name="loginUser.repassword" label="请再次输入密码"/>
    <s:textfield name="loginUser.name" label="请输入真实姓名"/>
    <s:radio name="loginUser.sex" list="#{1 : '男', 0 : '女'}" label="请输入性别"/>
    <sx:datetimepicker name="loginUser.birthday" displayFormat="yyyy-mm-dd" label="请输入生日"/> 
    <s:textfield name="loginUser.phone" label="请输入联系电话"/>
    <s:textfield name="loginUser.email" label="请输入电子邮箱"/>
    <s:textfield name="loginUser.address" label="请输入联系地址"/>
    <s:textfield name="loginUser.zipcode" label="请输入邮政编码"/>
    <s:textfield name="loginUser.fax" label="请输入传真号码"/>
    <s:submit value="注册"/>
    <s:reset value="重置"/>
</s:form>     
</body>
</html>