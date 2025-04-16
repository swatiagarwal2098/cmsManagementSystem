<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.9/angular.min.js" ></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" ></script>

<title>Logout</title>

</head>
<body>
<div ng-app="mainApp" ng-controller="loginController" >
<form>
	
	<div style="color: rgb(0,117,194);text-align: center;font-weight: bold;font-size: 16px;margin-top: 20px;">
		Your Session has been expired!<br>
	</div><br>
	<div style="text-align: center;font-size: 13px;color: rgb(0,117,194);font-weight: bold">
		<a href="/cmsportal/spring/login/loginPage">Click here</a> to logon to Central Workflow Portal <br><br>
	</div>
</form>
</div>
</body>
</html>