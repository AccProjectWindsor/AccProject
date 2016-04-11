<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="css/MainFrame.css" rel="stylesheet" type="text/css" />
<title>Main Frame</title>
<script type="text/javascript" >

function setIfrmeUrl(url){
	
	alert(url);
	document.getElementById("subFrame").src = url;
	
	
};

</script>
</head>
<body>
	<div id="divMain">
		<div id="divHeader">
			<div class="divTitle">
				Welcome,
				<s:property value="mainFrameBean.loginBean.userName" />
			</div>
		</div>
		<div id="divItem">
			<s:iterator value="mainFrameBean.itemList" var="map"
				status="rowstatus">
				<s:property value="#map.key" />
				<s:iterator value="#map.value" var="list">
					<ul>

						<li><a href="javascript:setIfrmeUrl('<s:url action='%{#list.url}'/>');" >
						<s:property value="#list.text" /></a></li>
					</ul>
				</s:iterator>
			</s:iterator>
		</div>
		<div id="divFrames">
			<iframe id="subFrame" allowTransparency="true" scrolling="no" src="">
			</iframe>
		</div>
		<div id="divFooter">
			<h1></h1>
		</div>
	</div>
</body>
</html>