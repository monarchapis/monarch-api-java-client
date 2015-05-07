package com.monarchapis.api.v1.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class ClientAuthenticationRequest {

	@NotNull
	private String authorizationScheme;

	@NotNull
	private String apiKey;

	private Optional<String> sharedSecret = Optional.absent();

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

	public Optional<String> getSharedSecret() {
		return sharedSecret;
	}

	public void setSharedSecret(Optional<String> sharedSecret) {
		this.sharedSecret = sharedSecret;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
