package com.swati.cmsportal.cms.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.swati.cmsportal.cms.bean.LoginBean;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	
	 public void setDataSource(DataSource dataSource) 
	   {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	   
	@Override
	public LoginBean checkLoginCredentials(LoginBean logBean){
		Map<String, Object> hm= new HashMap<String, Object>();
		String result= null;
		LoginBean loginBean= new LoginBean();
		try {
			String SqlQuery= "Select isnull(userName,0) from cms_user_info where userName ="+  "'"+logBean.getUserName()+"'";
			result = jdbcTemplateObject.queryForObject(SqlQuery, String.class);
			if(result!=null) {
				SqlQuery= "Select * from cms_user_info where userName ="+  "'"+logBean.getUserName()+"'";
				RowMapper<LoginBean> mapper= (rs, rowNum)->{
					LoginBean loginBeanObj = new LoginBean();
					loginBeanObj.setUserName(rs.getString("userName"));
					loginBeanObj.setPassword(rs.getString("password"));
					return loginBeanObj;
				};
				loginBean=jdbcTemplateObject.queryForObject(SqlQuery, mapper);
			}
		} catch (Exception e) {
			loginBean.setUserName("Invalid User Name");
			loginBean.setPassword("Invalid Password");
			return loginBean;
		}
		return loginBean;
	}
	
	@Override
	public int createNewUser(LoginBean loginBean){
		int result= jdbcTemplateObject.update("INSERT INTO cms_user_info (firstName, lastName, phoneNumber, userName, password) VALUES ('" + loginBean.getFirstName() + "', '" + loginBean.getLastName() + "','" + loginBean.getPhoneNumber() + "', '" + loginBean.getUserName() + "', '" + loginBean.getPassword() + "')");
		return result;
	}
}
