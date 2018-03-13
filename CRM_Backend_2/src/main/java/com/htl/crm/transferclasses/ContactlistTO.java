package com.htl.crm.transferclasses;

import java.io.Serializable;
import java.util.LinkedList;

public class ContactlistTO implements Serializable {

	LinkedList<Contact> contactlist = new LinkedList<>();
	
	public LinkedList<Contact> getContactlist() {
		return contactlist;
	}

	public void setContactlist(LinkedList<Contact> contactlist) {
		this.contactlist = contactlist;
	}

	public ContactlistTO() {
		
	}
	
	
	
}
