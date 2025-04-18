package com.swati.cmsportal.expenseTracker.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.swati.cmsportal.cms.bean.LoginBean;
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
	public ResponseEntity<Map<String, Object>> addExpenseData(@RequestBody ExpenseTrackerBean expenseTrackerBean,HttpServletRequest request, HttpSession session){
		Map<String, Object> hm= new HashMap<String, Object>();
		System.out.println("rest..........");
		LoginBean loginBean= new LoginBean();
		if(session.getAttribute("sessExpenseUserInfo")!=null) {
			loginBean = (LoginBean)session.getAttribute("sessExpenseUserInfo");
			expenseTrackerBean.setUserId(loginBean.getUserId());
			hm= expenseTrackerService.addExpenseData(expenseTrackerBean);
		}else {
			hm.put("sessionExpired",  "Y");
		}
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getExpenseData", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getExpenseData(HttpServletRequest request, HttpSession session){
		Map<String, Object> hm= new HashMap<String, Object>();
		LoginBean loginBean= new LoginBean();
		ExpenseTrackerBean expenseBean= new ExpenseTrackerBean();
		if(session.getAttribute("sessExpenseUserInfo")!=null) {
			loginBean = (LoginBean)session.getAttribute("sessExpenseUserInfo");
			expenseBean.setUserId(loginBean.getUserId());
			hm= expenseTrackerService.getExpenseData(expenseBean);
		}else {
			hm.put("sessionExpired", "Y");
		}
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getExpenseDataRecord", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getExpenseDataRecord(@RequestBody ExpenseTrackerBean expenseTrackerBean,HttpServletRequest request, HttpSession session ){
		Map<String, Object> hm= new HashMap<String, Object>();
		LoginBean loginBean= new LoginBean();
		if(session.getAttribute("sessExpenseUserInfo")!=null) {
			loginBean = (LoginBean)session.getAttribute("sessExpenseUserInfo");
			expenseTrackerBean.setUserId(loginBean.getUserId());
			hm= expenseTrackerService.getExpenseDataRecord(expenseTrackerBean);
		}else {
			hm.put("sessionExpired", "Y");
		}
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteExpenseItemRecord", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> deleteExpenseItemRecord(@RequestBody ExpenseTrackerBean expenseTrackerBean ){
		Map<String, Object> hm= new HashMap<String, Object>();
		hm= expenseTrackerService.deleteExpenseItemRecord(expenseTrackerBean);
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getExpenseReportList", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getExpenseTrackerDataReportList(@RequestBody ExpenseTrackerBean expenseTrackerBean,HttpServletRequest request, HttpSession session){
		Map<String, Object> hm= new HashMap<String, Object>();
		LoginBean loginBean= new LoginBean();
		if(session.getAttribute("sessExpenseUserInfo")!=null) {
			loginBean = (LoginBean)session.getAttribute("sessExpenseUserInfo");
			expenseTrackerBean.setUserId(loginBean.getUserId());
			hm= expenseTrackerService.getExpenseTrackerDataReportList(expenseTrackerBean);
		}else {
			hm.put("sessionExpired", "Y");
		}
		
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getExpenseTrackerExcelReportList", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getExpenseTrackerExcelReportList(@RequestBody ExpenseTrackerBean expenseTrackerBean,HttpServletRequest request, HttpSession session, HttpServletResponse response){
		Map<String, Object> hm= new HashMap<String, Object>();
		LoginBean loginBean= new LoginBean();
			loginBean = (LoginBean)session.getAttribute("sessExpenseUserInfo");
			expenseTrackerBean.setUserId(loginBean.getUserId());
			hm= expenseTrackerService.getExpenseTrackerExcelReportList(expenseTrackerBean);
		
		return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
	}
}
