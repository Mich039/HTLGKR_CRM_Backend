package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BILL database table.
 * 
 */
@Entity
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BILL_BILLID_GENERATOR", sequenceName="BILL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BILL_BILLID_GENERATOR")
	@Column(name="BILL_ID")
	private long billId;

	//bi-directional many-to-one association to Template
	@ManyToOne
	private Template template;

	public Bill() {
	}

	public long getBillId() {
		return this.billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public Template getTemplate() {
		return this.template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

}