package com.swati.cmsportal.expenseTracker.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swati.cmsportal.expenseTracker.bean.ExpenseTrackerBean;
import com.swati.cmsportal.expenseTracker.service.ExpenseTrackerService;

@RestController
public class ExpenseTrackerRestController {
	
	@Autowired
	private ExpenseTrackerService expenseTrackerService;
	
	@RequestMapping(value="/getMonthComboList", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getMonthComboList(){
		Map<String, Object> hm= new HashMap<String, Object>();
		hm= expenseTrackerService.getMonthComboList();
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getCategoryComboList", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getCategoryComboList(){
		Map<String, Object> hm= new HashMap<String, Object>();
		hm= expenseTrackerService.getCategoryComboList();
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getPaymentModeComboList", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getPaymentModeComboList(){
		Map<String, Object> hm= new HashMap<String, Object>();
		hm= expenseTrackerService.getPaymentModeComboList();
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addExpenseData", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addExpenseData(@RequestBody ExpenseTrackerBean expenseTrackerBean){
		Map<String, Object> hm= new HashMap<String, Object>();
		hm= expenseTrackerService.addExpenseData(expenseTrackerBean);
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getExpenseData", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getExpenseData(){
		Map<String, Object> hm= new HashMap<String, Object>();
		hm= expenseTrackerService.getExpenseData();
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getExpenseDataRecord", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getExpenseDataRecord(@RequestBody ExpenseTrackerBean expenseTrackerBean ){
		Map<String, Object> hm= new HashMap<String, Object>();
		hm= expenseTrackerService.getExpenseDataRecord(expenseTrackerBean);
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteExpenseItemRecord", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> deleteExpenseItemRecord(@RequestBody ExpenseTrackerBean expenseTrackerBean ){
		Map<String, Object> hm= new HashMap<String, Object>();
		hm= expenseTrackerService.deleteExpenseItemRecord(expenseTrackerBean);
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getExpenseReportList", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getExpenseTrackerDataReportList(){
		Map<String, Object> hm= new HashMap<String, Object>();
		hm= expenseTrackerService.getExpenseTrackerDataReportList();
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
	

}
