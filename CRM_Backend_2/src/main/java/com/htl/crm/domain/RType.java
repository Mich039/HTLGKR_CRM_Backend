package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the R_TYPE database table.
 * 
 */
@Entity
@Table(name="R_TYPE")
@NamedQuery(name="RType.findAll", query="SELECT r FROM RType r")
public class RType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="R_TYPE_RTYPEID_GENERATOR", sequenceName="R_TYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="R_TYPE_RTYPEID_GENERATOR")
	@Column(name="R_TYPE_ID")
	private long rTypeId;

	@Column(name="\"TYPE\"")
	private String type;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="RType")
	private Set<Role> roles;

	public RType() {
	}

	public long getRTypeId() {
		return this.rTypeId;
	}

	public void setRTypeId(long rTypeId) {
		this.rTypeId = rTypeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setRType(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setRType(null);

		return role;
	}

}