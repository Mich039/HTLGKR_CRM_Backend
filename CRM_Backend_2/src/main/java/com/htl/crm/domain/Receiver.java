package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RECEIVER database table.
 * 
 */
@Entity
@Table(name="RECEIVER")
@NamedQuery(name="Receiver.findAll", query="SELECT r FROM Receiver r")
public class Receiver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RECEIVER_ID_GENERATOR", sequenceName="RECEIVER_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECEIVER_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="FACILITY_FK", nullable=false)
	private Facility facility;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERSON_FK", nullable=false)
	private Person person;

	//bi-directional many-to-one association to Template
	@ManyToOne
	@JoinColumn(name="TEMPLATE_FK", nullable=false)
	private Template template;

	public Receiver() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Template getTemplate() {
		return this.template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

}