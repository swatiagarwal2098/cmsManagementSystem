package com.swati.cmsportal.expenseTracker.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swati.cmsportal.expenseTracker.bean.ExpenseTrackerBean;
import com.swati.cmsportal.expenseTracker.dao.ExpenseTrackerDao;




@Service
public class ExpenseTrackerService {
	
	@Autowired
	private ExpenseTrackerDao expenseTrackerDao;
	
	
	@Autowired
	private ExcelWriting excelWriting;
	
	@Autowired
	private ExpenseMainService expenseMainService;
	
	
	private Map<String, Object> writeExcelReport(ExpenseTrackerBean expenseTrackerBean, List<ExpenseTrackerBean> reportDataList,String strAction) {
		
		Map<String, Object> resultMap = new LinkedHashMap<>();
		try {
			
			Workbook workbook = null;
			workbook = excelWriting.exportToExcel(expenseTrackerBean, reportDataList, strAction);
			resultMap = expenseMainService.downloadExcelFile(workbook, expenseTrackerBean);
			
		}catch (Exception e) {
			System.out.println("Error.................");
		}
		return resultMap;
	}
	
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
	
	public Map<String, Object> getExpenseTrackerDataReportList(ExpenseTrackerBean expenseTrackerBean){
		Map<String, Object> hm= new HashMap<String, Object>();
		List<ExpenseTrackerBean> expenseTrackerDataReportList= expenseTrackerDao.getExpenseTrackerDataReportList(expenseTrackerBean);
		int recordsTotal=expenseTrackerDataReportList.size();
		hm.put("data", expenseTrackerDataReportList);
		hm.put("recordsTotal", recordsTotal);
		return hm;
	}
	
	public Map<String, Object> getExpenseTrackerExcelReportList(ExpenseTrackerBean expenseTrackerBean)  {
		
		List<ExpenseTrackerBean> expenseTrackerDataReportList= expenseTrackerDao.getExpenseTrackerDataReportList(expenseTrackerBean);

		return writeExcelReport(expenseTrackerBean, expenseTrackerDataReportList, "EXPENSE_TRACKER_DATA_EXCEL");
		
	}

}
