package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the TEMPLATE database table.
 * 
 */
@Entity
@NamedQuery(name="Template.findAll", query="SELECT t FROM Template t")
public class Template implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TEMPLATE_TEMPLATEID_GENERATOR", sequenceName="TEMPLATE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEMPLATE_TEMPLATEID_GENERATOR")
	@Column(name="TEMPLATE_ID")
	private long templateId;

	@Column(name="OCASSION_NAME")
	private String ocassionName;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="template")
	private Set<Bill> bills;

	//bi-directional many-to-one association to Invitation
	@OneToMany(mappedBy="template")
	private Set<Invitation> invitations;

	//bi-directional many-to-one association to Receiver
	@OneToMany(mappedBy="template")
	private Set<Receiver> receivers;

	//bi-directional many-to-one association to Person
	@ManyToOne
	private Person person;

	public Template() {
	}

	public long getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}

	public String getOcassionName() {
		return this.ocassionName;
	}

	public void setOcassionName(String ocassionName) {
		this.ocassionName = ocassionName;
	}

	public Set<Bill> getBills() {
		return this.bills;
	}

	public void setBills(Set<Bill> bills) {
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

	public Set<Invitation> getInvitations() {
		return this.invitations;
	}

	public void setInvitations(Set<Invitation> invitations) {
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

	public Set<Receiver> getReceivers() {
		return this.receivers;
	}

	public void setReceivers(Set<Receiver> receivers) {
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