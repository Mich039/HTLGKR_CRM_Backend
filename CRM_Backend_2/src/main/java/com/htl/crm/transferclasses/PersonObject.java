package com.htl.crm.transferclasses;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.htl.crm.domain.Addresshistorie;
import com.htl.crm.domain.Event;
import com.htl.crm.domain.PData;
import com.htl.crm.domain.PRole;
import com.htl.crm.domain.Receiver;
import com.htl.crm.domain.Role;
import com.htl.crm.domain.Template;


public class PersonObject implements Serializable{

	private long personId;

	private List<Addresshistorie> addresshistories;

	private List<Event> events;

	private List<PRole> PRole;

	private List<Role> role;

	private List<PData> PData;

	private List<Receiver> receivers;

	private List<Role> roles;

	private List<Template> templates;

	

	public long getPersonId() {
		return personId;
	}



	public void setPersonId(long personId) {
		this.personId = personId;
	}



	public List<Addresshistorie> getAddresshistories() {
		return addresshistories;
	}



	public void setAddresshistories(List<Addresshistorie> addresshistories) {
		this.addresshistories = addresshistories;
	}



	public List<Event> getEvents() {
		return events;
	}



	public void setEvents(List<Event> events) {
		this.events = events;
	}



	public List<PRole> getPRole() {
		return PRole;
	}



	public void setPRole(List<PRole> pRole) {
		PRole = pRole;
	}



	public List<Role> getRole() {
		return role;
	}



	public void setRole(List<Role> role) {
		this.role = role;
	}



	public List<PData> getPData() {
		return PData;
	}



	public void setPData(List<PData> pData) {
		PData = pData;
	}



	public List<Receiver> getReceivers() {
		return receivers;
	}



	public void setReceivers(List<Receiver> receivers) {
		this.receivers = receivers;
	}



	public List<Role> getRoles() {
		return roles;
	}



	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}



	public List<Template> getTemplates() {
		return templates;
	}



	public void setTemplates(List<Template> templates) {
		this.templates = templates;
	}



	public PersonObject() {
	}
	
	
}
