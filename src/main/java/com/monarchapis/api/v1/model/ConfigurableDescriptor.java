package com.monarchapis.api.v1.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class ConfigurableDescriptor implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String name;

	private Optional<List<PropertyDescriptor>> properties = Optional.absent();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Optional<List<PropertyDescriptor>> getProperties() {
		return properties;
	}

	public void setProperties(Optional<List<PropertyDescriptor>> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
