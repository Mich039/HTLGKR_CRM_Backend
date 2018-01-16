package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


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
	@SequenceGenerator(name="ACCESS_RIGHT_ACCESSRIGHTID_GENERATOR", sequenceName="ACCESS_RIGHT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCESS_RIGHT_ACCESSRIGHTID_GENERATOR")
	@Column(name="ACCESS_RIGHT_ID")
	private long accessRightId;

	@Column(name="ACCESS_RIGHT")
	private String accessRight;

	//bi-directional many-to-one association to ArPr
	@OneToMany(mappedBy="accessRight")
	private Set<ArPr> arPrs;

	public AccessRight() {
	}

	public long getAccessRightId() {
		return this.accessRightId;
	}

	public void setAccessRightId(long accessRightId) {
		this.accessRightId = accessRightId;
	}

	public String getAccessRight() {
		return this.accessRight;
	}

	public void setAccessRight(String accessRight) {
		this.accessRight = accessRight;
	}

	public Set<ArPr> getArPrs() {
		return this.arPrs;
	}

	public void setArPrs(Set<ArPr> arPrs) {
		this.arPrs = arPrs;
	}

	public ArPr addArPr(ArPr arPr) {
		getArPrs().add(arPr);
		arPr.setAccessRight(this);

		return arPr;
	}

	public ArPr removeArPr(ArPr arPr) {
		getArPrs().remove(arPr);
		arPr.setAccessRight(null);

		return arPr;
	}

}