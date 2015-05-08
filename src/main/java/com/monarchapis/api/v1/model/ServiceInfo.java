package com.monarchapis.api.v1.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class ServiceInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private Reference environment;

	private Optional<Reference> service = Optional.absent();

	private Optional<Reference> provider = Optional.absent();

	public Reference getEnvironment() {
		return environment;
	}

	public void setEnvironment(Reference environment) {
		this.environment = environment;
	}

	public Optional<Reference> getService() {
		return service;
	}

	public void setService(Optional<Reference> service) {
		this.service = service;
	}

	public Optional<Reference> getProvider() {
		return provider;
	}

	public void setProvider(Optional<Reference> provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
