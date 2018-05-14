<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
<s:i18n name="message">
<s:include value="/S2H5/menu.jsp" />
	亲{ 
	<s:property value="#session.user" /> }
	<s:property value="#request.tip" />
	您的登录信息为：
	<table border=1>
		<tr>
			<th>账号</th>
			<th>密码</th>
			<th>类型</th>
		</tr>
		<tr>
			<td><s:property value="#session.account" /></td>
			<td><s:property value="#session.password" /></td>
			<td><s:property value="#session.usertype" /></td>
		</tr>
	</table>
	<hr/>
	<s:actionmessage/>
	<s:actionerror/>
	<s:fielderror/>
	<s:form action="userEdit" method="post">
		<s:textfield name="account" label="账号不可修改" key="edit.account.lable" value="%{#session.account}" readonly="true"/>
		<s:password name="password" label="*请输入密码" key="edit.password.lable" value="%{#session.password}"/>
 		<s:select  name="usertype" list="#{1:'管理员',2:'VIP用户',3:'普通用户',4:'游客'}"  label="*请选择用户类型" listKey="key" listValue="value"  headerKey="0" headerValue="==请选择=="/>
		<s:submit value="更新" key="edit.submit.button"/>
		<s:reset value="重置" key="edit.submit.button"/><br/>
	</s:form>   
	</s:i18n> 
</body>
</html>