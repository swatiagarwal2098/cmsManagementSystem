<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.9/angular.min.js" ></script>
 	<script type="text/javascript"  src="/cmsportal/spring/staticResources/cms/controllers/loginController.js"></script>
 	<!-- <script type="text/javascript"  src="/cmsportal/spring/staticResources/cms/translations/translation_en.json"></script> -->
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" ></script>
</head>
<body>
<div ng-app="mainApp" ng-controller="loginController" >
<form>
	<label class="h2" style="font-size: 165%;padding-left: 0px;">
	 <span style="color: red;font-weight:bold;">User Registration</span> 
	 <!-- <spring:message code="label.centralMgmtSys"/> -->
	</label>
	
	<div>
    	<span ><i style="color:#1F6DA6"></i></span>
        <input type="text" id="firstName"  placeholder="Enter First Name" required autofocus>
	</div>
	
	<div>
    	<span ><i  style="color:#1F6DA6"></i></span>
        <input type="text" id="lastName"  placeholder="Enter Last Name" required autofocus>
	</div>
	
	<div>
    	<span ><i  style="color:#1F6DA6"></i></span>
        <input type="text" id="phoneNumber"  placeholder="Enter Phone Number" required autofocus>
	</div>
	
	<div>
    	<span ><i  style="color:#1F6DA6"></i></span>
        <input type="text" id="userName"  placeholder="Enter User Name" required autofocus>
	</div>
	
	<div>
    	<span ><i  style="color:#1F6DA6"></i></span>
        <input type="password" id="password" maxlength="20" placeholder="Enter Password" required autofocus>
	</div>
	 <div style="text-align:center">
<!-- 	 	<input id="btnProceed" type="button" ng-click="validateUser();" style="font-weight: bold;background-color:#fff;color:rgb(0, 117, 194);" value="Submit"></input>
 -->	 <button type="button" ng-click="submitRegDetails();" >Submit</button>
	 
	 </div>
	 
</form>
</div>
</body>
</html>