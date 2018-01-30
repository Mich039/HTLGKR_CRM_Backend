package com.htl.crm.domain;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the PERSON database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSON_PERSONID_GENERATOR", sequenceName="PERSON_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSON_PERSONID_GENERATOR")
	@Column(name="PERSON_ID")
	private long personId;

	//bi-directional many-to-one association to Addresshistorie
	@OneToMany(mappedBy="person")
	private Set<Addresshistorie> addresshistories;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="person")
	private Set<Event> events;

	//bi-directional many-to-one association to PRole
	@ManyToOne
	@JoinColumn(name="P_ROLE_P_ROLE_ID")
	private PRole PRole;

	//bi-directional many-to-one association to Role
	@ManyToOne
	private Role role;

	//bi-directional many-to-one association to PData
	@OneToMany(mappedBy="person")
	private Set<PData> PData;

	//bi-directional many-to-one association to Receiver
	@OneToMany(mappedBy="person")
	private Set<Receiver> receivers;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="person")
	private Set<Role> roles;

	//bi-directional many-to-one association to Template
	@OneToMany(mappedBy="person")
	private Set<Template> templates;

	public Person() {
	}

	public long getPersonId() {
		return this.personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public Set<Addresshistorie> getAddresshistories() {
		return this.addresshistories;
	}

	public void setAddresshistories(Set<Addresshistorie> addresshistories) {
		this.addresshistories = addresshistories;
	}

	public Addresshistorie addAddresshistory(Addresshistorie addresshistory) {
		getAddresshistories().add(addresshistory);
		addresshistory.setPerson(this);

		return addresshistory;
	}

	public Addresshistorie removeAddresshistory(Addresshistorie addresshistory) {
		getAddresshistories().remove(addresshistory);
		addresshistory.setPerson(null);

		return addresshistory;
	}

	public Set<Event> getEvents() {
		return this.events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setPerson(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setPerson(null);

		return event;
	}

	public PRole getPRole() {
		return this.PRole;
	}

	public void setPRole(PRole PRole) {
		this.PRole = PRole;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<PData> getPData() {
		return this.PData;
	}

	public void setPData(Set<PData> PData) {
		this.PData = PData;
	}

	public PData addPData(PData PData) {
		getPData().add(PData);
		PData.setPerson(this);

		return PData;
	}

	public PData removePData(PData PData) {
		getPData().remove(PData);
		PData.setPerson(null);

		return PData;
	}

	public Set<Receiver> getReceivers() {
		return this.receivers;
	}

	public void setReceivers(Set<Receiver> receivers) {
		this.receivers = receivers;
	}

	public Receiver addReceiver(Receiver receiver) {
		getReceivers().add(receiver);
		receiver.setPerson(this);

		return receiver;
	}

	public Receiver removeReceiver(Receiver receiver) {
		getReceivers().remove(receiver);
		receiver.setPerson(null);

		return receiver;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setPerson(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setPerson(null);

		return role;
	}

	public Set<Template> getTemplates() {
		return this.templates;
	}

	public void setTemplates(Set<Template> templates) {
		this.templates = templates;
	}

	public Template addTemplate(Template template) {
		getTemplates().add(template);
		template.setPerson(this);

		return template;
	}

	public Template removeTemplate(Template template) {
		getTemplates().remove(template);
		template.setPerson(null);

		return template;
	}
	
	public PData getPDataFromType(String type) {
		for(PData pdata : this.PData) {
			if(pdata.getPDatatype().getType().equals(type)) {
				return pdata;
			}
		}
		return null;
	}

}