package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BILL database table.
 * 
 */
@Entity
@Table(name="BILL")
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BILL_ID_GENERATOR", sequenceName="BILL_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BILL_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	//bi-directional many-to-one association to Template
	@ManyToOne
	@JoinColumn(name="TEMPLATE_FK", nullable=false)
	private Template template;

	public Bill() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Template getTemplate() {
		return this.template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

}