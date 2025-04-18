<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.9/angular.min.js" ></script>
<script type="text/javascript"  src="/cmsportal/spring/staticResources/cms/controllers/loginController.js"></script>
<!-- <script type="text/javascript"  src="/cmsportal/spring/staticResources/cms/translations/translation_en.json"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" ></script>

<title>Central Management System</title>

</head>
<body>
<div ng-app="mainApp" ng-controller="loginController" >
<form>
	<label class="h2" style="font-size: 165%;padding-left: 0px;">
	 <span style="color: red;font-weight:bold;">Central Management System</span> 
	 <!-- <spring:message code="label.centralMgmtSys"/> -->
	</label>
	 <div>
	 	<button type="button" ng-click="openSignUpSignInPage('newUser');">New User</button>
		<button type="button" ng-click="openSignUpSignInPage('existingUser');" >Existing User</button>
	 </div>
</form>
</div>
</body>
</html>