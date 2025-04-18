package com.swati.cmsportal.expenseTracker.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.swati.cmsportal.cms.bean.LoginBean;
import com.swati.cmsportal.expenseTracker.bean.ExpenseTrackerBean;

@Repository
public class ExpenseTrackerDaoImpl implements ExpenseTrackerDao {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public List<ExpenseTrackerBean> getMonthComboList(){
		String sqlQuery="";
		sqlQuery="SELECT * FROM cms_month";
		RowMapper<ExpenseTrackerBean> mapper= (rs, rowNum)->{
			ExpenseTrackerBean expenseTrackerBean= new ExpenseTrackerBean();
			expenseTrackerBean.setKey(rs.getString("month"));
			expenseTrackerBean.setValue(rs.getString("month"));
			return expenseTrackerBean;
			
		};
		
		List<ExpenseTrackerBean> monthComboList = jdbcTemplateObject.query(sqlQuery, mapper);
		return monthComboList;
	}
	
	@Override
	public List<ExpenseTrackerBean> getCategoryComboList(){
		String sqlQuery= "Select * from cms_expense_category";
		RowMapper<ExpenseTrackerBean> mapper=(rs, rowNum)->{
			ExpenseTrackerBean expenseTrackerBean= new ExpenseTrackerBean();
			expenseTrackerBean.setKey(rs.getString("category"));
			expenseTrackerBean.setValue(rs.getString("category"));
			return expenseTrackerBean;
			
		};
		List<ExpenseTrackerBean> categoryComboList= jdbcTemplateObject.query(sqlQuery, mapper);
		return categoryComboList;
	}
	
	@Override
	public List<ExpenseTrackerBean> getPaymentModeComboList(){
		String sqlQuery= "Select * from cms_payment_mode";
		RowMapper<ExpenseTrackerBean> mapper=(rs, rowNum)->{
			ExpenseTrackerBean expenseTrackerBean= new ExpenseTrackerBean();
			expenseTrackerBean.setKey(rs.getString("payment_mode"));
			expenseTrackerBean.setValue(rs.getString("payment_mode"));
			return expenseTrackerBean;
			
		};
		List<ExpenseTrackerBean> paymentComboList= jdbcTemplateObject.query(sqlQuery, mapper);
		return paymentComboList;
	}
	
	@Override
	public int addExpenseData(ExpenseTrackerBean expenseTrackerBean){
		int result=0;
		if("ADD".equals(expenseTrackerBean.getActionFlag())) {
			result= jdbcTemplateObject.update("INSERT INTO cms_user_expense_data (month, expenseMadeBy, date, category, paymentMode, description, amount) VALUES ('" + expenseTrackerBean.getMonth() + "', '" + expenseTrackerBean.getExpenseMadeBy() + "','" + expenseTrackerBean.getDate() + "', '" + expenseTrackerBean.getCategory() + "', '" + expenseTrackerBean.getPaymentMode() + "', '" + expenseTrackerBean.getDesc() + "',  '" + expenseTrackerBean.getAmount() + "' )");
		}else if("UPDATE".equals(expenseTrackerBean.getActionFlag())) {
			String updateQuery="UPDATE cms_user_expense_data SET month = '" + expenseTrackerBean.getMonth() + "', expenseMadeBy= '" + expenseTrackerBean.getExpenseMadeBy() + "', date = '" + expenseTrackerBean.getDate() + "', category = '" + expenseTrackerBean.getCategory() + "', paymentMode = '" + expenseTrackerBean.getPaymentMode() + "',description = '" + expenseTrackerBean.getDesc() + "',amount = '" + expenseTrackerBean.getAmount() + "'"+ "WHERE id="+expenseTrackerBean.getItemId();
			result= jdbcTemplateObject.update(updateQuery);
		}
		return result;
	}
	
	@Override
	public List<ExpenseTrackerBean> getExpenseData(ExpenseTrackerBean expenseTrackerBean){
		Calendar cal = Calendar.getInstance();
		String currentMonth= new SimpleDateFormat("MMMMMMMM").format(cal.getTime());
		String sqlQuery= "Select * from cms_user_expense_data where status=10 AND userid=" +"'"+expenseTrackerBean.getUserId()+"'" +" and month="+"'"+currentMonth+"'"+" order by 1 desc";
		System.out.println("sqlQuery..."+sqlQuery);
		RowMapper<ExpenseTrackerBean> mapper=(rs, rowNum)->{
			ExpenseTrackerBean expenseBeanObj= new ExpenseTrackerBean();
			expenseBeanObj.setMonth(rs.getString("month"));
			expenseBeanObj.setExpenseMadeBy(rs.getString("expenseMadeBy"));
			expenseBeanObj.setDate(rs.getString("date"));
			expenseBeanObj.setCategory(rs.getString("category"));
			expenseBeanObj.setPaymentMode(rs.getString("paymentMode"));
			expenseBeanObj.setDesc(rs.getString("description"));
			expenseBeanObj.setAmount(rs.getString("amount"));
			expenseBeanObj.setItemId(rs.getString("id"));
			return expenseBeanObj;
		};
		List<ExpenseTrackerBean> expenseDataList= jdbcTemplateObject.query(sqlQuery, mapper);
		return expenseDataList;
	}
	
	@Override
	public ExpenseTrackerBean getExpenseDataRecord(ExpenseTrackerBean expenseTrackerBean){
		ExpenseTrackerBean expenseBean= new ExpenseTrackerBean();
		String sqlQuery= "Select * from cms_user_expense_data where id="+"'"+expenseTrackerBean.getItemId()+"'"+ " AND STATUS='10' AND userId="+"'"+expenseTrackerBean.getUserId()+"'";
		System.out.println("sqlQuery........."+sqlQuery);
		RowMapper<ExpenseTrackerBean> mapper=(rs, rowNum)->{
			ExpenseTrackerBean expenseBeanObj= new ExpenseTrackerBean();
			expenseBeanObj.setMonth(rs.getString("month"));
			expenseBeanObj.setExpenseMadeBy(rs.getString("expenseMadeBy"));
			expenseBeanObj.setDate(rs.getString("date"));
			expenseBeanObj.setCategory(rs.getString("category"));
			expenseBeanObj.setPaymentMode(rs.getString("paymentMode"));
			expenseBeanObj.setDesc(rs.getString("description"));
			expenseBeanObj.setAmount(rs.getString("amount"));
			expenseBeanObj.setItemId(rs.getString("id"));
			return expenseBeanObj;
			
		};
		expenseBean= jdbcTemplateObject.queryForObject(sqlQuery, mapper);
		return expenseBean;
	}
	
	@Override
	public int deleteExpenseItemRecord(ExpenseTrackerBean expenseTrackerBean){
		String updateQuery="UPDATE cms_user_expense_data SET status='30'"+ " WHERE id="+expenseTrackerBean.getItemId();
		int result= jdbcTemplateObject.update(updateQuery);
		return result;
	}
	
	@Override
	public List<ExpenseTrackerBean> getExpenseTrackerDataReportList( ExpenseTrackerBean expenseTrackerBean){
		System.out.println("expenseTrackerBean...."+expenseTrackerBean.getMonth());
		String strAppendQuery="";
		strAppendQuery= " userId="+"'"+expenseTrackerBean.getUserId()+"'"+" and month= "+"'"+expenseTrackerBean.getMonth()+"'"+" and category="+"'"+expenseTrackerBean.getCategory()+"'"+" and paymentMode="+"'"+expenseTrackerBean.getPaymentMode()+"'";
		if("-1".equals(expenseTrackerBean.getMonth())) {
			strAppendQuery= " userId="+"'"+expenseTrackerBean.getUserId()+"'"+" and category="+"'"+expenseTrackerBean.getCategory()+"'"+" and paymentMode="+"'"+expenseTrackerBean.getPaymentMode()+"'";
		}
		
		String sqlQuery= "Select * from cms_user_expense_data where "+strAppendQuery;
		System.out.println("sqlQuery..."+sqlQuery);
		RowMapper<ExpenseTrackerBean> mapper=(rs, rowNum)->{
			ExpenseTrackerBean expenseBeanObj= new ExpenseTrackerBean();
			expenseBeanObj.setMonth(rs.getString("month"));
			expenseBeanObj.setExpenseMadeBy(rs.getString("expenseMadeBy"));
			expenseBeanObj.setDate(rs.getString("date"));
			expenseBeanObj.setCategory(rs.getString("category"));
			expenseBeanObj.setPaymentMode(rs.getString("paymentMode"));
			expenseBeanObj.setDesc(rs.getString("description"));
			expenseBeanObj.setAmount(rs.getString("amount"));
			expenseBeanObj.setItemId(rs.getString("id"));
			return expenseBeanObj;
			
		};
		List<ExpenseTrackerBean> expenseTrackerDataReportList= jdbcTemplateObject.query(sqlQuery, mapper);
		return expenseTrackerDataReportList;
	}

}
