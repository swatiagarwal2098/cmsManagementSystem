<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.9/angular.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" ></script>
<script type="text/javascript"  src="/cmsportal/spring/staticResources/expenseTracker/controllers/expenseTracker.js"></script>
<style>

body {
        font-family: inherit;
        margin: 0;
    }
    .sidenav {
        height: 100%;              /* Full height */
       
        position: fixed;           /* Fix the sidebar in place */
        top: 0;
        left: 0;
        background-color: rgba(20, 117, 188, .8);
        padding-top: 20px;
    }

    .sidenav a {
        padding: 10px 15px;        /* Padding for links */
        text-decoration: none;     /* Remove underline */
        font-size: 18px;           /* Increase font size */
        color: white;              /* Link color */
        display: block;            /* Make links block elements */
    }

    .sidenav a:hover {
        background-color: #575757; /* Darker color on hover */
    }

    /* Style for the main content */
    .main {
        margin-left: 260px;        /* Add margin to the left to accommodate the sidebar */
        padding: 20px;
    }
    .h2{
    	margin-left: 80px;
    	background-color: rgba(20, 117, 188, .8);
    	height: 40px;
    }

</style>
<title>Expense Tracker Home</title>

</head>
<body>
<div ng-app="mainApp" ng-controller="expenseTracker" >
<form>
<div class="h2" >
	<label style="font-size: 165%;padding-left: 0px;">
	 <span style="color: white;font-weight:bold; ">Welcome To Expense Tracker Home</span> 
	 
	</label>
	</div>
	<div  class="sidenav">
	
	  <a class="active" href="#home">Home</a>
	  <a href="/cmsportal/spring/master" ng-click="openExpenseTrackerMaster();">Master</a>
	  <a href="/cmsportal/spring/report" ng-click="openExpenseTrackerReport();">Report</a>
	  <a href="#others">Others</a>
	</div>
</form>
</div>
</body>
</html>