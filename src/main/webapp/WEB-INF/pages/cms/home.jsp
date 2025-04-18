<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Central Management System</title>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.9/angular.min.js" ></script>
 	<script type="text/javascript"  src="/cmsportal/spring/staticResources/cms/controllers/mainController.js"></script>
 	<!-- <script type="text/javascript"  src="/cmsportal/spring/staticResources/cms/translations/translation_en.json"></script> -->
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" ></script>
</head>
<body>
<div ng-app="mainApp" ng-controller="mainController" >
<form>
	<label class="h2" style="font-size: 165%;padding-left: 0px;">
	 <span style="color: red;font-weight:bold;">Welcome To Central Management System</span> 
	 <!-- <spring:message code="label.centralMgmtSys"/> -->
	</label>
	<a href="/cmsportal/spring/expenseTrackerHome">
        <img src="staticResources/expenseTracker/images/expenseApp.jpg">
    </a>
</form>
</div>
</body>
</html>