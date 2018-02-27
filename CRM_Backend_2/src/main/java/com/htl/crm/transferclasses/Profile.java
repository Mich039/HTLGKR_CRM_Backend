package com.htl.crm.transferclasses;

import java.io.Serializable;
import java.util.LinkedList;

public class Profile implements Serializable{
	private String firstname;
	private String lastname;
	private LinkedList<String> todolist;
	
	public Profile() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public LinkedList<String> getTodolist() {
		return todolist;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setTodolist(LinkedList<String> todolist) {
		this.todolist = todolist;
	}
}
