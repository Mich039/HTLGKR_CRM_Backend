package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the P_DATATYPE database table.
 * 
 */
@Entity
@Table(name="P_DATATYPE")
@NamedQuery(name="PDatatype.findAll", query="SELECT p FROM PDatatype p")
public class PDatatype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="P_DATATYPE_PDATATYPEID_GENERATOR", sequenceName="P_DATATYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="P_DATATYPE_PDATATYPEID_GENERATOR")
	@Column(name="P_DATATYPE_ID")
	private long pDatatypeId;

	@Column(name="\"TYPE\"")
	private String type;

	//bi-directional many-to-one association to PData
	@OneToMany(mappedBy="PDatatype")
	private Set<PData> PData;

	public PDatatype() {
	}

	public long getPDatatypeId() {
		return this.pDatatypeId;
	}

	public void setPDatatypeId(long pDatatypeId) {
		this.pDatatypeId = pDatatypeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<PData> getPData() {
		return this.PData;
	}

	public void setPData(Set<PData> PData) {
		this.PData = PData;
	}

	public PData addPData(PData PData) {
		getPData().add(PData);
		PData.setPDatatype(this);

		return PData;
	}

	public PData removePData(PData PData) {
		getPData().remove(PData);
		PData.setPDatatype(null);

		return PData;
	}

}