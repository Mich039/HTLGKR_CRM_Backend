package com.htl.crm.transferclasses;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class TodoTrClass implements Serializable{
	
	private long id;
	
	private Date creationDatetime;

	private Boolean done;

	private Date finishedDatetime;

	private String text;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the creationDatetime
	 */
	public Date getCreationDatetime() {
		return creationDatetime;
	}

	/**
	 * @param creationDatetime the creationDatetime to set
	 */
	public void setCreationDatetime(Date creationDatetime) {
		this.creationDatetime = creationDatetime;
	}

	/**
	 * @return the done
	 */
	public Boolean getDone() {
		return done;
	}

	/**
	 * @param done the done to set
	 */
	public void setDone(Boolean done) {
		this.done = done;
	}

	/**
	 * @return the finishedDatetime
	 */
	public Date getFinishedDatetime() {
		return finishedDatetime;
	}

	/**
	 * @param finishedDatetime the finishedDatetime to set
	 */
	public void setFinishedDatetime(Date finishedDatetime) {
		this.finishedDatetime = finishedDatetime;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	public TodoTrClass(long id, Date creationDatetime, Boolean done, Date finishedDatetime, String text) {
		super();
		this.id = id;
		this.creationDatetime = creationDatetime;
		this.done = done;
		this.finishedDatetime = finishedDatetime;
		this.text = text;
	}
	
	public TodoTrClass() {}
}
