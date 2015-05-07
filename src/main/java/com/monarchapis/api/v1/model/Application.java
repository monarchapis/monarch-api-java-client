package com.monarchapis.api.v1.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;

import com.google.common.base.Optional;

public class Application {

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

	@NotNull
	private List<String> callbackUris;

	private Optional<String> planId = Optional.absent();

	@NotNull
	private Extended extended;

	private Optional<String> externalId = Optional.absent();

	@NotNull
	private String createdBy;

	@NotNull
	private DateTime createdDate;

	@NotNull
	private String modifiedBy;

	@NotNull
	private DateTime modifiedDate;

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

	public List<String> getCallbackUris() {
		return callbackUris;
	}

	public void setCallbackUris(List<String> callbackUris) {
		this.callbackUris = callbackUris;
	}

	public Optional<String> getPlanId() {
		return planId;
	}

	public void setPlanId(Optional<String> planId) {
		this.planId = planId;
	}

	public Extended getExtended() {
		return extended;
	}

	public void setExtended(Extended extended) {
		this.extended = extended;
	}

	public Optional<String> getExternalId() {
		return externalId;
	}

	public void setExternalId(Optional<String> externalId) {
		this.externalId = externalId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public DateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(DateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
