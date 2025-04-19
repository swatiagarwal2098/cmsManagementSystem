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
<style>
.app_body_bg{
		background-image: url('https://assets-global.website-files.com/63ef58e5b6e17312dfe3c271/64423e9018e464681cec7ca6_02.jpeg');
	    height: 100% !important;
	    background-size: cover !important;
	    /* width: 100% !important; */
	    background-position: center center !important;
    }
</style>

</head>
<body class="app_body_bg">
<div ng-app="mainApp" ng-controller="loginController" >
<form>




	<label class="h2" style="font-size: 165%;padding-left: 0px;">
	 <span style="color: red;font-weight:bold;margin-left: 100px;">Central Management System</span> 
	 <!-- <spring:message code="label.centralMgmtSys"/> -->
	</label>
	 <div style="margin-top:15px">
	 	<button style="margin-left: 100px;height: 30px;" type="button" ng-click="openSignUpSignInPage('newUser');">New User</button>
		<button style="height: 30px;" type="button" ng-click="openSignUpSignInPage('existingUser');" >Existing User</button>
	 </div>
</form>
</div>
</body>
</html>