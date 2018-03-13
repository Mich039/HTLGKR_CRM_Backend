package com.htl.crm.transferclasses;

import java.io.Serializable;

import com.htl.crm.domain.Person;

public class PersonTO implements Serializable {

	private String firstname;
	private String lastname;
	
	public PersonTO() {
		super();
	}
	
	public PersonTO(Person person) {
		this.firstname = person.getPDataFromType("firstname").getValue();
		this.lastname = person.getPDataFromType("lastname").getValue();
	}
	
	public PersonTO(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	

}
