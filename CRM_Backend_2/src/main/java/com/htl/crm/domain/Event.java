package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the EVENT database table.
 * 
 */
@Entity
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENT_EVENTID_GENERATOR", sequenceName="EVENT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENT_EVENTID_GENERATOR")
	@Column(name="EVENT_ID")
	private long eventId;

	private String eventname;

	//bi-directional many-to-one association to Address
	@ManyToOne
	private Address address;

	//bi-directional many-to-one association to EventType
	@ManyToOne
	@JoinColumn(name="EVENT_TYPE_EVENT_TYPE_ID")
	private EventType eventType;

	//bi-directional many-to-one association to Person
	@ManyToOne
	private Person person;

	//bi-directional many-to-one association to EventInfo
	@OneToMany(mappedBy="event")
	private Set<EventInfo> eventInfos;

	public Event() {
	}

	public long getEventId() {
		return this.eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getEventname() {
		return this.eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public EventType getEventType() {
		return this.eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Set<EventInfo> getEventInfos() {
		return this.eventInfos;
	}

	public void setEventInfos(Set<EventInfo> eventInfos) {
		this.eventInfos = eventInfos;
	}

	public EventInfo addEventInfo(EventInfo eventInfo) {
		getEventInfos().add(eventInfo);
		eventInfo.setEvent(this);

		return eventInfo;
	}

	public EventInfo removeEventInfo(EventInfo eventInfo) {
		getEventInfos().remove(eventInfo);
		eventInfo.setEvent(null);

		return eventInfo;
	}

}