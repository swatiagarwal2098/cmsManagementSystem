var mainApp = angular.module("mainApp" , ['ExpenseCommonModule'])


mainApp.service('expenseService', function($http) {
	
	var _this = this;
	
	this.validateAddExpenseData= function(){
		let month= $("#month").val();
		let expenseMadeBy= $("#expenseMadeBy").val();
		let date= $("#date").val();
		let category= $("#category").val();
		let paymentMode= $("#paymentMode").val();
		let desc= $("#desc").val();
		
		if(month== null || month=='-1'){
			alert("Select month");
			$("#month").focus();
			return false;
		}else if(expenseMadeBy== null || expenseMadeBy =='-1'){
			alert("Select expense made by");
			$("#expenseMadeBy").focus();
			return false;
		}else if(date== null || date ==''){
			alert("Select date");
			$("#date").focus();
			return false;
		}else if(category== null || category =='-1'){
			alert("Select category");
			$("#category").focus();
			return false;
		}else if(paymentMode== null || paymentMode =='-1'){
			alert("Select payment mode");
			$("#paymentMode").focus();
			return false;
		}else if(desc== null || desc ==''){
			alert("Enter description");
			$("#desc").focus();
			return false;
		}else if(amount== null || amount ==''){
			alert("Enter Amount");
			$("#amount").focus();
			return false;
		}
	return true;
	}
});

mainApp.controller("expenseTrackerMaster", function($scope,$http, $window, expenseCommonService, expenseService){
	$scope.itemId='-1';
	let userId= $("#hdnUserId").val();
	$scope.onLoad= function(){
		expenseCommonService.getMonthComboList($scope);
		expenseCommonService.getCategoryComboList($scope);
		expenseCommonService.getPaymentModeComboList($scope);
		$scope.getExpenseData();
	}
	
	$scope.editExpenseItem= function(itemId, flag, rowId){
		$("#tbl tr").css("background", "none");
		$("#tr"+rowId).css("background", "#FFF8BE");
		let url= "getExpenseDataRecord";
		let responsePromise= $http.post(url, {'itemId': itemId});
		responsePromise.success(function(data, status, headers, config) {
			if(data.sessionExpired=="Y"){
				alert("Your Session has been expired!");
				$window.location.href = "/cmsportal/spring/login/logout";
			}else{
				let expenseItemRecord= data.expenseItemRecord;
				$scope.itemId=expenseItemRecord.itemId;
				$scope.month = {'key':expenseItemRecord.month};
				$("#expenseMadeBy").val(expenseItemRecord.expenseMadeBy);
				$('#date').val(expenseItemRecord.date);
				$scope.category = {'key':expenseItemRecord.category};
				$scope.paymentMode = {'key':expenseItemRecord.paymentMode};
				$('#desc').val(expenseItemRecord.desc);
				$('#amount').val(expenseItemRecord.amount);
				if(flag=='Copy'){
					$scope.itemId='-1';	
					$("#addbtn").text("Add Copied Item");
				}
			}
		});
		responsePromise.error(function(data, status, headers, config) {
			alert("Error occurred, while calling web services");	
		});
	}
	
	$scope.addUpdateExpenseData= function(flag){
		let month= $("#month").val();
		let expenseMadeBy= $("#expenseMadeBy").val();
		let date= $("#date").val();
		let category= $("#category").val();
		let paymentMode= $("#paymentMode").val();
		let desc= $("#desc").val();
		let amount= $("#amount").val();
		let inputJson='';
		let actionFlag= flag;
		
		if(!expenseService.validateAddExpenseData()){
			return false;
		}
		let url= "addExpenseData";
		if(flag=='ADD'){
			inputJson= {'month' : month, 'expenseMadeBy' : expenseMadeBy, 'date' : date, 'category': category, 'paymentMode': paymentMode, 'desc': desc, 'amount': amount, 'actionFlag': actionFlag};

		}else if(flag=='UPDATE'){
			inputJson= {'itemId': $scope.itemId, 'month' : month, 'expenseMadeBy' : expenseMadeBy, 'date' : date, 'category': category, 'paymentMode': paymentMode, 'desc': desc, 'amount': amount, 'actionFlag': actionFlag};
		}
		
		let responsePromise= $http.post(url,inputJson);
		responsePromise.success(function(data, status, headers, config) {
			if(data.sessionExpired=="Y"){
				alert("Your Session has been expired!");
				$window.location.href = "/cmsportal/spring/login/logout";
			}
			if(data.result=="SUCCESS"){
				$window.location.reload();
			}
		});
		responsePromise.error(function(data, status, headers, config) {
			alert("Error occurred, while calling web services");	
		});
	}
	
	$scope.getExpenseData= function(){
		let url= "getExpenseData";
		let responsePromise= $http.post(url);
		responsePromise.success(function(data, status, headers, config) {
			if(data.sessionExpired=="Y"){
				alert("Your Session has been expired!");
				$window.location.href = "/cmsportal/spring/login/logout";
			}else{
				$scope.expenseDataListCount= data.expenseDataList.length;
				$scope.expenseDataList= data.expenseDataList;
			}
		});
		responsePromise.error(function(data, status, headers, config) {
			alert("Error occurred, while calling web services");	
		});
	}
	
	$scope.deleteItemRecord= function(itemId, flag, rowId){
		if(confirm("Are you sure you want to delete this record?")){
			let url= "deleteExpenseItemRecord";
			let responsePromise= $http.post(url, {'itemId': itemId});
			responsePromise.success(function(data, status, headers, config) {
				if(data.result=="SUCCESS"){
					$window.location.reload();
				}
			});
			responsePromise.error(function(data, status, headers, config) {
			});
		}
	}
});