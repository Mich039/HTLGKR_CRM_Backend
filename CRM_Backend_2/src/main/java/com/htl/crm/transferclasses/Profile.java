package com.htl.crm.transferclasses;

import java.io.Serializable;
import java.util.LinkedList;

public class Profile implements Serializable{
	private String firstname;
	private String lastname;
	private LinkedList<TodoTrClass> todolist;
	
	public Profile() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public LinkedList<TodoTrClass> getTodolist() {
		return todolist;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setTodolist(LinkedList<TodoTrClass> todolist) {
		this.todolist = todolist;
	}
	
	//@Override
	public String String() {
		return "{firstname:"+firstname+",lastname:"+lastname+",todolist:"+todolist;
	}
}
