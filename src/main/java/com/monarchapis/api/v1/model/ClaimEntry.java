package com.monarchapis.api.v1.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class ClaimEntry {

	@NotNull
	private String type;

	private Optional<String> value = Optional.absent();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Optional<String> getValue() {
		return value;
	}

	public void setValue(Optional<String> value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
