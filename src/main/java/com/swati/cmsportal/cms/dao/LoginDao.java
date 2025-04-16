package com.swati.cmsportal.cms.dao;

import java.util.Map;

import javax.sql.DataSource;

import com.swati.cmsportal.cms.bean.LoginBean;

public interface LoginDao {

	public void setDataSource(DataSource ds);
	LoginBean checkLoginCredentials(LoginBean loginBean);
	int createNewUser(LoginBean loginBean);
	
}
