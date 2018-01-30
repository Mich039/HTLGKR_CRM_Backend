package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ACCESS_RIGHT database table.
 * 
 */
@Entity
@Table(name="ACCESS_RIGHT")
@NamedQuery(name="AccessRight.findAll", query="SELECT a FROM AccessRight a")
public class AccessRight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACCESS_RIGHT_ID_GENERATOR", sequenceName="ACCESS_RIGHT_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCESS_RIGHT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@Column(name="ACCESS_RIGHT", length=500)
	private String accessRight;

	//bi-directional many-to-one association to AccessRightPRole
	@OneToMany(mappedBy="accessRight")
	private List<AccessRightPRole> accessRightPRoles;

	public AccessRight() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccessRight() {
		return this.accessRight;
	}

	public void setAccessRight(String accessRight) {
		this.accessRight = accessRight;
	}

	public List<AccessRightPRole> getAccessRightPRoles() {
		return this.accessRightPRoles;
	}

	public void setAccessRightPRoles(List<AccessRightPRole> accessRightPRoles) {
		this.accessRightPRoles = accessRightPRoles;
	}

	public AccessRightPRole addAccessRightPRole(AccessRightPRole accessRightPRole) {
		getAccessRightPRoles().add(accessRightPRole);
		accessRightPRole.setAccessRight(this);

		return accessRightPRole;
	}

	public AccessRightPRole removeAccessRightPRole(AccessRightPRole accessRightPRole) {
		getAccessRightPRoles().remove(accessRightPRole);
		accessRightPRole.setAccessRight(null);

		return accessRightPRole;
	}

}