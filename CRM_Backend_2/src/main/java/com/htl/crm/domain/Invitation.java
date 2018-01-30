package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the INVITATION database table.
 * 
 */
@Entity
@Table(name="INVITATION")
@NamedQuery(name="Invitation.findAll", query="SELECT i FROM Invitation i")
public class Invitation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INVITATION_ID_GENERATOR", sequenceName="INVITATION_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INVITATION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	//bi-directional many-to-one association to Template
	@ManyToOne
	@JoinColumn(name="TEMPLATE_FK", nullable=false)
	private Template template;

	public Invitation() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Template getTemplate() {
		return this.template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

}