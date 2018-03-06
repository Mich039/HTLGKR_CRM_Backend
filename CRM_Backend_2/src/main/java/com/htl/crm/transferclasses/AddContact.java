package com.htl.crm.transferclasses;

import java.io.Serializable;

public class AddContact implements Serializable{
	
	private PersonData[] personData;
	private String role;
	
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public PersonData[] getPersonData() {
		return personData;
	}

	public void setPersonData(PersonData[] personData) {
		this.personData = personData;
	}

	public AddContact(PersonData[] personData) {
		super();
		this.personData = personData;
	}

	public AddContact() {
		super();
	}
	
	public PersonData GetPersonDataByType(String type) {
		for(PersonData pdata : personData) {
			if(pdata.getDatatype().equals(type))
				return pdata;
		}
		return null;
	}
	
}
