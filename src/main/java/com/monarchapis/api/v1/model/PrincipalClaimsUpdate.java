package com.monarchapis.api.v1.model;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PrincipalClaimsUpdate {

	@NotNull
	private String profileId;

	@NotNull
	private String name;

	@NotNull
	private Set<String> inherits;

	@NotNull
	private ClaimsMap claims;

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getInherits() {
		return inherits;
	}

	public void setInherits(Set<String> inherits) {
		this.inherits = inherits;
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
