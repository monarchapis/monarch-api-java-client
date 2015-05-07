package com.monarchapis.api.v1.model;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class Token {

	@NotNull
	private String clientId;

	private Optional<String> scheme = Optional.absent();

	@NotNull
	private String token;

	private Optional<String> refreshToken = Optional.absent();

	@NotNull
	private String tokenType;

	@NotNull
	private String grantType;

	private Optional<String> createdDate = Optional.absent();

	private Optional<String> lastAccessedDate = Optional.absent();

	private Optional<Long> expiresIn = Optional.absent();

	@NotNull
	private String lifecycle;

	private Optional<String> userCode = Optional.absent();

	private Optional<String> fromToken = Optional.absent();

	@NotNull
	private Set<String> permissionIds;

	private Optional<String> state = Optional.absent();

	private Optional<String> uri = Optional.absent();

	private Optional<String> userId = Optional.absent();

	private Optional<String> userContext = Optional.absent();

	@NotNull
	private Extended extended;

	private Optional<String> externalId = Optional.absent();

	@NotNull
	private String id;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Optional<String> getScheme() {
		return scheme;
	}

	public void setScheme(Optional<String> scheme) {
		this.scheme = scheme;
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

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public Optional<String> getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Optional<String> createdDate) {
		this.createdDate = createdDate;
	}

	public Optional<String> getLastAccessedDate() {
		return lastAccessedDate;
	}

	public void setLastAccessedDate(Optional<String> lastAccessedDate) {
		this.lastAccessedDate = lastAccessedDate;
	}

	public Optional<Long> getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Optional<Long> expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(String lifecycle) {
		this.lifecycle = lifecycle;
	}

	public Optional<String> getUserCode() {
		return userCode;
	}

	public void setUserCode(Optional<String> userCode) {
		this.userCode = userCode;
	}

	public Optional<String> getFromToken() {
		return fromToken;
	}

	public void setFromToken(Optional<String> fromToken) {
		this.fromToken = fromToken;
	}

	public Set<String> getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(Set<String> permissionIds) {
		this.permissionIds = permissionIds;
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

	public Optional<String> getExternalId() {
		return externalId;
	}

	public void setExternalId(Optional<String> externalId) {
		this.externalId = externalId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
