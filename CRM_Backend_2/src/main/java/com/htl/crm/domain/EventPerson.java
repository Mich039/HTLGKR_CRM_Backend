package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EVENT_PERSON database table.
 * 
 */
@Entity
@Table(name="EVENT_PERSON")
@NamedQuery(name="EventPerson.findAll", query="SELECT e FROM EventPerson e")
public class EventPerson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENT_PERSON_ID_GENERATOR", sequenceName="EVENT_PERSON_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENT_PERSON_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@ManyToOne
	@JoinColumn(name="EVENT_FK", nullable=false)
	private Event event;

	@ManyToOne
	@JoinColumn(name="PERSON_FK", nullable=false)
	private Person person;

	public EventPerson() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}



}