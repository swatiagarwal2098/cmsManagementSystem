var mainApp = angular.module("mainApp" , [])

mainApp.controller("mainController", function($scope,$http, $window){
	
	$scope.goToExpenseTracker= function(){
		//$window.location.href = "http://localhost:6060/cmsportal/spring";
		//window.location.replace("/login");
		//let url="/cmsportal/spring/"
		//window.location.replace("/login");
		//let url="/cmsportal/spring/"
		$window.location.href ="/cmsportal/spring/expenseTrackerHome";
	}
});