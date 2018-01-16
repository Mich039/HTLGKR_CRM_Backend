package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AR_PR database table.
 * 
 */
@Entity
@Table(name="AR_PR")
@NamedQuery(name="ArPr.findAll", query="SELECT a FROM ArPr a")
public class ArPr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AR_PR_ACESRIGTPROLEID_GENERATOR", sequenceName="AR_PR_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AR_PR_ACESRIGTPROLEID_GENERATOR")
	@Column(name="ACES_RIGT_P_ROLE_ID")
	private long acesRigtPRoleId;

	//bi-directional many-to-one association to AccessRight
	@ManyToOne
	@JoinColumn(name="ACCESS_RIGHT_ID")
	private AccessRight accessRight;

	//bi-directional many-to-one association to PRole
	@ManyToOne
	@JoinColumn(name="P_ROLE_ID")
	private PRole PRole;

	public ArPr() {
	}

	public long getAcesRigtPRoleId() {
		return this.acesRigtPRoleId;
	}

	public void setAcesRigtPRoleId(long acesRigtPRoleId) {
		this.acesRigtPRoleId = acesRigtPRoleId;
	}

	public AccessRight getAccessRight() {
		return this.accessRight;
	}

	public void setAccessRight(AccessRight accessRight) {
		this.accessRight = accessRight;
	}

	public PRole getPRole() {
		return this.PRole;
	}

	public void setPRole(PRole PRole) {
		this.PRole = PRole;
	}

}