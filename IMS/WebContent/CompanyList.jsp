<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjq" uri="/struts-jquery-grid-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<sj:head locale="en" jqueryui="true" jquerytheme="redmond" />
<title>Company List</title>
</head>
<body>

	<h1>Company List</h1>
	<div id="mygridfilter"></div>
	<s:url id="remoteurl" action="listCompany" />
	<s:url id="editurl" action="editCompany" />
	<sjq:grid id="gridtable" caption="Companies..." dataType="json"
		resizable="true" href="%{remoteurl}" pager="true"
		gridModel="gridModel" rowNum="10" navigator="true" navigatorAdd="true"
		navigatorAddOptions="{height:280,reloadAfterSubmit:true}"
		navigatorDelete="true"
		navigatorDeleteOptions="{height:480,reloadAfterSubmit:true}"
		navigatorEdit="true"
		navigatorEditOptions="{height:480,reloadAfterSubmit:false}"
		navigatorRefresh="true" navigatorSearch="true"
		navigatorSearchOptions="{multipleSearch:true}" navigatorView="false"
		multiselect="true" onSelectRowTopics="rowselect" rownumbers="true"
		rowList="10,20,30" editurl="%{editurl}" viewrecords="true" width="960"
		shrinkToFit="false">
		<sjq:gridColumn name="code" hidden="true" search="false" key="true"
			index="code" title="Company Code" sortable="true" editable="true"
			edittype="text" />
		<sjq:gridColumn name="name" align="left" index="companyName"
			title="Company Name" sortable="true" search="true"
			searchoptions="{sopt:['eq','ne']}" editable="true" edittype="text" />
		<sjq:gridColumn name="address" align="left" index="companyAddress"
			title="Company Address" sortable="true" search="true"
			searchoptions="{sopt:['eq','ne']}" />
	</sjq:grid>

	<script type="text/javascript">	
	$(document).ready(function () {

    $("#mygridfilter").filterGrid('#gridtable',{
        autosearch : false,
        gridNames : true,
        formtype : 'vertical',
        autosearch : false,
        enableSearch : true,
        enableClear : true,
        gridModel : true,
        buttonclass : 'ui-state-default ui-corner-all'
    }).triggerSearch();
});

</script>

</body>
</html>