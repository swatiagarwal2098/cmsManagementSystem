package com.swati.cmsportal.cms.controller;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(value="/loginPage", method=RequestMethod.GET)
	public String displayLoginPage() {
		return "cms/login";
	}
	
	@RequestMapping(value="/newUserSignUp", method=RequestMethod.GET)
	public String displayNewUserSignUpPage() {
		return "cms/newUserRegistrationPage";
	}
	
	@RequestMapping(value="/existingUserSignIn", method=RequestMethod.GET)
	public String displayExistingUserSignInPage() {
		return "cms/existingUserSignIn";
	}
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String displayHomePage() {
		return "cms/home";
	}
	
	
	
}