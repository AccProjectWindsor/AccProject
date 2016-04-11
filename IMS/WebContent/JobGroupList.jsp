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
		document.getElementById("targetID").value = code;
	}
</script>

</head>
<body>
	<h1>Company List</h1>
	<table>

		<s:iterator value="companyList" var="company">
			<s:form method="post" action="showCompany"
				onsubmit="setTarget('%{#company.code}');">
				<tr>
					<td><s:property value="#company.code" /></td>
					<td><s:property value="#company.name" /></td>
					<td><s:property value="#company.address" /></td>
					<td><s:property value="#company.city" /></td>
					<td><s:property value="#company.postcode" /></td>
					<td><s:property value="#company.country" /></td>
					<td><s:property value="#company.website" /></td>
					<td><s:property value="#company.website" /></td>
					<td><s:submit value="Edit" /></td>
				</tr>
			</s:form>
		</s:iterator>
		<s:hidden id="targetID" name="targetID" />
		<s:hidden name="operationFlag"
			value="%{@com.ims.statics.OperationType@UPDATE}" />

	</table>

</body>
</html>