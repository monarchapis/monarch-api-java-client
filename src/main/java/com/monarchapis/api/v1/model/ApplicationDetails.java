package com.monarchapis.api.v1.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class ApplicationDetails {

	@NotNull
	private String id;

	@NotNull
	private String name;

	private Optional<String> description = Optional.absent();

	@NotNull
	private String applicationUrl;

	private Optional<String> applicationImageUrl = Optional.absent();

	@NotNull
	private String companyName;

	@NotNull
	private String companyUrl;

	private Optional<String> companyImageUrl = Optional.absent();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getApplicationUrl() {
		return applicationUrl;
	}

	public void setApplicationUrl(String applicationUrl) {
		this.applicationUrl = applicationUrl;
	}

	public Optional<String> getApplicationImageUrl() {
		return applicationImageUrl;
	}

	public void setApplicationImageUrl(Optional<String> applicationImageUrl) {
		this.applicationImageUrl = applicationImageUrl;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyUrl() {
		return companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public Optional<String> getCompanyImageUrl() {
		return companyImageUrl;
	}

	public void setCompanyImageUrl(Optional<String> companyImageUrl) {
		this.companyImageUrl = companyImageUrl;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
