package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the FACILITY database table.
 * 
 */
@Entity
@NamedQuery(name="Facility.findAll", query="SELECT f FROM Facility f")
public class Facility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FACILITY_FACILITYID_GENERATOR", sequenceName="FACILITY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FACILITY_FACILITYID_GENERATOR")
	@Column(name="FACILITY_ID")
	private long facilityId;

	private String name;

	//bi-directional many-to-one association to Receiver
	@OneToMany(mappedBy="facility")
	private Set<Receiver> receivers;

	public Facility() {
	}

	public long getFacilityId() {
		return this.facilityId;
	}

	public void setFacilityId(long facilityId) {
		this.facilityId = facilityId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Receiver> getReceivers() {
		return this.receivers;
	}

	public void setReceivers(Set<Receiver> receivers) {
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