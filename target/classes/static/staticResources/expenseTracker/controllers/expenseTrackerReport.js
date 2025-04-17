var mainApp = angular.module("mainApp" , ['ExpenseCommonModule'])

mainApp.service('expenseReportService', function($http) {
	
	var _this = this;
	this.getExpenseTrackerDataReportList = function($scope, inputJson) {
		$scope.showTableDiv= true;
			var table = $('#dataTable').dataTable({
			dom: 'Bfrtp',
			buttons: [
				{
					extend: 'excelHtml5',
					filename: "Lease Type List",
					title: "Lease Type List",
					exportOptions: {
						columns: [0, 1, 6, 3, 7]
					}
				},
			],
			"ajax": {
				"url": "getExpenseReportList",
				"type": "post",
				"contentType": "application/json",
			},
			scrollX: true,
			autoWidth: false,
			paging: false,
			destroy: true,
			cache: false,
			
			"columns": [
				{ "data": "month" },
				{ "data": "expenseMadeBy" },
				{ "data": "date" },
				{ "data": "category" },
				{ "data": "paymentMode" },
				{ "data": "desc"},
				{ "data": "amount" },
			],
			initComplete: function(settings, json) {
			}
		});
	};
	
});


mainApp.controller("expenseTrackerReport", function($scope,$http, $window, expenseCommonService, expenseReportService){
	$scope.showTableDiv = false;
	$scope.onLoad= function(){
		expenseCommonService.getMonthComboList($scope);
		$scope.monthComboList = [{ 'key': '-1', 'value': '--All--'}];
		expenseCommonService.getCategoryComboList($scope);
		expenseCommonService.getPaymentModeComboList($scope);
	}
	
	$scope.viewReport= function(){
		let month= $("#month").val();
		let category= $("#category").val();
		let paymentMode= $("#paymentMode").val();
		let inputJson= {'month' : month, 'category': category, 'paymentMode': paymentMode};
		expenseReportService.getExpenseTrackerDataReportList($scope,inputJson);
		
	}
	
});