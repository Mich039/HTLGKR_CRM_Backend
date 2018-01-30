package com.htl.crm.transferclasses;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Contact implements Serializable{
	private String firstname;
	private String lastname;
	private String phonenumber;
	private String email;
	private String adresse;
	
	
	public Contact() {
		
	}

	

	public Contact(String firstname, String lastname, String phonenumber, String email, String adresse) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phonenumber;
		this.email = email;
		this.adresse = adresse;
	}



	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}


	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}


	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}


	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}


	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	 
	
}
