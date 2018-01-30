package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ADDRESS database table.
 * 
 */
@Entity
@Table(name="ADDRESS")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ADDRESS_ID_GENERATOR", sequenceName="ADDRESS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADDRESS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Column(name="DOOR_NUMBER", precision=22)
	private BigDecimal doorNumber;

	@Column(precision=22)
	private BigDecimal postalcode;

	@Column(name="STREET_ADDRESS", length=500)
	private String streetAddress;

	//bi-directional many-to-one association to Addresshistorie
	@OneToMany(mappedBy="address")
	private List<Addresshistorie> addresshistories;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="address")
	private List<Event> events;

	//bi-directional many-to-one association to Relation
	@OneToMany(mappedBy="address")
	private List<Relation> relations;

	public Address() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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

	public List<Addresshistorie> getAddresshistories() {
		return this.addresshistories;
	}

	public void setAddresshistories(List<Addresshistorie> addresshistories) {
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

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
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

	public List<Relation> getRelations() {
		return this.relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

	public Relation addRelation(Relation relation) {
		getRelations().add(relation);
		relation.setAddress(this);

		return relation;
	}

	public Relation removeRelation(Relation relation) {
		getRelations().remove(relation);
		relation.setAddress(null);

		return relation;
	}

}