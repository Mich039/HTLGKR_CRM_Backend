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
	@SequenceGenerator(name="EVENT_INFO_ID_GENERATOR", sequenceName="EVENT_INFO_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENT_INFO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@Column(name="\"VALUE\"", precision=22)
	private BigDecimal value;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="EVENT_INFO_FK", nullable=false)
	private Event event;

	//bi-directional many-to-one association to EventInfoType
	@ManyToOne
	@JoinColumn(name="EVENT_INFO_TYPE_FK", nullable=false)
	private EventInfoType eventInfoType;

	public EventInfo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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