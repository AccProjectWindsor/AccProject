<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Student</title>
</head>
<body>

	<s:form method="post" action="editStudent">
		<p>
			<s:textfield name="studentInfoBean.stuId" label="Student ID" />
			<s:textfield name="studentInfoBean.firstName" label="First Name" />
			<s:textfield name="studentInfoBean.lastName" label="Last Name" />
			<s:textfield name="studentInfoBean.email" label="Email" />
			<s:textfield name="studentInfoBean.telephone" label="Telephone" />
			<s:textfield name="studentInfoBean.country" label="Countrye" />
			<s:textfield name="studentInfoBean.status" label="Status" />
			<s:textfield name="studentInfoBean.address" label="Address" />
			<s:textfield name="studentInfoBean.postcode" label="Postcode" />
			<s:textfield name="studentInfoBean.dateOfBirth" label="Date Of Birth" />
			<s:textfield name="studentInfoBean.gender" label="Gender" />
		</p>
		<s:submit />
	</s:form>
</body>
</html>