package com.swati.cmsportal.expenseTracker.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class ExpenseTrackerMainController {
	
	@RequestMapping(value="/expenseTrackerHome", method= RequestMethod.GET)
	public String displayExpenseTrackerHome() {
		return "expenseTracker/expenseTrackerHome";
	}
	
	
	@RequestMapping(value="/master", method=RequestMethod.GET)
	public String displayExpenseTrackerMaster() {
		return "expenseTracker/master";
	}
	
	@RequestMapping(value="/report", method=RequestMethod.GET)
	public String displayExpenseTrackerReport() {
		return "expenseTracker/report";
	}

}
