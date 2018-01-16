package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the EVENT_INFO_TYPE database table.
 * 
 */
@Entity
@Table(name="EVENT_INFO_TYPE")
@NamedQuery(name="EventInfoType.findAll", query="SELECT e FROM EventInfoType e")
public class EventInfoType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENT_INFO_TYPE_EVENTINFOTYPEID_GENERATOR", sequenceName="EVENT_INFO_TYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENT_INFO_TYPE_EVENTINFOTYPEID_GENERATOR")
	@Column(name="EVENT_INFO_TYPE_ID")
	private long eventInfoTypeId;

	@Column(name="\"TYPE\"")
	private String type;

	//bi-directional many-to-one association to EventInfo
	@OneToMany(mappedBy="eventInfoType")
	private Set<EventInfo> eventInfos;

	public EventInfoType() {
	}

	public long getEventInfoTypeId() {
		return this.eventInfoTypeId;
	}

	public void setEventInfoTypeId(long eventInfoTypeId) {
		this.eventInfoTypeId = eventInfoTypeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<EventInfo> getEventInfos() {
		return this.eventInfos;
	}

	public void setEventInfos(Set<EventInfo> eventInfos) {
		this.eventInfos = eventInfos;
	}

	public EventInfo addEventInfo(EventInfo eventInfo) {
		getEventInfos().add(eventInfo);
		eventInfo.setEventInfoType(this);

		return eventInfo;
	}

	public EventInfo removeEventInfo(EventInfo eventInfo) {
		getEventInfos().remove(eventInfo);
		eventInfo.setEventInfoType(null);

		return eventInfo;
	}

}