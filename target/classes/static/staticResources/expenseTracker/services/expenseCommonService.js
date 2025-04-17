angular.module('ExpenseCommonModule', []).service('expenseCommonService', function($http) {
	
	
	this.getMonthComboList= function($scope){
		$scope.monthComboList = [{ 'key': '-1', 'value': '--Select--'}];
		$scope.month={'key':'-1'};
		let url = "getMonthComboList";      
		var responsePromise = $http.post(url);
	    responsePromise.success(function(data, status, headers, config) {
			angular.forEach(data.monthComboList, function(value, key) {
				$scope.monthComboList.push(value);
			});
	    });
	    responsePromise.error(function(data, status, headers, config) {
	    	alert("Error occurred, while calling web services");	
	    });
	}
	
	this.getCategoryComboList= function($scope){
		$scope.categoryComboList=[{'key': '-1', 'value': '--Select--'}]	
		$scope.category={'key': '-1'};
		let url= "getCategoryComboList";
		var responsePromise= $http.post(url);
		responsePromise.success(function(data, status, headers, config){
			angular.forEach(data.categoryComboList, function(value, key) {
				$scope.categoryComboList.push(value);
			});
			
		});
		 responsePromise.error(function(data, status, headers, config) {
	    	alert("Error occurred, while calling web services");	
	    });
	}
	
	this.getPaymentModeComboList= function($scope){
		$scope.paymentComboList=[{'key': '-1', 'value': '--Select--'}]	
		$scope.paymentMode={'key': '-1'};
		let url= "getPaymentModeComboList";
		var responsePromise= $http.post(url);
		responsePromise.success(function(data, status, headers, config){
			angular.forEach(data.paymentComboList, function(value, key) {
				$scope.paymentComboList.push(value);
			});
			
		});
		 responsePromise.error(function(data, status, headers, config) {
	    	alert("Error occurred, while calling web services");	
	    });
	}
	
});