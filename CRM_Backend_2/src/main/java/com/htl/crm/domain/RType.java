package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@SequenceGenerator(name="R_TYPE_ID_GENERATOR", sequenceName="R_TYPE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="R_TYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@Column(name="\"TYPE\"", length=500)
	private String type;

	//bi-directional many-to-one association to Relation
	@OneToMany(mappedBy="RType")
	private List<Relation> relations;

	public RType() {
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

	public List<Relation> getRelations() {
		return this.relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

	public Relation addRelation(Relation relation) {
		getRelations().add(relation);
		relation.setRType(this);

		return relation;
	}

	public Relation removeRelation(Relation relation) {
		getRelations().remove(relation);
		relation.setRType(null);

		return relation;
	}

}