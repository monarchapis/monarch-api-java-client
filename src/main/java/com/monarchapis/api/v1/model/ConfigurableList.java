package com.monarchapis.api.v1.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ConfigurableList implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private List<ConfigurableDescriptor> items;

	public List<ConfigurableDescriptor> getItems() {
		return items;
	}

	public void setItems(List<ConfigurableDescriptor> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
