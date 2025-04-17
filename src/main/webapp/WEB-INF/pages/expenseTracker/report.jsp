<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.9/angular.min.js" ></script>

 	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" ></script>
 	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.21/js/jquery.dataTables.min.js" ></script> -->
 	<script src="/cmsportal/spring/staticResources/common/dataTable/media/js/jquery.dataTables.min.js"></script>
 	<script src="/cmsportal/spring/staticResources/common/dataTable/media/css/jquery.dataTables.min.1.10.19.css"></script>
 	<script type="text/javascript" src="/cmsportal/spring/staticResources/expenseTracker/controllers/expenseTrackerReport.js"></script>
 	<script type="text/javascript" src="/cmsportal/spring/staticResources/expenseTracker/services/expenseCommonService.js"></script>
 	<script type="text/javascript" src="/cmsportal/spring/staticResources/common/scripts/svgImageButton.js"></script>
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
    .pageHeader{
    	margin-left: 80px;
    	font-size: 110%;
    	padding: 0.6em;
    	color: rgb(0, 117, 194);
    	font-weight: bold;
    }
    .tophr{
        margin-top: 5px;
   		margin-bottom: 15px;
   		width: 99%;
   		color: rgb(109, 110, 113);
	}
	.panelHeading{
    	margin-left: 90px;
    	font-size: 12px
    	padding: 0.6em;
    	color: rgb(0, 117, 194);
    	font-weight: 700;
    }
    .combo-input{
	    width: 140px;
	    border-color: lightgrey;
	    padding: 5px 10px;
	    font-size: 12px;
	    line-height: 1.5;
	    border-radius: 3px;
	    color: #00497F !important;
	}
	.display{
		display:inline;
	}
	.marginTop{
		margin-top: 10px;
		display: inline-block
	}
	.table {
	    width: 100%;
	    max-width: 100%;
	    margin-bottom: 20px;
	}
	.table-bordered {
	    border: 1px solid #ddd;
	}
	.table>thead>tr>th {
	    /* border-top: 1px solid #e0dfdf; */
	    margin-top: 10px;
	    font-size: 100%;
	    padding: .25em .9em;
	    vertical-align: middle;
	    color: #1F6DA6;
	    background-color: rgb(194, 221, 240);
	}
	table, th, td {
	  border: 1px solid #dcdcdc ;
	  font-size: 90%;
	  border-collapse: collapse;
	  color: #1F6DA6;
      text-align: left;
	}
   .badge {
	    display: inline-block;
	    min-width: 10px;
	    padding: 3px 7px;
	    font-size: 12px;
	    font-weight: 700;
	    line-height: 1;
	    color: #fff;
	    text-align: center;
	    white-space: nowrap;
	    vertical-align: middle;
	    background-color: #777;
	    border-radius: 10px;
	}
	.badge-custom {
	    margin-bottom: 5px;
	    color: #1F6DA6;
	    background-color: rgb(194, 221, 240);
	    font-size: 11px;
	}
    .labelWidth {
        display: inline-block;
        width: 100px;
        font-size: 13px;
    	font-family: Segoe UI;
      }
      .textBox-input{
	    width: 120px;
	    padding: 5px 10px;
	    border-color: lightgrey;
	    font-size: 12px;
	    line-height: 1.5;
	    border-radius: 3px;
	    color: #00497F !important;
	}
	.date-input{
		width: 120px;
	    padding: 5px 10px;
	    border-color: lightgrey;
	    font-size: 12px;
	    line-height: 1.5;
	    border-radius: 3px;
	    color: #00497F !important;
	}
	.btn {
	    background-color: rgb(26, 137, 205);
	    border: none;
	    font-color: white;
	    color: #fff;
	    padding: 5px 10px;
	    font-size: 12px;
	    line-height: 1.5;
	    border-radius: 3px;
	}

</style>
<title>Expense Tracker Home</title>

</head>
<body>
<div ng-app="mainApp" ng-controller="expenseTrackerReport" ng-init="onLoad()">
<form>
	<div class="h2" >
		<label style="font-size: 165%;padding-left: 0px;">
		 <span style="color: white;font-weight:bold; ">Expense Tracker : Report</span> 
		</label>
	</div>
	
	<div  class="sidenav">
		  <a class="active" href="#home">Home</a>
		  <a href="/cmsportal/spring/master" ng-click="openExpenseTrackerMaster();">Master</a>
		  <a href="#report">Report</a>
		  <a href="#others">Others</a>
	</div>
	
	<div class="pageHeader" >
		Expense Tracker&nbsp;&nbsp;<span class="glyphicon glyphicon-arrow-right" style="font-size: 15px;color: #0075f5;"></span>&nbsp;&nbsp;<span>Report</span>
	</div>
		<hr class="tophr">
		
	<div class= "panelHeading display">
		<label for="SelectMonth" class="labelWidth" > Month</label> 
		<select class="combo-input" name="month"  id="month" ng-model="month" ng-options="month.value for month in monthComboList track by month.key"
			style="font-weight: 500; width: 10%;" >
		</select>
	</div>
	
	<!-- <div class= "panelHeading display">
		<label for="ExpenseMadeBy" class="labelWidth">Spend By</label> 
		<select class="combo-input" name="expenseMadeBy" id="expenseMadeBy" >
		<option value="-1">--Select--</option>
		<option value="Swati">Swati</option>
		<option value="Subham">Subham</option>
		<option value="Manoj">Manoj</option> 
		</select>
	</div> -->
	
	<!-- <div class= "panelHeading display"> 
		<label for="selectDate" class="labelWidth">Select Date</label>
		<input class="date-input" type="date" name="date" id="date" placeholder="dd-mm-yyyy">
	</div>  -->
		
	<div class= "panelHeading display">
		<label for="selectCategory" class="labelWidth"> Category</label> 
		<select class="combo-input" name="category"  id="category" ng-model="category" ng-options="category.value for category in categoryComboList track by category.key"
			style="font-weight: 500; width: 10%;" >
		</select>
	</div>
	
	
	<div  class= "panelHeading marginTop">
		<label for="selectPaymentMode" class="labelWidth"> Payment Mode</label> 
		<select class="combo-input" name="paymentMode"  id="paymentMode" ng-model="paymentMode" ng-options="paymentMode.value for paymentMode in paymentComboList track by paymentMode.key"
			style="font-weight: 500; ">
		</select>
	</div>
		
	<!-- <div class= "panelHeading marginTop">
		<label for="desc" class="labelWidth"> Description</label> 
		<input class="textBox-input" type='text'   name="desc" id="desc" ng-model="desc" placeholder="Enter Description" />
	</div>
	
	<div class= "panelHeading marginTop">
		<label for="amount" class="labelWidth"> Amount</label> 
		<input  class="textBox-input" type='number'  name="amount" id="amount" ng-model="amount" placeholder="Enter Amount" />
	</div> -->
	
	<div class= "panelHeading marginTop">
		<button class="btn" type="button"  ng-click="viewReport();" >View Report</button>
<!-- 		<button class="btn" ng-show="itemId!='-1'" type="button" id="updatebtn" ng-click="addUpdateExpenseData('UPDATE');" >Update</button>
 -->	</div>
 
 
 
 	 <div id="tableDiv" ng-show="showTableDiv" class="table-scr"  style="color: #000; max-height: 42%; width: 96%; overflow: auto; margin-top: 20px; margin-left: 90px;" ng-cloak>
		<table width="100%" id="dataTable" class="table table-bordered table-responsive" border="0"cellpadding="0" cellspacing="0" bordercolor="#3B6E93"style="border-collapse: collapse;">
			<thead>
				<tr>
				 	<th >Month</th>
					<th >Expense Made By</th>
					<th >Date</th>
					<th >Category</th>
					<th >Payment Mode</th>
					<th >Desc</th>
					<th >Amount</th>
				</tr>
			</thead>
		</table>
	</div> 
	
	<!-- <div id="tableDiv" class="table-scr" style="width:100%">
			<table width="100%" id="dataTable" class="display" border="0" cellpadding="0" cellspacing="0" bordercolor="#3B6E93" style="border-collapse: collapse;">
				<thead>
					<tr>
				 	<th >Month</th>
					<th >Expense Made By</th>
					<th >Date</th>
					<th >Category</th>
					<th >Payment Mode</th>
					<th >Desc</th>
					<th >Amount</th>
				</tr>
				</thead>
				
			</table>													
		</div> -->
	
	
</form>



<script type="text/javascript">
$(document).ready(function () {		
	

});	

</script>
</div>
</body>
</html>