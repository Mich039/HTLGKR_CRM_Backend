package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ACCESS_RIGHT_P_ROLE database table.
 * 
 */
@Entity
@Table(name="ACCESS_RIGHT_P_ROLE")
@NamedQuery(name="AccessRightPRole.findAll", query="SELECT a FROM AccessRightPRole a")
public class AccessRightPRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACCESS_RIGHT_P_ROLE_ID_GENERATOR", sequenceName="ACCESS_RIGHT_P_ROLE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCESS_RIGHT_P_ROLE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	//bi-directional many-to-one association to AccessRight
	@ManyToOne
	@JoinColumn(name="ACCESS_RIGHT_FK", nullable=false)
	private AccessRight accessRight;

	//bi-directional many-to-one association to PRole
	@ManyToOne
	@JoinColumn(name="P_ROLE_FK", nullable=false)
	private PRole PRole;

	public AccessRightPRole() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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