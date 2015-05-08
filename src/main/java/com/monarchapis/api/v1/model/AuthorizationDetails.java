package com.monarchapis.api.v1.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AuthorizationDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private ClientDetails client;

	@NotNull
	private ApplicationDetails application;

	@NotNull
	private List<PermissionDetails> permissions;

	public ClientDetails getClient() {
		return client;
	}

	public void setClient(ClientDetails client) {
		this.client = client;
	}

	public ApplicationDetails getApplication() {
		return application;
	}

	public void setApplication(ApplicationDetails application) {
		this.application = application;
	}

	public List<PermissionDetails> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionDetails> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
