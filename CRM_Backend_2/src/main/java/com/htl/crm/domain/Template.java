package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TEMPLATE database table.
 * 
 */
@Entity
@Table(name="TEMPLATE")
@NamedQuery(name="Template.findAll", query="SELECT t FROM Template t")
public class Template implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TEMPLATE_ID_GENERATOR", sequenceName="TEMPLATE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEMPLATE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@Column(name="OCASSION_NAME", length=500)
	private String ocassionName;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="template")
	private List<Bill> bills;

	//bi-directional many-to-one association to Invitation
	@OneToMany(mappedBy="template")
	private List<Invitation> invitations;

	//bi-directional many-to-one association to Receiver
	@OneToMany(mappedBy="template")
	private List<Receiver> receivers;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERSON_FK", nullable=false)
	private Person person;

	public Template() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOcassionName() {
		return this.ocassionName;
	}

	public void setOcassionName(String ocassionName) {
		this.ocassionName = ocassionName;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setTemplate(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setTemplate(null);

		return bill;
	}

	public List<Invitation> getInvitations() {
		return this.invitations;
	}

	public void setInvitations(List<Invitation> invitations) {
		this.invitations = invitations;
	}

	public Invitation addInvitation(Invitation invitation) {
		getInvitations().add(invitation);
		invitation.setTemplate(this);

		return invitation;
	}

	public Invitation removeInvitation(Invitation invitation) {
		getInvitations().remove(invitation);
		invitation.setTemplate(null);

		return invitation;
	}

	public List<Receiver> getReceivers() {
		return this.receivers;
	}

	public void setReceivers(List<Receiver> receivers) {
		this.receivers = receivers;
	}

	public Receiver addReceiver(Receiver receiver) {
		getReceivers().add(receiver);
		receiver.setTemplate(this);

		return receiver;
	}

	public Receiver removeReceiver(Receiver receiver) {
		getReceivers().remove(receiver);
		receiver.setTemplate(null);

		return receiver;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}