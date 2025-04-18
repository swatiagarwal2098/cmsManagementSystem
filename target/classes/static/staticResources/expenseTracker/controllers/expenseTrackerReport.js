var mainApp = angular.module("mainApp" , ['ExpenseCommonModule'])

mainApp.service('expenseReportService', function($http) {
	
	var _this = this;
	
	
	
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
		
		if(category== null || category =='-1'){
			alert("Select category");
			$("#category").focus();
			return false;
		}else if(paymentMode== null || paymentMode =='-1'){
			alert("Select payment mode");
			$("#paymentMode").focus();
			return false;
		}
		let inputJson= {'month' : month, 'category': category, 'paymentMode': paymentMode};
		$scope.getExpenseTrackerDataReportList($scope,inputJson);
		
	}
	
	$scope.getExpenseTrackerDataReportList = function($scope, inputJson) {
		$scope.showTableDiv = true;
		var table = $('#dataTable').dataTable({
			dom: 'lBrt',
		
			buttons: [
				{
					text: '<a href="#">' + '<img src="staticResources/expenseTracker/images/excel2.png" title="exportToExcel"  width="30" height="30" title="Copy" style="vertical-align: top;" border="0">' + '</a>',
					action: function(e, dt, node, config) {
						$scope.downloadExcelReport()
					}
				}
			],

			"ajax": {
				"url": "getExpenseReportList",
				"type": "post",
				"contentType": "application/json",
				"data": function(d) {
					return JSON.stringify({ 'month':inputJson.month,'category': inputJson.category, 'paymentMode': inputJson.paymentMode,'start': d.start, 'length': d.length
					});
				},
			},
			"autoWidth": false,
			"destroy": true,
			"processing": true,
			"serverSide": true,
			"responsive": false,
			"pageLength": 100,
			"lengthMenu": [100, 200, 300],
			"ordering": false,
			"cache": false,
			"searching": false,
			/*"scrollX": true,*/
			"searchable": false,
		    "orderable": false,
			"columnDefs": [
				{ type: "de_date", "targets": [2] },
			],
			"columns": [
				{ "data": "month" },
				{ "data": "expenseMadeBy" },
				{ "data": "date" },
				{ "data": "category" },
				{ "data": "paymentMode" },
				{ "data": "desc" },
				{ "data": "amount" }
				
			],
			initComplete: function(settings, json) {
				if(json.sessionExpired=="Y"){
					alert("Your Session has been expired!");
					$window.location.href = "/cmsportal/spring/login/logout";
				}
				$("#totalCount").html(json.recordsTotal);
			//	resizeDataTableWithPagination('dataTable', 'tableDiv1', 160);
				//$(".accordion-toggle").click();
				//$('#progressModal_2').modal('hide');
			}
		});
		   
	};
	
	$scope.downloadExcelReport = function() {
		let month= $("#month").val();
		let category= $("#category").val();
		let paymentMode= $("#paymentMode").val();
		let reportCaption = 'EXPENSE TRACKER ANALYSIS REPORT';
		let reportName = 'EXPENSE TRACKER ANALYSIS REPORT';
		var url = "getExpenseTrackerExcelReportList";
		let inputJson= {'month' : month, 'category': category, 'paymentMode': paymentMode, 'reportCaption':reportCaption, 'reportName': reportName };
		var responsePromise = $http.post(url, inputJson);
		responsePromise.success(function(data, status, headers, config) {
			if (data.success == 'success') {
				$window.location.href = data.fileName;
			} 
		});
		responsePromise.error(function(data, status, headers, config) {
			alert("Error occurred, while calling web services");	
		});
	};
	
});