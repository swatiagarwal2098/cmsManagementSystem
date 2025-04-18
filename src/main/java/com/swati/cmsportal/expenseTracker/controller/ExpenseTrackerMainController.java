package com.swati.cmsportal.expenseTracker.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swati.cmsportal.cms.bean.LoginBean;

@Controller

public class ExpenseTrackerMainController {
	
	@RequestMapping(value="/expenseTrackerHome", method= RequestMethod.GET)
	public String displayExpenseTrackerHome(HttpSession session, HttpServletRequest request, LoginBean loginBean) {
		/*if(session.getAttribute("sessExpenseUserInfo")!=null) {
			loginBean.setUserId(((LoginBean) session.getAttribute("sessExpenseUserInfo")).getUserId());
		}*/
		return "expenseTracker/expenseTrackerHome";
	}
	
	
	@RequestMapping(value="/master", method=RequestMethod.GET)
	public String displayExpenseTrackerMaster(HttpSession session, HttpServletRequest request) {
		if(session.getAttribute("sessExpenseUserInfo")==null) {
			return "cms/logout";
		}
		return "expenseTracker/master";
	}
	
	@RequestMapping(value="/report", method=RequestMethod.GET)
	public String displayExpenseTrackerReport(HttpSession session, HttpServletRequest request) {
		if(session.getAttribute("sessExpenseUserInfo")==null) {
			return "cms/logout";
		}
		return "expenseTracker/report";
	}
	
	@RequestMapping(value="Reports/{fileExt}/{fileName}",method = RequestMethod.GET)
	public void downloadFile(@PathVariable("fileExt") String fileExt,@PathVariable("fileName") String fileName,HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("application/octet-stream");
		String filename="Reports\\"+fileName;
		if(fileExt!=null && "pdf".equals(fileExt)) {
			 filename="Reports\\"+fileName;
			 response.setContentType("application/pdf");
		}
		String dirPath = request.getSession().getServletContext().getRealPath("/");
        File downloadFile = new File(dirPath+filename);
        FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(downloadFile);
		} catch (FileNotFoundException ex) {
		}
		response.setContentLength((int) downloadFile.length());
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",downloadFile.getName());
        response.setHeader(headerKey, headerValue);
        OutputStream outStream;
		try {
			outStream = response.getOutputStream();
			byte[] buffer = new byte[(int) downloadFile.length()];
	        int bytesRead = -1;
	        // write bytes read from the input stream into the output stream
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outStream.write(buffer, 0, bytesRead);
	        }
	        inputStream.close();
	        outStream.close();
		} catch (Exception ex) {
		}
	}

}
