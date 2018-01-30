package com.htl.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@SequenceGenerator(name="EVENT_INFO_TYPE_ID_GENERATOR", sequenceName="EVENT_INFO_TYPE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENT_INFO_TYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@Column(name="\"TYPE\"", length=500)
	private String type;

	//bi-directional many-to-one association to EventInfo
	@OneToMany(mappedBy="eventInfoType")
	private List<EventInfo> eventInfos;

	public EventInfoType() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<EventInfo> getEventInfos() {
		return this.eventInfos;
	}

	public void setEventInfos(List<EventInfo> eventInfos) {
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