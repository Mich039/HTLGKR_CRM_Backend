package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.util.LinkedList;
import java.util.List;

/**
 * The persistent class for the PERSON database table.
 * 
 */
@Entity
@Table(name = "PERSON")
@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PERSON_ID_GENERATOR", sequenceName = "PERSON_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_ID_GENERATOR")
	@Column(unique = true, nullable = false, precision = 22)
	private long id;

	// bi-directional many-to-one association to Addresshistorie
	@OneToMany(mappedBy = "person")
	private List<Addresshistorie> addresshistories;

	// bi-directional many-to-one association to Event
	@OneToMany(mappedBy = "person")
	private List<Event> events;

	// bi-directional many-to-one association to Event
	@OneToMany(mappedBy = "person")
	private List<EventPerson> eventpersons;

	// bi-directional many-to-one association to PRole
	@ManyToOne
	@JoinColumn(name = "P_ROLE_FK", nullable = false)
	private PRole PRole;

	// bi-directional many-to-one association to Relation
	@ManyToOne
	@JoinColumn(name = "RELATION_FK", nullable = false)
	private Relation relation;

	// bi-directional many-to-one association to PersonTodo
	@OneToMany(mappedBy = "person")
	private List<PersonTodo> personTodos;

	// bi-directional many-to-one association to PData
	@OneToMany(mappedBy = "person")
	private List<PData> PData;

	// bi-directional many-to-one association to Receiver
	@OneToMany(mappedBy = "person")
	private List<Receiver> receivers;

	// bi-directional many-to-one association to Relation
	@OneToMany(mappedBy = "person")
	private List<Relation> relations;

	// bi-directional many-to-one association to Template
	@OneToMany(mappedBy = "person")
	private List<Template> templates;

	public Person() {
		PData = new LinkedList<PData>();
		personTodos = new LinkedList<PersonTodo>();
		receivers = new LinkedList<Receiver>();
		relations = new LinkedList<>();
		templates = new LinkedList<>();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Addresshistorie> getAddresshistories() {
		return this.addresshistories;
	}

	public void setAddresshistories(List<Addresshistorie> addresshistories) {
		this.addresshistories = addresshistories;
	}

	public Addresshistorie addAddresshistory(Addresshistorie addresshistory) {
		getAddresshistories().add(addresshistory);
		addresshistory.setPerson(this);

		return addresshistory;
	}

	public Addresshistorie removeAddresshistory(Addresshistorie addresshistory) {
		getAddresshistories().remove(addresshistory);
		addresshistory.setPerson(null);

		return addresshistory;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setPerson(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setPerson(null);

		return event;
	}

	public PRole getPRole() {
		return this.PRole;
	}

	public void setPRole(PRole PRole) {
		this.PRole = PRole;
	}

	public Relation getRelation() {
		return this.relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public List<PersonTodo> getPersonTodos() {
		return this.personTodos;
	}

	public void setPersonTodos(List<PersonTodo> personTodos) {
		this.personTodos = personTodos;
	}

	public PersonTodo addPersonTodo(PersonTodo personTodo) {
		getPersonTodos().add(personTodo);
		personTodo.setPerson(this);

		return personTodo;
	}

	public PersonTodo removePersonTodo(PersonTodo personTodo) {
		getPersonTodos().remove(personTodo);
		personTodo.setPerson(null);

		return personTodo;
	}

	public List<PData> getPData() {
		return this.PData;
	}

	public void setPData(List<PData> PData) {
		this.PData = PData;
	}

	public PData addPData(PData PData) {
		getPData().add(PData);
		PData.setPerson(this);

		return PData;
	}

	public PData removePData(PData PData) {
		getPData().remove(PData);
		PData.setPerson(null);

		return PData;
	}

	public List<Receiver> getReceivers() {
		return this.receivers;
	}

	public void setReceivers(List<Receiver> receivers) {
		this.receivers = receivers;
	}

	public Receiver addReceiver(Receiver receiver) {
		getReceivers().add(receiver);
		receiver.setPerson(this);

		return receiver;
	}

	public Receiver removeReceiver(Receiver receiver) {
		getReceivers().remove(receiver);
		receiver.setPerson(null);

		return receiver;
	}

	public List<Relation> getRelations() {
		return this.relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

	public Relation addRelation(Relation relation) {
		getRelations().add(relation);
		relation.setPerson(this);

		return relation;
	}

	public Relation removeRelation(Relation relation) {
		getRelations().remove(relation);
		relation.setPerson(null);

		return relation;
	}

	public List<Template> getTemplates() {
		return this.templates;
	}

	public void setTemplates(List<Template> templates) {
		this.templates = templates;
	}

	public Template addTemplate(Template template) {
		getTemplates().add(template);
		template.setPerson(this);

		return template;
	}

	public Template removeTemplate(Template template) {
		getTemplates().remove(template);
		template.setPerson(null);

		return template;
	}

	public PData getPDataFromType(String type) {
		for (PData pdata : this.PData) {
			if (pdata.getPDatatype().getType().equals(type)) {
				return pdata;
			}
		}
		return null;
	}

	public List<EventPerson> getEventpersons() {
		return eventpersons;
	}

	public void setEventpersons(List<EventPerson> eventpersons) {
		this.eventpersons = eventpersons;
	}

	
	
}