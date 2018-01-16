package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the INVITATION database table.
 * 
 */
@Entity
@NamedQuery(name="Invitation.findAll", query="SELECT i FROM Invitation i")
public class Invitation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INVITATION_INVITATIONID_GENERATOR", sequenceName="INVITATION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INVITATION_INVITATIONID_GENERATOR")
	@Column(name="INVITATION_ID")
	private long invitationId;

	//bi-directional many-to-one association to Template
	@ManyToOne
	private Template template;

	public Invitation() {
	}

	public long getInvitationId() {
		return this.invitationId;
	}

	public void setInvitationId(long invitationId) {
		this.invitationId = invitationId;
	}

	public Template getTemplate() {
		return this.template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

}