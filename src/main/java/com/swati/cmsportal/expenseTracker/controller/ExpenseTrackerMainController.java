package com.swati.cmsportal.expenseTracker.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String displayExpenseTrackerMaster(HttpServletRequest request, HttpSession session, LoginBean loginBean, Model model) {
		if(session.getAttribute("sessExpenseUserInfo")!=null) {
			loginBean.setUserId(((LoginBean) session.getAttribute("sessExpenseUserInfo")).getUserId());
			model.addAttribute("userId",loginBean.getUserId());
		}else {
			String url= "redirect:/spring/login/logout";
		}
		return "expenseTracker/master";
	}
	
	@RequestMapping(value="/report", method=RequestMethod.GET)
	public String displayExpenseTrackerReport() {
		return "expenseTracker/report";
	}

}
