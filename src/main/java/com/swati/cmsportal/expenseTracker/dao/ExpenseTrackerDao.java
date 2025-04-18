package com.swati.cmsportal.expenseTracker.dao;

import java.util.List;
import java.util.Map;

import com.swati.cmsportal.cms.bean.LoginBean;
import com.swati.cmsportal.expenseTracker.bean.ExpenseTrackerBean;

public interface ExpenseTrackerDao {

	List<ExpenseTrackerBean> getMonthComboList();

	List<ExpenseTrackerBean> getCategoryComboList();

	List<ExpenseTrackerBean> getPaymentModeComboList();

	int addExpenseData(ExpenseTrackerBean expenseTrackerBean);

	List<ExpenseTrackerBean> getExpenseData(ExpenseTrackerBean expenseTrackerBean);

	ExpenseTrackerBean getExpenseDataRecord(ExpenseTrackerBean expenseTrackerBean);

	int deleteExpenseItemRecord(ExpenseTrackerBean expenseTrackerBean);

	List<ExpenseTrackerBean> getExpenseTrackerDataReportList(ExpenseTrackerBean expenseTrackerBean);

	



	
	

}
