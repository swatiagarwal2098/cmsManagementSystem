package com.swati.cmsportal.expenseTracker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swati.cmsportal.cms.bean.LoginBean;
import com.swati.cmsportal.expenseTracker.bean.ExpenseTrackerBean;
import com.swati.cmsportal.expenseTracker.dao.ExpenseTrackerDao;

@Service
public class ExpenseTrackerService {
	
	@Autowired
	private ExpenseTrackerDao expenseTrackerDao;
	
	public Map<String, Object> getMonthComboList(){
		Map<String, Object> hm= new HashMap<String, Object>();
		//List<ExpenseTrackerBean> monthComboList= expenseTrackerDao.getMonthComboList();
		hm.put("monthComboList", expenseTrackerDao.getMonthComboList());
		return hm;
	}
	
	public Map<String, Object> getCategoryComboList(){
		Map<String, Object> hm= new HashMap<String, Object>();
		hm.put("categoryComboList", expenseTrackerDao.getCategoryComboList());
		return hm;
	}
	
	public Map<String, Object> getPaymentModeComboList(){
		Map<String, Object> hm= new HashMap<String, Object>();
		hm.put("paymentComboList", expenseTrackerDao.getPaymentModeComboList());
		return hm;
	}
	
	public Map<String, Object> addExpenseData(ExpenseTrackerBean expenseTrackerBean){
		Map<String, Object> hm= new HashMap<String, Object>();
		int result= expenseTrackerDao.addExpenseData(expenseTrackerBean);
		if("1".equals(String.valueOf(result))) {
			hm.put("result", "SUCCESS");
		}else {
			hm.put("result", "ERROR");
		}
		return hm;
	}
	
	public Map<String, Object> getExpenseData(ExpenseTrackerBean expenseTrackerBean){
		Map<String, Object> hm= new HashMap<String, Object>();
		hm.put("expenseDataList", expenseTrackerDao.getExpenseData(expenseTrackerBean));
		return hm;
	}
	
	public Map<String, Object> getExpenseDataRecord(ExpenseTrackerBean expenseTrackerBean){
		Map<String, Object> hm= new HashMap<String, Object>();
		ExpenseTrackerBean expenseItemRecordBean= expenseTrackerDao.getExpenseDataRecord(expenseTrackerBean);
		hm.put("expenseItemRecord", expenseItemRecordBean);
		return hm;
	}
	
	public Map<String, Object> deleteExpenseItemRecord(ExpenseTrackerBean expenseTrackerBean){
		Map<String, Object> hm= new HashMap<String, Object>();
		int result=expenseTrackerDao.deleteExpenseItemRecord(expenseTrackerBean);
		if("1".equals(String.valueOf(result))) {
			hm.put("result", "SUCCESS");
		}else {
			hm.put("result", "ERROR");
		}
		return hm;
	}
	
	public Map<String, Object> getExpenseTrackerDataReportList(){
		Map<String, Object> hm= new HashMap<String, Object>();
		List<ExpenseTrackerBean> expenseTrackerDataReportList= expenseTrackerDao.getExpenseTrackerDataReportList();
		hm.put("data", expenseTrackerDataReportList);
		return hm;
	}
	
}
