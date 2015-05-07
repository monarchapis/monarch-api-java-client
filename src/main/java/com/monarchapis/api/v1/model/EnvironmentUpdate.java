package com.monarchapis.api.v1.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class EnvironmentUpdate {

	@NotNull
	private String name;

	private Optional<String> description = Optional.absent();

	@NotNull
	private String systemDatabase;

	@NotNull
	private String analyticsDatabase;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Optional<String> getDescription() {
		return description;
	}

	public void setDescription(Optional<String> description) {
		this.description = description;
	}

	public String getSystemDatabase() {
		return systemDatabase;
	}

	public void setSystemDatabase(String systemDatabase) {
		this.systemDatabase = systemDatabase;
	}

	public String getAnalyticsDatabase() {
		return analyticsDatabase;
	}

	public void setAnalyticsDatabase(String analyticsDatabase) {
		this.analyticsDatabase = analyticsDatabase;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
