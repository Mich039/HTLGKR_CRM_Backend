package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RELATION database table.
 * 
 */
@Entity
@Table(name="RELATION")
@NamedQuery(name="Relation.findAll", query="SELECT r FROM Relation r")
public class Relation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RELATION_ID_GENERATOR", sequenceName="RELATION_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RELATION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="relation")
	private List<Person> persons;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="ADDRESS_FK", nullable=false)
	private Address address;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERSON_FK", nullable=false)
	private Person person;

	//bi-directional many-to-one association to RType
	@ManyToOne
	@JoinColumn(name="R_TYPE_FK", nullable=false)
	private RType RType;

	public Relation() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setRelation(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setRelation(null);

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