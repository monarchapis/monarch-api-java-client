package com.monarchapis.api.v1.model;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class AuthorizationRequest {

	@NotNull
	private String authorizationScheme;

	@NotNull
	private String apiKey;

	private Optional<String> callbackUri = Optional.absent();

	@NotNull
	private Set<String> permissions;

	public String getAuthorizationScheme() {
		return authorizationScheme;
	}

	public void setAuthorizationScheme(String authorizationScheme) {
		this.authorizationScheme = authorizationScheme;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public Optional<String> getCallbackUri() {
		return callbackUri;
	}

	public void setCallbackUri(Optional<String> callbackUri) {
		this.callbackUri = callbackUri;
	}

	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
