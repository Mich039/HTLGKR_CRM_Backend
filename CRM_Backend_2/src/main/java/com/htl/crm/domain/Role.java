package com.htl.crm.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the "ROLE" database table.
 * 
 */
@Entity
@Table(name = "\"ROLE\"")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "\"ROLE\"_ROLEID_GENERATOR", sequenceName = "\"ROLE_SEQ\"")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"ROLE\"_ROLEID_GENERATOR")
	@Column(name = "ROLE_ID")
	private long roleId;

	// bi-directional many-to-one association to Person
	@OneToMany(mappedBy = "role")
	private Set<Person> persons;

	// bi-directional many-to-one association to Address
	@ManyToOne
	private Address address;

	// bi-directional many-to-one association to Person
	@ManyToOne
	private Person person;

	// bi-directional many-to-one association to RType
	@ManyToOne
	@JoinColumn(name = "R_TYPE_R_TYPE_ID")
	private RType RType;

	public Role() {
	}

	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public Set<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setRole(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setRole(null);

		return person;
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

	public RType getRType() {
		return this.RType;
	}

	public void setRType(RType RType) {
		this.RType = RType;
	}

}