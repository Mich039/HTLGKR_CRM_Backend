package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EVENT database table.
 * 
 */
@Entity
@Table(name="EVENT")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENT_ID_GENERATOR", sequenceName="EVENT_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@Column(name="EVENT_NAME", length=500)
	private String eventName;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="ADDRESS_FK", nullable=false)
	private Address address;

	//bi-directional many-to-one association to EventType
	@ManyToOne
	@JoinColumn(name="EVENT_TYPE_FK", nullable=false)
	private EventType eventType;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERSON_FK", nullable=false)
	private Person person;

	//bi-directional many-to-one association to EventInfo
	@OneToMany(mappedBy="event")
	private List<EventInfo> eventInfos;

	public Event() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
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

	public List<EventInfo> getEventInfos() {
		return this.eventInfos;
	}

	public void setEventInfos(List<EventInfo> eventInfos) {
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