<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Student List</title>

<script type="text/javascript">
	function setTarget(code) {
		document.getElementById("targetID").value = code;
	}
</script>

</head>
<body>
	<h1>Student List</h1>
	<table>

		<s:iterator value="studentList" var="student">
			<s:form method="post" action="editStudent"
				onsubmit="setTarget('%{#student.stuId}');">
				<tr>
					<td><s:property value="#student.stuId" /></td>
					<td><s:property value="#student.firstName" /></td>
					<td><s:property value="#student.lastName" /></td>
					<td><s:property value="#student.email" /></td>
					<td><s:property value="#student.telephone" /></td>
					<td><s:property value="#student.country" /></td>
					<td><s:property value="#student.status" /></td>
					<td><s:property value="#student.address" /></td>
					<td><s:property value="#student.postcode" /></td>
					<td><s:property value="#student.dateOfBirth" /></td>
					<td><s:property value="#student.gender" /></td>
					<td><s:submit value="Edit" /></td>
					<td><s:submit value="Delete" action="deleteStudent" /></td>
				</tr>
			</s:form>
		</s:iterator>
		<s:hidden id="targetID" name="targetID" />
		<s:hidden name="operationFlag"
			value="%{@com.ims.statics.OperationType@UPDATE}" />

	</table>

</body>
</html>