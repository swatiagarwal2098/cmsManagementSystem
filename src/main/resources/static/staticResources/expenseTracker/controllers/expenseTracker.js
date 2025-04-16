var mainApp = angular.module("mainApp" , [])

mainApp.controller("expenseTracker", function($scope,$http, $window){
	
	$scope.openExpenseTrackerMaster= function(){
		$window.location.href = "master";
	}
	
	$scope.openExpenseTrackerReport= function(){
		alert("check")
		$window.location.href = "report";
	}
});