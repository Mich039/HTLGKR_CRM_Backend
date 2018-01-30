package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@SequenceGenerator(name="P_DATATYPE_ID_GENERATOR", sequenceName="P_DATATYPE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="P_DATATYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@Column(name="\"TYPE\"", length=500)
	private String type;

	//bi-directional many-to-one association to PData
	@OneToMany(mappedBy="PDatatype")
	private List<PData> PData;

	public PDatatype() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<PData> getPData() {
		return this.PData;
	}

	public void setPData(List<PData> PData) {
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