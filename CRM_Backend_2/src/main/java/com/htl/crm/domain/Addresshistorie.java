package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADDRESSHISTORIE database table.
 * 
 */
@Entity
@NamedQuery(name="Addresshistorie.findAll", query="SELECT a FROM Addresshistorie a")
public class Addresshistorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ADDRESSHISTORIE_ADDRESSHISTORIEID_GENERATOR", sequenceName="ADDRESSHISTORIE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADDRESSHISTORIE_ADDRESSHISTORIEID_GENERATOR")
	@Column(name="ADDRESSHISTORIE_ID")
	private long addresshistorieId;

	//bi-directional many-to-one association to Address
	@ManyToOne
	private Address address;

	//bi-directional many-to-one association to Person
	@ManyToOne
	private Person person;

	public Addresshistorie() {
	}

	public long getAddresshistorieId() {
		return this.addresshistorieId;
	}

	public void setAddresshistorieId(long addresshistorieId) {
		this.addresshistorieId = addresshistorieId;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}