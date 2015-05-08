package com.monarchapis.api.v1.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MessageDetailsList implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private List<MessageDetails> items;

	public List<MessageDetails> getItems() {
		return items;
	}

	public void setItems(List<MessageDetails> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
