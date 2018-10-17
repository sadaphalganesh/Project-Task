package com.jbk.entity;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Admin {
	
	public Admin() {
		
	}

	@Value("${admin.userName}")
	private String userName;
	
	@Value("${admin.password}")
	private String password;
	
	@Value("${admin.emailID}")
	private String adminEmail;
	
	@Value("${admin.emailPassword}")
	private String emailPassword;
	

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getEmailPassword() {
		return emailPassword;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

	public  String getUserName() {
		return userName;
	}

	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
