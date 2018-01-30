package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the P_ROLE database table.
 * 
 */
@Entity
@Table(name="P_ROLE")
@NamedQuery(name="PRole.findAll", query="SELECT p FROM PRole p")
public class PRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="P_ROLE_ID_GENERATOR", sequenceName="P_ROLE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="P_ROLE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@Column(name="ROLE_TEXT", length=500)
	private String roleText;

	//bi-directional many-to-one association to AccessRightPRole
	@OneToMany(mappedBy="PRole")
	private List<AccessRightPRole> accessRightPRoles;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="PRole")
	private List<Person> persons;

	public PRole() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleText() {
		return this.roleText;
	}

	public void setRoleText(String roleText) {
		this.roleText = roleText;
	}

	public List<AccessRightPRole> getAccessRightPRoles() {
		return this.accessRightPRoles;
	}

	public void setAccessRightPRoles(List<AccessRightPRole> accessRightPRoles) {
		this.accessRightPRoles = accessRightPRoles;
	}

	public AccessRightPRole addAccessRightPRole(AccessRightPRole accessRightPRole) {
		getAccessRightPRoles().add(accessRightPRole);
		accessRightPRole.setPRole(this);

		return accessRightPRole;
	}

	public AccessRightPRole removeAccessRightPRole(AccessRightPRole accessRightPRole) {
		getAccessRightPRoles().remove(accessRightPRole);
		accessRightPRole.setPRole(null);

		return accessRightPRole;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setPRole(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setPRole(null);

		return person;
	}

}