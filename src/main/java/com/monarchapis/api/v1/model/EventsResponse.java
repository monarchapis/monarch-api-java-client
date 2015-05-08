package com.monarchapis.api.v1.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class EventsResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	/** The number of samples returned */
	@NotNull
	private Long samples;

	/** The list of matched events */
	@NotNull
	private List<ObjectData> events;

	/** The start date/time of the data returned */
	@NotNull
	private String start;

	/** The end date/time of the data returned */
	@NotNull
	private String end;

	/** The timezone offset in milliseconds to UTC */
	@NotNull
	private Integer timezoneOffset;

	/** The value of the query if provided in the request */
	private Optional<String> query = Optional.absent();

	public Long getSamples() {
		return samples;
	}

	public void setSamples(Long samples) {
		this.samples = samples;
	}

	public List<ObjectData> getEvents() {
		return events;
	}

	public void setEvents(List<ObjectData> events) {
		this.events = events;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Integer getTimezoneOffset() {
		return timezoneOffset;
	}

	public void setTimezoneOffset(Integer timezoneOffset) {
		this.timezoneOffset = timezoneOffset;
	}

	public Optional<String> getQuery() {
		return query;
	}

	public void setQuery(Optional<String> query) {
		this.query = query;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
