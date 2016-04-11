<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Company List</title>

<script type="text/javascript">
	function setTarget(code) {
		alert(code);
		document.getElementById("targetID").value = code;
	}
</script>

</head>
<body>
	<h1>Internship List</h1>
	<table>

		<s:iterator value="internList" var="intern">
			<s:form method="post" action="showIntern"
				onsubmit="setTarget('%{#company.code}');">
				<tr>
					<td><s:property value="#intern.internCode" /></td>
					<td><s:property value="#intern.companyCode" /></td>
					<td><s:property value="#intern.companyName" /></td>
					<td><s:property value="#intern.companyAdress" /></td>
					<td><s:property value="#intern.interShipTitle" /></td>
					<td><s:property value="#intern.jobType" /></td>
					<td><s:property value="#intern.internTypeCode" /></td>
					<td><s:property value="#intern.cntctPsnFName" /></td>
					<td><s:property value="#intern.cntctPsnLName" /></td>
					<td><s:property value="#intern.cntctPsnPosition" /></td>
					<td><s:property value="#intern.telephone" /></td>
					<td><s:property value="#intern.email" /></td>
					<td><s:property value="#intern.notes" /></td>
				</tr>
			</s:form>
		</s:iterator>
		<s:hidden id="targetID" name="targetID" />
		<s:hidden name="operationFlag"
			value="%{@com.ims.statics.OperationType@UPDATE}" />

	</table>

</body>
</html>