package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PERSON_TODO database table.
 * 
 */
@Entity
@Table(name="PERSON_TODO")
@NamedQuery(name="PersonTodo.findAll", query="SELECT p FROM PersonTodo p")
public class PersonTodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSON_TODO_ID_GENERATOR", sequenceName="PERSON_TODO_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSON_TODO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERSON_FK", nullable=false)
	private Person person;

	//bi-directional many-to-one association to Todo
	@ManyToOne
	@JoinColumn(name="TODO_FK", nullable=false)
	private Todo todo;

	public PersonTodo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Todo getTodo() {
		return this.todo;
	}

	public void setTodo(Todo todo) {
		this.todo = todo;
	}

}