package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RECEIVER database table.
 * 
 */
@Entity
@NamedQuery(name="Receiver.findAll", query="SELECT r FROM Receiver r")
public class Receiver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RECEIVER_RECEIVERID_GENERATOR", sequenceName="RECEIVER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECEIVER_RECEIVERID_GENERATOR")
	@Column(name="RECEIVER_ID")
	private long receiverId;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to Person
	@ManyToOne
	private Person person;

	//bi-directional many-to-one association to Template
	@ManyToOne
	private Template template;

	public Receiver() {
	}

	public long getReceiverId() {
		return this.receiverId;
	}

	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
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