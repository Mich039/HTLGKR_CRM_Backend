package com.htl.crm.transferclasses;

public class Contact_person {
	private String salutation; //Anrede
	private String street;
	private String postcode;
	private String streetnumber;
	private String town;
	private String email;
	private String phonenumber;
	private String interests;
	private String job_history;
	
	public Contact_person() {}
	
	public Contact_person(String salutation, String streetname, String postal_code, String street_number, String town_name
						  ,String mail, String phone, String interests, String jobs_url) {
		super();
		this.setSalutation(salutation);
		this.setStreet(streetname);
		this.setPostcode(postal_code);
		this.setStreetnumber(street_number);
		this.setTown(town_name);
		this.setEmail(mail);
		this.setPhonenumber(phone);
		this.setInterests(interests);
		this.setJob_history(jobs_url);
	}

	/**
	 * @GET Anrede*/
	
	public String getSalutation() {
		return salutation;
	}

	/**
	 * @SET Anrede*/
	
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	/**
	 * @GET street name*/
	
	public String getStreet() {
		return street;
	}

	/**
	 * @SET street name*/
	
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @GET postal code*/
	
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @SET postal code*/
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @GET street number*/
	
	public String getStreetnumber() {
		return streetnumber;
	}
	
	/**
	 * @SET street number*/

	public void setStreetnumber(String streetnumber) {
		this.streetnumber = streetnumber;
	}

	/**
	 * @GET town name*/
	
	public String getTown() {
		return town;
	}

	/**
	 * @SET town name*/
	
	public void setTown(String town) {
		this.town = town;
	}

	/**
	 * @GET email address*/
	
	public String getEmail() {
		return email;
	}
	
	/**
	 * @SET email address*/

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @GET phone number*/

	public String getPhonenumber() {
		return phonenumber;
	}

	/**
	 * @SET phone number*/
	
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	/**
	 * @GET interests*/
	
	public String getInterests() {
		return interests;
	}
	
	/**
	 * @SET interests*/

	public void setInterests(String interests) {
		this.interests = interests;
	}

	/**
	 * @GET job history (Linkedin-Link)*/
	
	public String getJob_history() {
		return job_history;
	}

	/**
	 * @SET job history (Linkedin-Link)*/
	
	public void setJob_history(String job_history) {
		this.job_history = job_history;
	}
	
}
