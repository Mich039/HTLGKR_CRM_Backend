package com.htl.crm.transferclasses;

import java.io.Serializable;

public class PersonData implements Serializable {

	private String datatype;
	private String value;
	public String getDatatype() {
		return datatype;
	}
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public PersonData(String datatype, String value) {
		super();
		this.datatype = datatype;
		this.value = value;
	}
	public PersonData() {
		
	}
}
