package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the P_ROLE database table.
 * 
 */
@Entity
@Table(name="P_ROLE")
@NamedQuery(name="PRole.findAll", query="SELECT p FROM PRole p")
public class PRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="P_ROLE_PROLEID_GENERATOR", sequenceName="P_ROLE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="P_ROLE_PROLEID_GENERATOR")
	@Column(name="P_ROLE_ID")
	private long pRoleId;

	@Column(name="\"ROLE\"")
	private String role;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="PRole")
	private Set<Person> persons;

	//bi-directional many-to-one association to ArPr
	@OneToMany(mappedBy="PRole")
	private Set<ArPr> arPrs;

	public PRole() {
	}

	public long getPRoleId() {
		return this.pRoleId;
	}

	public void setPRoleId(long pRoleId) {
		this.pRoleId = pRoleId;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setPRole(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setPRole(null);

		return person;
	}

	public Set<ArPr> getArPrs() {
		return this.arPrs;
	}

	public void setArPrs(Set<ArPr> arPrs) {
		this.arPrs = arPrs;
	}

	public ArPr addArPr(ArPr arPr) {
		getArPrs().add(arPr);
		arPr.setPRole(this);

		return arPr;
	}

	public ArPr removeArPr(ArPr arPr) {
		getArPrs().remove(arPr);
		arPr.setPRole(null);

		return arPr;
	}

}