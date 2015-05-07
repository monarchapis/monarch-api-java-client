package com.monarchapis.api.v1.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class MetricsResponse {

	/** The field type */
	@NotNull
	private String fieldType;

	/** The time unit of the returned data */
	@NotNull
	private String unit;

	/** The number of samples returned */
	@NotNull
	private Long samples;

	/** The list of aggregate data bins */
	@NotNull
	private List<Bin> data;

	@NotNull
	private StringMap labels;

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

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getSamples() {
		return samples;
	}

	public void setSamples(Long samples) {
		this.samples = samples;
	}

	public List<Bin> getData() {
		return data;
	}

	public void setData(List<Bin> data) {
		this.data = data;
	}

	public StringMap getLabels() {
		return labels;
	}

	public void setLabels(StringMap labels) {
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
