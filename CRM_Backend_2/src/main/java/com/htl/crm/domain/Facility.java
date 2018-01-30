package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the FACILITY database table.
 * 
 */
@Entity
@Table(name="FACILITY")
@NamedQuery(name="Facility.findAll", query="SELECT f FROM Facility f")
public class Facility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FACILITY_ID_GENERATOR", sequenceName="FACILITY_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FACILITY_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@Column(length=500)
	private String name;

	//bi-directional many-to-one association to Receiver
	@OneToMany(mappedBy="facility")
	private List<Receiver> receivers;

	public Facility() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Receiver> getReceivers() {
		return this.receivers;
	}

	public void setReceivers(List<Receiver> receivers) {
		this.receivers = receivers;
	}

	public Receiver addReceiver(Receiver receiver) {
		getReceivers().add(receiver);
		receiver.setFacility(this);

		return receiver;
	}

	public Receiver removeReceiver(Receiver receiver) {
		getReceivers().remove(receiver);
		receiver.setFacility(null);

		return receiver;
	}

}