package com.htl.crm.transferclasses;

import java.io.Serializable;

public class PostLogin implements Serializable{
	private String username;
	private String password;
	
	public PostLogin() {
		
	}
	
	public PostLogin(String username,String passwort) {
		this.username=username;
		this.password=passwort;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
