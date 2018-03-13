package com.htl.crm.transferclasses;

import java.io.Serializable;
import java.util.Date;

public class ConversationTO implements Serializable{
	
	private String time_added;
	private String person_company;
	private String person_school;
	private String conversation_content;
	public String getTime_added() {
		return time_added;
	}
	public void setTime_added(String time_added) {
		this.time_added = time_added;
	}
	public String getPerson_company() {
		return person_company;
	}
	public void setPerson_company(String person_company) {
		this.person_company = person_company;
	}
	public String getPerson_school() {
		return person_school;
	}
	public void setPerson_school(String person_school) {
		this.person_school = person_school;
	}
	public String getConversation_content() {
		return conversation_content;
	}
	public void setConversation_content(String conversation_content) {
		this.conversation_content = conversation_content;
	}
	/**
	 * @param time_added
	 * @param person_company
	 * @param person_school
	 * @param conversation_content
	 */
	public ConversationTO(String time_added, String person_company, String person_school, String conversation_content) {
		super();
		this.time_added = time_added;
		this.person_company = person_company;
		this.person_school = person_school;
		this.conversation_content = conversation_content;
	}

	
	public ConversationTO() {
		super();
	}
	
}
