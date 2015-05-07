package com.monarchapis.api.v1.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class VariableContext {

	@NotNull
	private String providerId;

	@NotNull
	private String serviceId;

	private Optional<String> serviceVersion = Optional.absent();

	@NotNull
	private String operation;

	@NotNull
	private StringMap pathParameters;

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Optional<String> getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceVersion(Optional<String> serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public StringMap getPathParameters() {
		return pathParameters;
	}

	public void setPathParameters(StringMap pathParameters) {
		this.pathParameters = pathParameters;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
