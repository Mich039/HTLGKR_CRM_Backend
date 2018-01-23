package com.htl.crm.transferclasses;

public class PostLogin {
	private String benutzername;
	private String passwort;
	
	public PostLogin() {
		
	}
	
	public PostLogin(String benutzername,String passwort) {
		this.benutzername=benutzername;
		this.passwort=passwort;
	}
	
	public String getBenutzername() {
		return benutzername;
	}
	
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}
	
	public String getPasswort() {
		return passwort;
	}
	
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
}
