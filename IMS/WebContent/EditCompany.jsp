<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Company</title>
</head>
<body>

	<s:form method="post" action="editCompany">
	<p>
		<s:textfield name="companyInfoBean.name" label="Company Name" />
		<s:textfield name="companyInfoBean.address" label="Address" />
		<s:textfield name="companyInfoBean.city" label="City" />
		<s:textfield name="companyInfoBean.postcode" label="Post Code" />
		<s:textfield name="companyInfoBean.country" label="Country" />
		<s:textfield name="companyInfoBean.website" label="Website" />
		<s:textarea name="companyInfoBean.note" label="Note" />
	</p>
	<s:submit />
	</s:form>
</body>
</html>