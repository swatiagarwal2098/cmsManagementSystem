package com.swati.cmsportal.cms.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.swati.cmsportal.cms.bean.LoginBean;
import com.swati.cmsportal.cms.dao.LoginDao;

@Service("loginService")
public class LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	public Map<String, Object> checkLoginCredentials(LoginBean loginBean, HttpSession session, HttpServletRequest request){
		
		Map<String, Object> hm= new HashMap<String, Object>();
		LoginBean loginBeanData= loginDao.checkLoginCredentials(loginBean);
		if(loginBean.getUserName().equals(loginBeanData.getUserName()) && loginBean.getPassword().equals(loginBeanData.getPassword()) ) {
			session.setAttribute("sessExpenseUserInfo", loginBeanData);
			hm.put("result", "SUCCESS");
		}else if(!loginBean.getUserName().equals(loginBeanData.getUserName())) {
			hm.put("result", "INVALID USERNAME");
		}else if(!loginBean.getPassword().equals(loginBeanData.getPassword())) {
			hm.put("result", "INVALID PASSWORD");
		}
		return hm;
	}
	
	public Map<String, Object> createNewUser(LoginBean loginBean){
		Map<String, Object> hm= new HashMap<String, Object>();
		int result= loginDao.createNewUser(loginBean);
		if("1".equals(String.valueOf(result))) {
			hm.put("result", "SUCCESS");
		}else {
			hm.put("result", "ERROR");
		}
		return hm;
	}
}
