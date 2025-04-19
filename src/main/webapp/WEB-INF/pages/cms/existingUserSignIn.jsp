<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Central Management System</title>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.9/angular.min.js" ></script>
 	<script type="text/javascript"  src="/cmsportal/spring/staticResources/cms/controllers/loginController.js"></script>
 	<!-- <script type="text/javascript"  src="/cmsportal/spring/staticResources/cms/translations/translation_en.json"></script> -->
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" ></script>
<style>
.app_body_bg{
		background-image: url('https://static.vecteezy.com/system/resources/previews/000/539/735/original/abstract-blue-and-white-lines-wave-background-vector-illustration.jpg');
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
	 <span style="color: red;font-weight:bold;margin-left: 100px;">Welcome!</span> 
	 <!-- <spring:message code="label.centralMgmtSys"/> -->
	</label>
	
	<div style="margin-left: 100px; margin-top:20px">
    	<span ><i  style="color:#1F6DA6"></i></span>
        <input type="text" id="userName"  placeholder="Enter User Name" required autofocus>
	</div>
	<div style="margin-left: 100px; margin-top:15px ;">
    	<span ><i  style="color:#1F6DA6"></i></span>
        <input type="password" id="password" maxlength="20" placeholder="Enter Password" required autofocus>
	</div>
	 <div style="margin-left: 150px; margin-top:15px ;" >
<!-- 	 	<input id="btnProceed" type="button" ng-click="validateUser();" style="font-weight: bold;background-color:#fff;color:rgb(0, 117, 194);" value="Sign In"></input>
 -->	  <button type="button" ng-click="validateUser();" >Sign In</button>
	 </div>
	 
</form>
</div>
</body>
</html>