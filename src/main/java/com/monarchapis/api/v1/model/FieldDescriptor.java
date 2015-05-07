package com.monarchapis.api.v1.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class FieldDescriptor {

	/** The event field name */
	@NotNull
	private String name;

	/**
	 * The event field name formatted for display purposes (e.g. capitalization,
	 * spacing)
	 */
	@NotNull
	private String display;

	/** The event field type */
	@NotNull
	private String type;

	/** How the event field is used */
	@NotNull
	private String usage;

	/** Flag that denotes if the field is required */
	@NotNull
	private Boolean required;

	/**
	 * An optional default value for the field if it is not provided in the
	 * create operation
	 */
	private Optional<String> defaultValue = Optional.absent();

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public Boolean isRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Optional<String> getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Optional<String> defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
