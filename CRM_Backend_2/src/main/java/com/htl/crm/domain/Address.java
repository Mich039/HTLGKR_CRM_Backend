package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the ADDRESS database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ADDRESS_ADDRESSID_GENERATOR", sequenceName="ADDRESS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADDRESS_ADDRESSID_GENERATOR")
	@Column(name="ADDRESS_ID")
	private long addressId;

	@Temporal(TemporalType.DATE)
	@Column(name="\"Date\"")
	private Date date;

	@Column(name="DOOR_NUMBER")
	private BigDecimal doorNumber;

	private BigDecimal postalcode;

	@Column(name="STREET_ADDRESS")
	private String streetAddress;

	//bi-directional many-to-one association to Addresshistorie
	@OneToMany(mappedBy="address")
	private Set<Addresshistorie> addresshistories;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="address")
	private Set<Event> events;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="address")
	private Set<Role> roles;

	public Address() {
	}

	public long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getDoorNumber() {
		return this.doorNumber;
	}

	public void setDoorNumber(BigDecimal doorNumber) {
		this.doorNumber = doorNumber;
	}

	public BigDecimal getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(BigDecimal postalcode) {
		this.postalcode = postalcode;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public Set<Addresshistorie> getAddresshistories() {
		return this.addresshistories;
	}

	public void setAddresshistories(Set<Addresshistorie> addresshistories) {
		this.addresshistories = addresshistories;
	}

	public Addresshistorie addAddresshistory(Addresshistorie addresshistory) {
		getAddresshistories().add(addresshistory);
		addresshistory.setAddress(this);

		return addresshistory;
	}

	public Addresshistorie removeAddresshistory(Addresshistorie addresshistory) {
		getAddresshistories().remove(addresshistory);
		addresshistory.setAddress(null);

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
		event.setAddress(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setAddress(null);

		return event;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setAddress(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setAddress(null);

		return role;
	}

}