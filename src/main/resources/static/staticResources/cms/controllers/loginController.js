var mainApp= angular.module("mainApp", [])
	
mainApp.controller("loginController", function($scope,$http, $window){
	
	$scope.openSignUpSignInPage= function(btnFlag){
		let pageUrl='';
		if(btnFlag=='newUser'){
			pageUrl	= "newUserSignUp";
		}else if(btnFlag=='existingUser'){
			pageUrl	= "existingUserSignIn";
		}
		$window.location.href = pageUrl;
	}
	
	$scope.validateUser=function(){
		alert("check..");
		let userName=$("#userName").val();
		let password= $("#password").val();
		
		if(userName== undefined || userName==''){
			alert("Please Enter User Name");
			$("#userName").focus();
			return false;
		}else if(password== undefined || password==''){
			alert("Please Enter Password");
			$("#password").focus();
			return false;
		}
		var url = "checkLoginCredentials";   //it goes to check checkLoginCredentials mapping in rest controller    
		var responsePromise = $http.post(url,{'userName':userName,'password':password});
	    responsePromise.success(function(data, status, headers, config) {
			if(data.result=='SUCCESS'){
				$window.location.href = "welcome";
			}else if(data.result=='INVALID PASSWORD'){
				alert("Incorrect Password");
				$("#password").focus();
				return false;
			}else if(data.result=='INVALID USERNAME'){
				alert("Please Enter User Name");
				$("#userName").focus();
				return false;
			}
	    });
	    responsePromise.error(function(data, status, headers, config) {
	    	alert("Error occurred, while calling web services");	
	    });
	}
	
	$scope.submitRegDetails=function(){
		let firstName=$("#firstName").val();
		let lastName=$("#lastName").val();
		let phoneNumber=$("#phoneNumber").val();
		let userName=$("#userName").val();
		let password= $("#password").val();
		
		if(firstName== undefined || firstName==''){
			alert("Please Enter First Name");
			$("#firstName").focus();
			return false;
		}else if(lastName== undefined || lastName==''){
			alert("Please Enter Last Name");
			$("#lastNameS").focus();
			return false;
		}else if(phoneNumber== undefined || phoneNumber==''){
			alert("Please Enter Phone Number");
			$("#phoneNumber").focus();
			return false;
		}else if(userName== undefined || userName==''){
			alert("Please Enter User Name");
			$("#userName").focus();
			return false;
		}else if(password== undefined || password==''){
			alert("Please Enter Password");
			$("#password").focus();
			return false;
		}
		var url = "createNewUser";       
		var responsePromise = $http.post(url,{'firstName':firstName,'lastName':lastName,'phoneNumber':phoneNumber,'userName':userName,'password':password});
	    responsePromise.success(function(data, status, headers, config) {
			if(data.result=="SUCCESS"){
				$window.location.href = "existingUserSignIn";
			}else if(data.result=="ERROR"){
				$window.location.href = "newUserSignUp";
			}
	    });
	    responsePromise.error(function(data, status, headers, config) {
			alert("Error occurred, while calling web services");
	    });
	}
	
	
});