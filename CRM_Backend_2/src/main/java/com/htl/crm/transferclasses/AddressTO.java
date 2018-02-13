package com.htl.crm.transferclasses;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AddressTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String city;
	private Date creationDate;
	private BigDecimal doorNumber;
	private String streetAddress;
	
	
	
	
	public AddressTO() {
		super();
	}
	
	
	
	public AddressTO(long id, String city, Date creationDate, BigDecimal doorNumber, String streetAddress) {
		super();
		this.id = id;
		this.city = city;
		this.creationDate = creationDate;
		this.doorNumber = doorNumber;
		this.streetAddress = streetAddress;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public BigDecimal getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(BigDecimal doorNumber) {
		this.doorNumber = doorNumber;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	@Override
	public String toString() {
		return "AdressTO [id=" + id + ", city=" + city + ", creationDate=" + creationDate + ", doorNumber=" + doorNumber
				+ ", streetAddress=" + streetAddress + "]";
	}
	
	
}
