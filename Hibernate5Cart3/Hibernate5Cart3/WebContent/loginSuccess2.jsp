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
<s:property value="#request.tip"/><p>

<hr>
<table>
<tr><td>个人信息：<p></td></tr>
<tr><td>用户名：</td><td><s:property value="#request.loginUser.account" /></td></tr>
<tr><td>密码：</td><td><s:property value="#request.loginUser.password"/></td><tr>
<tr><td>真实姓名：</td><td><s:property value="#request.loginUser.name"/></td><tr>
<tr><td>性别：</td><td>
<s:if test="#request.loginUser.sex">
	<s:text name="先生，"/>
</s:if>
<s:else>
	<s:text name="女士，"/>
</s:else>
</td><tr>
<tr><td>出生日期：</td><td><s:property value="#request.loginUser.birthday" /> </td><tr>
<tr><td>电子邮箱：</td><td><s:property value="#request.loginUser.email"/></td><tr>
<s:if test="#request.loginUser.address">
	<s:form action="UserdelAddr" method="post">
	<s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>
	<tr><td>详细地址：</td><td><s:property value="#request.loginUser.address.detail" /></td><tr>
    <tr><td>邮政编码：</td><td><s:property value="#request.loginUser.address.zipcode" /></td><tr>
    <tr><td>联系电话：</td><td><s:property value="#request.loginUser.address.phone" /></td><tr>
    <tr><td>地址类型：</td><td><s:property value="#request.loginUser.address.type" /></td><tr>
    <tr><td><s:submit value="删除	"/></td><tr>
    </s:form>
</s:if>
<s:else>
	添加新地址：<p>
	<s:form action="UseraddAddr" method="post">
	<s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>
	<s:textfield name="address.detail" label="详细地址" />
	<s:textfield name="address.zipcode" label="邮政编码" />
	<s:textfield name="address.phone" label="联系电话" />
	<s:textfield name="address.type" label="地址类型（家庭、公司等）" />
    <s:submit value="添加"/>
	</s:form>
</s:else>

</table>


<a href="./allItems">查看所有商品信息</a><br>
</body>
</html>