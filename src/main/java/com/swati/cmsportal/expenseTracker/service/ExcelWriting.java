package com.swati.cmsportal.expenseTracker.service;



import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swati.cmsportal.expenseTracker.bean.ExpenseTrackerBean;
import com.swati.cmsportal.expenseTracker.dao.ExpenseTrackerDao;


@Component
public class ExcelWriting {
	
	
	@Autowired
	private ExpenseTrackerDao expenseTrackerDao;
	
	public Workbook exportToExcel(ExpenseTrackerBean expenseTrackerBean,List<ExpenseTrackerBean> reportDataList,String strAction)  {
		Workbook workbook = null;
		workbook = createExpenseTrackerReport(expenseTrackerBean, reportDataList);
		return workbook;
	}
	
	private Workbook createExpenseTrackerReport(ExpenseTrackerBean expenseTrackerBean, List<ExpenseTrackerBean> reportDataList) {
		
		List<ExpenseTrackerBean> expenseTrackerDataReportList= expenseTrackerDao.getExpenseTrackerDataReportList(expenseTrackerBean);
		Workbook workbook = new SXSSFWorkbook(100);
		Sheet sheet = workbook.createSheet("Monthly Expense");
		Row row = sheet.createRow(0);
		
		CellRangeAddress cellRangeAddress = new CellRangeAddress(0,0,0,6);
		sheet.addMergedRegion(cellRangeAddress);
		XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
		Cell cell = row.createCell(0);
		
		Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 14);
		font.setBold(true);
		
		cell.setCellStyle(style);
		font.setColor(IndexedColors.BLUE.getIndex());
		style.setFont(font);
		cell.setCellValue("Monthly Expense Data");
		
		
		
		RegionUtil.setBorderBottom(BorderStyle.THIN, cellRangeAddress, sheet);
        RegionUtil.setBorderTop(BorderStyle.THIN, cellRangeAddress, sheet);
        RegionUtil.setBorderLeft(BorderStyle.THIN, cellRangeAddress, sheet);
        RegionUtil.setBorderRight(BorderStyle.THIN, cellRangeAddress, sheet);
        
		row = sheet.createRow(1);
		row.createCell(0).setCellValue("Month");
		row.createCell(1).setCellValue("Expense Made By");
		row.createCell(2).setCellValue("Date");
		row.createCell(3).setCellValue("Category");
		row.createCell(4).setCellValue("Payment Mode");
		row.createCell(5).setCellValue("Description");
		row.createCell(6).setCellValue("Amount");
		
		int rowNum=2;
		for(ExpenseTrackerBean expenseTrackerData: expenseTrackerDataReportList) {
			Row dataRow= sheet.createRow(rowNum);
			dataRow.createCell(0).setCellValue(expenseTrackerData.getMonth());
			dataRow.createCell(1).setCellValue(expenseTrackerData.getExpenseMadeBy());
			dataRow.createCell(2).setCellValue(expenseTrackerData.getDate());
			dataRow.createCell(3).setCellValue(expenseTrackerData.getCategory());
			dataRow.createCell(4).setCellValue(expenseTrackerData.getPaymentMode());
			dataRow.createCell(5).setCellValue(expenseTrackerData.getDesc());
			dataRow.createCell(6).setCellValue(expenseTrackerData.getAmount());
			rowNum++;
		}
		return workbook;
	}
}
