package com.monarchapis.api.v1.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class PrincipalContext {

	@NotNull
	private String id;

	private Optional<String> context = Optional.absent();

	@NotNull
	private ClaimsMap claims;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Optional<String> getContext() {
		return context;
	}

	public void setContext(Optional<String> context) {
		this.context = context;
	}

	public ClaimsMap getClaims() {
		return claims;
	}

	public void setClaims(ClaimsMap claims) {
		this.claims = claims;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
