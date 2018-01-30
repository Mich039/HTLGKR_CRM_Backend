package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the P_DATA database table.
 * 
 */
@Entity
@Table(name="P_DATA")
@NamedQuery(name="PData.findAll", query="SELECT p FROM PData p")
public class PData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="P_DATA_ID_GENERATOR", sequenceName="P_DATA_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="P_DATA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@Column(name="\"VALUE\"", length=500)
	private String value;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERSON_FK", nullable=false)
	private Person person;

	//bi-directional many-to-one association to PDatatype
	@ManyToOne
	@JoinColumn(name="P_DATATYPE_FK", nullable=false)
	private PDatatype PDatatype;

	public PData() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PDatatype getPDatatype() {
		return this.PDatatype;
	}

	public void setPDatatype(PDatatype PDatatype) {
		this.PDatatype = PDatatype;
	}

}