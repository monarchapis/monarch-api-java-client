package com.monarchapis.api.v1.model;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Operation implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String name;

	@NotNull
	private String method;

	@NotNull
	private String uriPattern;

	@NotNull
	private Set<String> clientPermissionIds;

	@NotNull
	private Set<String> delegatedPermissionIds;

	@NotNull
	private Set<ClaimEntry> claims;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUriPattern() {
		return uriPattern;
	}

	public void setUriPattern(String uriPattern) {
		this.uriPattern = uriPattern;
	}

	public Set<String> getClientPermissionIds() {
		return clientPermissionIds;
	}

	public void setClientPermissionIds(Set<String> clientPermissionIds) {
		this.clientPermissionIds = clientPermissionIds;
	}

	public Set<String> getDelegatedPermissionIds() {
		return delegatedPermissionIds;
	}

	public void setDelegatedPermissionIds(Set<String> delegatedPermissionIds) {
		this.delegatedPermissionIds = delegatedPermissionIds;
	}

	public Set<ClaimEntry> getClaims() {
		return claims;
	}

	public void setClaims(Set<ClaimEntry> claims) {
		this.claims = claims;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
