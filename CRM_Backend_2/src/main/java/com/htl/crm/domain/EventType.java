package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EVENT_TYPE database table.
 * 
 */
@Entity
@Table(name="EVENT_TYPE")
@NamedQuery(name="EventType.findAll", query="SELECT e FROM EventType e")
public class EventType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENT_TYPE_EVENTTYPEID_GENERATOR", sequenceName="EVENT_TYPE_EVENT_TYPE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENT_TYPE_EVENTTYPEID_GENERATOR")
	@Column(name="EVENT_TYPE_ID", unique=true, nullable=false, precision=22)
	private long eventTypeId;

	@Column(name="\"TYPE\"", length=500)
	private String type;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="eventType")
	private List<Event> events;

	public EventType() {
	}

	public long getEventTypeId() {
		return this.eventTypeId;
	}

	public void setEventTypeId(long eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setEventType(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setEventType(null);

		return event;
	}

}