package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


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
	@SequenceGenerator(name="AR_PR_ACESRIGTPROLEID_GENERATOR", sequenceName="AR_PR_ACES_RIGT_P_ROLE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AR_PR_ACESRIGTPROLEID_GENERATOR")
	@Column(name="ACES_RIGT_P_ROLE_ID", unique=true, nullable=false, precision=22)
	private long acesRigtPRoleId;

	@Column(name="ACCESS_RIGHT_ID", nullable=false, precision=22)
	private BigDecimal accessRightId;

	@Column(name="P_ROLE_ID", nullable=false, precision=22)
	private BigDecimal pRoleId;

	public ArPr() {
	}

	public long getAcesRigtPRoleId() {
		return this.acesRigtPRoleId;
	}

	public void setAcesRigtPRoleId(long acesRigtPRoleId) {
		this.acesRigtPRoleId = acesRigtPRoleId;
	}

	public BigDecimal getAccessRightId() {
		return this.accessRightId;
	}

	public void setAccessRightId(BigDecimal accessRightId) {
		this.accessRightId = accessRightId;
	}

	public BigDecimal getPRoleId() {
		return this.pRoleId;
	}

	public void setPRoleId(BigDecimal pRoleId) {
		this.pRoleId = pRoleId;
	}

}