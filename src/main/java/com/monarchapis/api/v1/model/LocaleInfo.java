package com.monarchapis.api.v1.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class LocaleInfo {

	@NotNull
	private String language;

	private Optional<String> country = Optional.absent();

	private Optional<String> variant = Optional.absent();

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Optional<String> getCountry() {
		return country;
	}

	public void setCountry(Optional<String> country) {
		this.country = country;
	}

	public Optional<String> getVariant() {
		return variant;
	}

	public void setVariant(Optional<String> variant) {
		this.variant = variant;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
