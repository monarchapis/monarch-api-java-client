package com.monarchapis.api.v1.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class Bin {

	/** The date/time of the sample bin */
	@NotNull
	private String time;

	private Optional<BinValue> value = Optional.absent();

	private Optional<LongMap> counts = Optional.absent();

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Optional<BinValue> getValue() {
		return value;
	}

	public void setValue(Optional<BinValue> value) {
		this.value = value;
	}

	public Optional<LongMap> getCounts() {
		return counts;
	}

	public void setCounts(Optional<LongMap> counts) {
		this.counts = counts;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
