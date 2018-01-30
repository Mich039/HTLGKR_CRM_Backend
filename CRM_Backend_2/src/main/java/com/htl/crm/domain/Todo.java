package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TODO database table.
 * 
 */
@Entity
@Table(name="TODO")
@NamedQuery(name="Todo.findAll", query="SELECT t FROM Todo t")
public class Todo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TODO_ID_GENERATOR", sequenceName="TODO_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TODO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATETIME")
	private Date creationDatetime;

	@Column(nullable=false, length=1)
	private Boolean done;

	@Temporal(TemporalType.DATE)
	@Column(name="FINISHED_DATETIME")
	private Date finishedDatetime;

	@Column(length=2000)
	private String text;

	//bi-directional many-to-one association to PersonTodo
	@OneToMany(mappedBy="todo")
	private List<PersonTodo> personTodos;

	public Todo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreationDatetime() {
		return this.creationDatetime;
	}

	public void setCreationDatetime(Date creationDatetime) {
		this.creationDatetime = creationDatetime;
	}

	
	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public Date getFinishedDatetime() {
		return this.finishedDatetime;
	}

	public void setFinishedDatetime(Date finishedDatetime) {
		this.finishedDatetime = finishedDatetime;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<PersonTodo> getPersonTodos() {
		return this.personTodos;
	}

	public void setPersonTodos(List<PersonTodo> personTodos) {
		this.personTodos = personTodos;
	}

	public PersonTodo addPersonTodo(PersonTodo personTodo) {
		getPersonTodos().add(personTodo);
		personTodo.setTodo(this);

		return personTodo;
	}

	public PersonTodo removePersonTodo(PersonTodo personTodo) {
		getPersonTodos().remove(personTodo);
		personTodo.setTodo(null);

		return personTodo;
	}

}