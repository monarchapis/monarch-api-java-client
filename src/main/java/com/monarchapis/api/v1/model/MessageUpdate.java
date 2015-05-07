package com.monarchapis.api.v1.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class MessageUpdate {

	private Optional<String> parentId = Optional.absent();

	@NotNull
	private String key;

	@NotNull
	private MessageLocales locales;

	@NotNull
	private Integer displayOrder;

	public Optional<String> getParentId() {
		return parentId;
	}

	public void setParentId(Optional<String> parentId) {
		this.parentId = parentId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public MessageLocales getLocales() {
		return locales;
	}

	public void setLocales(MessageLocales locales) {
		this.locales = locales;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
