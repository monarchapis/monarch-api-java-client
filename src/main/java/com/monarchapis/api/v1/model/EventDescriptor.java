package com.monarchapis.api.v1.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class EventDescriptor {

	/** The event name */
	@NotNull
	private String name;

	/**
	 * The event name formatted for display purposes (e.g. capitalization,
	 * spacing)
	 */
	@NotNull
	private String display;

	/** The name of the time zone that the events are being stored in */
	@NotNull
	private String timezone;

	/** The list of fields that comprise the event */
	@NotNull
	private List<FieldDescriptor> fields;

	/** The list of database indexes on the event */
	@NotNull
	private List<Index> indexes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public List<FieldDescriptor> getFields() {
		return fields;
	}

	public void setFields(List<FieldDescriptor> fields) {
		this.fields = fields;
	}

	public List<Index> getIndexes() {
		return indexes;
	}

	public void setIndexes(List<Index> indexes) {
		this.indexes = indexes;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
