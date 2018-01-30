package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADDRESSHISTORIE database table.
 * 
 */
@Entity
@Table(name="ADDRESSHISTORIE")
@NamedQuery(name="Addresshistorie.findAll", query="SELECT a FROM Addresshistorie a")
public class Addresshistorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ADDRESSHISTORIE_ID_GENERATOR", sequenceName="ADDRESSHISTORIE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADDRESSHISTORIE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="ADDRESS_FK", nullable=false)
	private Address address;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERSON_FK", nullable=false)
	private Person person;

	public Addresshistorie() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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