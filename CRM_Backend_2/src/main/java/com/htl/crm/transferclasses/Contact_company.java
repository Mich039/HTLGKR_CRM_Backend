package com.htl.crm.transferclasses;

import java.awt.Image;
import java.util.LinkedList;

public class Contact_company {
	//Unterscheidung Company/Person: in PData
	private String company_name; //Name der Firma
	private String management; //Name des Leitpersonals
	private String description; //company_description
	private String domain; //Website-URL
	private String connection; //durch wen wird der Kontakt gepflegt
	//Adressdaten
	private String street;
	private String streetnumber;
	private String postcode;
	private String town;
	//restliche Daten
	private LinkedList<Contact_person> contact_persons; //alle Kontaktpersonen
	private LinkedList<String> company_conversations; //alle Firmengespräche (aufgezeichnet)
	LinkedList<Image> images; //Bilder für ...
	
	public Contact_company() {}
	
	public Contact_company(String company_name, String management_person, String company_description, String website_url, String connector
						  ,String streetname, String postalcode, String town) {
		super();
		this.company_name = company_name;
		this.management = management_person;
		this.description = company_description;
		this.domain = website_url;
		this.connection = connector;
		this.street = streetname;
		this.postcode = postalcode;
		this.town = town;
	}

	/**
	 * @GET the name of the company**/
	
	public String getCompany_name() {
		return company_name;
	}

	/**
	 * @SET the name of the company**/
	
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	/**
	 * @GET name of the manager*/
	
	public String getManagement() {
		return management;
	}

	/**
	 * @SET name of the manager**/
	
	public void setManagement(String management) {
		this.management = management;
	}

	/**
	 * @GET description of the company*/
	
	public String getDescription() {
		return description;
	}
	
	/**
	 * @SET description of the company*/

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @GET Domain/URL of the companies´ website*/
	
	public String getDomain() {
		return domain;
	}

	/**
	 * @SET Domain/URL of the companies´ website*/
	
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * @GET the guy*/
	
	public String getConnection() {
		return connection;
	}

	/**
	 * @SET the guy*/
	
	public void setConnection(String connection) {
		this.connection = connection;
	}

	/**
	 * @GET Adress: street name*/
	
	public String getStreet() {
		return street;
	}

	/**
	 * @SET Adress: street name*/
	
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @GET Adress: street number*/
	
	public String getStreetnumber() {
		return streetnumber;
	}

	/**
	 * @SET Adress: street number*/
	
	public void setStreetnumber(String streetnumber) {
		this.streetnumber = streetnumber;
	}
	
	/**
	 * @GET Adress: postal code*/

	public String getPostcode() {
		return postcode;
	}
	
	/**
	 * @SET Adress: postal code*/

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	/**
	 * @GET Adress: town name*/

	public String getTown() {
		return town;
	}

	/**
	 * @SET Adress: town name*/
	
	public void setTown(String town) {
		this.town = town;
	}

	/**
	 * @GET List of all contact persons*/
	
	public LinkedList<Contact_person> getContact_persons() {
		return contact_persons;
	}

	/**
	 * @SET List of all contact persons*/
	
	public void setContact_persons(LinkedList<Contact_person> contact_persons) {
		this.contact_persons = contact_persons;
	}

	/**
	 * @GET conversations w/ companies*/
	
	public LinkedList<String> getCompany_conversations() {
		return company_conversations;
	}

	/**
	 * @GET conversations with companies*/
	
	public void setCompany_conversations(LinkedList<String> company_conversations) {
		this.company_conversations = company_conversations;
	}
	
	/**
	 * @GET Company_info:
	 * 	 -company name, company description
	 * 	 ,management_person: leader,
	 * 	 website url (company)*/
	
	public String Company_info() {
		return ""+ company_name+""+description +""+management+""+domain;
	}
}
