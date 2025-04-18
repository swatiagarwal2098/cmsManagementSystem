package com.swati.cmsportal.expenseTracker.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swati.cmsportal.expenseTracker.bean.ExpenseTrackerBean;


@Service
public class ExpenseMainService {
	@Autowired
	private HttpServletRequest request;
	
	public Map<String, Object> downloadExcelFile(Workbook workbook, ExpenseTrackerBean expenseTrackerBean) {
		Map<String, Object> tm 	= new TreeMap<String, Object>();
		String strSuccess 		= "success";
		String filename 		= "Reports\\";
		String fName 			= "Reports\\xlsx\\";		
		try {			
			
			filename= filename+"EXPENSE_TRACKER_DATA_REPORT.xlsx";
			fName = fName+"EXPENSE_TRACKER_DATA_REPORT.xlsx";
				
			
			String dirPath = request.getSession().getServletContext().getRealPath("/");
			File theDir = new File(dirPath + "Reports");
			System.out.println("theDir...."+theDir);
			if (!theDir.exists()) {
				theDir.mkdir();
			}
			//deleteUnusedFiles(dirPath+"Reports",1,".xlsx");
			FileOutputStream out = new FileOutputStream(new File(dirPath + filename));
			workbook.write(out);
			out.close();
			filename = fName + "?t=" + System.currentTimeMillis();
			tm.put("fileName", filename);
		} catch (Exception e) {
			strSuccess = "error";
		}
		tm.put("success", strSuccess);
		return tm;
	}

}
