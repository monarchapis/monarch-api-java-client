package com.monarchapis.api.v1.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class ValueCountsResponse {

	/** The list of aggregate value counts */
	@NotNull
	private List<ValueCount> data;

	private Optional<StringMap> labels = Optional.absent();

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

	public List<ValueCount> getData() {
		return data;
	}

	public void setData(List<ValueCount> data) {
		this.data = data;
	}

	public Optional<StringMap> getLabels() {
		return labels;
	}

	public void setLabels(Optional<StringMap> labels) {
		this.labels = labels;
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
