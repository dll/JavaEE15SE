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
<s:form action="register" method="post">
    <s:textfield name="loginUser.account" label="�������û���"/>
    <s:password name="loginUser.password" label="����������"/>
    <s:password name="loginUser.repassword" label="���ٴ���������"/>
    <s:textfield name="loginUser.name" label="��������ʵ����"/>
    <s:radio name="loginUser.sex" list="#{1 : '��', 0 : 'Ů'}" label="�������Ա�"/>
    <sx:datetimepicker name="loginUser.birthday" displayFormat="yyyy-mm-dd" label="����������"/> 
    <s:textfield name="loginUser.address" label="��������ϵ��ַ"/>
    <s:textfield name="loginUser.phone" label="��������ϵ�绰"/>
    <s:textfield name="loginUser.email" label="�������������"/>
    <s:submit value="ע��"/>
    <s:reset value="����"/>
</s:form>    
</body>
</html>