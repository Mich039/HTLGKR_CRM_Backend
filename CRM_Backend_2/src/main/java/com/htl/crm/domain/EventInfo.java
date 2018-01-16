package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the EVENT_INFO database table.
 * 
 */
@Entity
@Table(name="EVENT_INFO")
@NamedQuery(name="EventInfo.findAll", query="SELECT e FROM EventInfo e")
public class EventInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENT_INFO_EVENTINFOID_GENERATOR", sequenceName="EVENT_INFO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENT_INFO_EVENTINFOID_GENERATOR")
	@Column(name="EVENT_INFO_ID")
	private long eventInfoId;

	@Column(name="\"VALUE\"")
	private BigDecimal value;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="EVENT_ID")
	private Event event;

	//bi-directional many-to-one association to EventInfoType
	@ManyToOne
	@JoinColumn(name="EVENT_INFO_TYPE_ID")
	private EventInfoType eventInfoType;

	public EventInfo() {
	}

	public long getEventInfoId() {
		return this.eventInfoId;
	}

	public void setEventInfoId(long eventInfoId) {
		this.eventInfoId = eventInfoId;
	}

	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public EventInfoType getEventInfoType() {
		return this.eventInfoType;
	}

	public void setEventInfoType(EventInfoType eventInfoType) {
		this.eventInfoType = eventInfoType;
	}

}