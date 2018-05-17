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
<s:if test="loginUser.sex">
	<s:text name="先生，"/>
</s:if>
<s:else>
	<s:text name="女士，"/>
</s:else>
</td><tr>
<tr><td>出生日期：</td><td><s:property value="#request.loginUser.birthday" /> </td><tr>
<tr><td>电子邮箱：</td><td><s:property value="#request.loginUser.email"/></td><tr>
<s:iterator value="#request.loginUser.addresses" status="st">
	<tr><td>地址<s:property value="#st.count"/>：</td><tr>
    <tr><td>详细地址：</td><td><s:property value="detail" /></td><tr>
    <tr><td>邮政编码：</td><td><s:property value="zipcode" /></td><tr>
    <tr><td>联系电话：</td><td><s:property value="phone" /></td><tr>
    <tr><td>地址类型：</td><td><s:property value="type" /></td><tr>
</s:iterator>
</table>
<hr>
添加新地址：<p>
<s:form action="CustomeraddAddr" method="post">
	<s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>
	<s:textfield name="address.detail" label="详细地址" />
	<s:textfield name="address.zipcode" label="邮政编码" />
	<s:textfield name="address.phone" label="联系电话" />
	<s:textfield name="address.type" label="地址类型（家庭、公司等）" />
    <s:submit value="添加"/>
</s:form>
<hr>
<s:form action="Customerupdate" method="post" namespace="/Customer">
    <s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>
    <s:textfield name="loginUser.account" label="用户名不能修改" value="%{#request.loginUser.account}" readonly="true"/>
    <s:textfield type="password" name="loginUser.password" label="修改密码" value="%{#request.loginUser.password}"/>
    <s:textfield type="password" name="loginUser.repassword" label="请再次输入密码" value="%{#request.loginUser.password}"/>
    <s:textfield name="loginUser.name" label="修改真实姓名" value="%{#request.loginUser.name}"/>
    <s:radio name="loginUser.sex" list="#{1 : '男', 0 : '女'}" label="修改性别" value="%{#request.loginUser.sexStr}"/>
    <sx:datetimepicker name="loginUser.birthday" displayFormat="yyyy-mm-dd" label="修改生日" value="%{#request.loginUser.birthday}"/> 
    <s:textfield name="loginUser.phone" label="修改联系电话" value="%{#request.loginUser.phone}"/>
    <s:textfield name="loginUser.email" label="修改电子邮箱" value="%{#request.loginUser.email}"/>
    <s:textfield name="loginUser.address" label="修改联系地址" value="%{#request.loginUser.address}"/>
    <s:textfield name="loginUser.zipcode" label="修改邮政编码" value="%{#request.loginUser.zipcode}"/>
    <s:textfield name="loginUser.fax" label="修改传真号码" value="%{#request.loginUser.fax}"/>
    <s:submit value="修改"/>
</s:form>

<s:form action="Customerdelete" method="post" namespace="/Customer">
	<s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>
	<s:submit value="删除"/>
</s:form>
<hr>
<a href="./allItems">查看所有商品信息</a><br>
</body>
</html>