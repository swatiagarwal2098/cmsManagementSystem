package com.swati.cmsportal.cms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.swati.cmsportal.cms.bean.LoginBean;
import com.swati.cmsportal.cms.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginRestController {
	
	@Autowired
	private LoginService loginService;
	
	//method to validate user credentials
	@RequestMapping(value="/checkLoginCredentials", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> checkLoginCredentials(@RequestBody LoginBean loginBean){
		Map<String, Object> hm= new HashMap<String, Object>();
		hm= loginService.checkLoginCredentials(loginBean);
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
	
	//method to create new user when user doesn't exist
	@RequestMapping(value="/createNewUser", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> createNewUser(@RequestBody LoginBean loginBean){
		Map<String, Object> hm= new HashMap<String, Object>();
		hm= loginService.createNewUser(loginBean);
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
	

}
