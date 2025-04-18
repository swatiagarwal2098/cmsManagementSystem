var mainApp = angular.module("mainApp" , [])

mainApp.controller("expenseTracker", function($scope,$http, $window){
	
	$scope.openExpenseTrackerMaster= function(){
		alert("master....");
		$window.location.href = "master";
	}
	
	$scope.openExpenseTrackerReport= function(){
		$window.location.href = "report";
	}
});