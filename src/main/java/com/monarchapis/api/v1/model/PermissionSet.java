package com.monarchapis.api.v1.model;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class PermissionSet implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private Boolean enabled;

	@NotNull
	private Boolean global;

	private Optional<Long> expiration = Optional.absent();

	@NotNull
	private String lifespan;

	@NotNull
	private Boolean refreshable;

	@NotNull
	private Set<String> permissionIds;

	@NotNull
	private Boolean autoAuthorize;

	@NotNull
	private Boolean allowWebView;

	@NotNull
	private Boolean allowPopup;

	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean isGlobal() {
		return global;
	}

	public void setGlobal(Boolean global) {
		this.global = global;
	}

	public Optional<Long> getExpiration() {
		return expiration;
	}

	public void setExpiration(Optional<Long> expiration) {
		this.expiration = expiration;
	}

	public String getLifespan() {
		return lifespan;
	}

	public void setLifespan(String lifespan) {
		this.lifespan = lifespan;
	}

	public Boolean isRefreshable() {
		return refreshable;
	}

	public void setRefreshable(Boolean refreshable) {
		this.refreshable = refreshable;
	}

	public Set<String> getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(Set<String> permissionIds) {
		this.permissionIds = permissionIds;
	}

	public Boolean isAutoAuthorize() {
		return autoAuthorize;
	}

	public void setAutoAuthorize(Boolean autoAuthorize) {
		this.autoAuthorize = autoAuthorize;
	}

	public Boolean isAllowWebView() {
		return allowWebView;
	}

	public void setAllowWebView(Boolean allowWebView) {
		this.allowWebView = allowWebView;
	}

	public Boolean isAllowPopup() {
		return allowPopup;
	}

	public void setAllowPopup(Boolean allowPopup) {
		this.allowPopup = allowPopup;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
