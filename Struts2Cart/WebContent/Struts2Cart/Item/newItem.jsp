<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新用户注册</title>
<sx:head/>
</head>
<body>
	<s:i18n name="message">
	<s:actionmessage/>
	<s:actionerror/>
	<s:fielderror/>
	<s:form action="ItemAction" method="post" enctype="multipart/form-data">
		<s:textfield name="itemID" label="请输入商品编号" key="item.itemid.lable"/>
		<s:textfield name="title" label="请输入商品名称" key="item.title.lable"/>
		<s:textfield name="description" label="请输入商品简介" key="item.description.lable"/>
		<s:textfield name="cost" label="请输入商品价格" key="item.cost.lable"/>
		<s:textfield name="inventory" label="请输入商品库存" key="item.inventory.lable"/>
		<s:file name="upload" label="请上传商品图片" key="item.image.lable"/>
 		<s:submit value="新增" key="item.submit.button"/>
		<s:reset value="重置" key="item.submit.button"/>
	</s:form>   
	</s:i18n> 
</body>
</html>