package com.monarchapis.api.v1.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class ProviderUpdate implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String label;

	@NotNull
	private Boolean enabled;

	@NotNull
	private String apiKey;

	private Optional<String> sharedSecret = Optional.absent();

	@NotNull
	private Authenticators authenticators;

	@NotNull
	private List<Configuration> policies;

	@NotNull
	private Set<String> permissions;

	@NotNull
	private StringMap accessLevels;

	@NotNull
	private Boolean behindReverseProxy;

	@NotNull
	private Extended extended;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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

	public Authenticators getAuthenticators() {
		return authenticators;
	}

	public void setAuthenticators(Authenticators authenticators) {
		this.authenticators = authenticators;
	}

	public List<Configuration> getPolicies() {
		return policies;
	}

	public void setPolicies(List<Configuration> policies) {
		this.policies = policies;
	}

	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

	public StringMap getAccessLevels() {
		return accessLevels;
	}

	public void setAccessLevels(StringMap accessLevels) {
		this.accessLevels = accessLevels;
	}

	public Boolean isBehindReverseProxy() {
		return behindReverseProxy;
	}

	public void setBehindReverseProxy(Boolean behindReverseProxy) {
		this.behindReverseProxy = behindReverseProxy;
	}

	public Extended getExtended() {
		return extended;
	}

	public void setExtended(Extended extended) {
		this.extended = extended;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
