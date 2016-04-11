<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Main Frame</title>
</head>
<body>

	<div
		style="background-color: #000000; float: left; height: 80px; width: 100%">
		<h1 style="color: #ffffff;">
			Welcome,
			<s:property value="mainFrameBean.loginBean.userName" />
		</h1>
	</div>
	<div
		style="background-color: #eeeeee; float: left; height: 80%; width: 20%">
		<s:iterator value="mainFrameBean.itemList" var="map"
			status="rowstatus">
			<s:property value="#map.key" />
			<s:iterator value="#map.value" var="list">
				<ul>
					<li><a href="<s:url action='%{#list.url}' />"><s:property
								value="#list.text" /></a></li>
				</ul>
			</s:iterator>
		</s:iterator>
	</div>
	<div
		style="background-color: #fffff4; float: right; height: 80%; width: 80%">
		<s:iterator value="mainFrameBean.contentList" var="map"
			status="rowstatus">
			<s:property value="#map.key" />
			<s:iterator value="#map.value" var="list">
				<ul>
					<li><a href="<s:url action='#list.url' />"><s:property
								value="#list.text" /></a></li>
				</ul>
			</s:iterator>
		</s:iterator>
	</div>
	<div
		style="background-color: #000000; float: left; height: 80px; width: 100%">
		<h1></h1>
	</div>
</body>
</html>