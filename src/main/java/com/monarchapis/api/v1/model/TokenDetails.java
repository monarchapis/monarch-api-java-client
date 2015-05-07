package com.monarchapis.api.v1.model;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class TokenDetails {

	@NotNull
	private String id;

	@NotNull
	private String token;

	private Optional<String> refreshToken = Optional.absent();

	private Optional<Long> expiresIn = Optional.absent();

	@NotNull
	private String grantType;

	@NotNull
	private String tokenType;

	@NotNull
	private Set<String> permissions;

	private Optional<String> state = Optional.absent();

	private Optional<String> uri = Optional.absent();

	private Optional<String> userId = Optional.absent();

	private Optional<String> userContext = Optional.absent();

	@NotNull
	private Extended extended;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Optional<String> getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(Optional<String> refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Optional<Long> getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Optional<Long> expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

	public Optional<String> getState() {
		return state;
	}

	public void setState(Optional<String> state) {
		this.state = state;
	}

	public Optional<String> getUri() {
		return uri;
	}

	public void setUri(Optional<String> uri) {
		this.uri = uri;
	}

	public Optional<String> getUserId() {
		return userId;
	}

	public void setUserId(Optional<String> userId) {
		this.userId = userId;
	}

	public Optional<String> getUserContext() {
		return userContext;
	}

	public void setUserContext(Optional<String> userContext) {
		this.userContext = userContext;
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
