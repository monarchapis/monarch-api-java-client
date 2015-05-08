package com.monarchapis.api.v1.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Index implements Serializable {
	private static final long serialVersionUID = 1L;

	/** The name of the index */
	@NotNull
	private String name;

	/** The list of field names included in the index, in order */
	@NotNull
	private List<String> on;

	/**
	 * Flag that denotes if the index is has a constraint on storing only unique
	 * values
	 */
	@NotNull
	private Boolean unique;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getOn() {
		return on;
	}

	public void setOn(List<String> on) {
		this.on = on;
	}

	public Boolean isUnique() {
		return unique;
	}

	public void setUnique(Boolean unique) {
		this.unique = unique;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
