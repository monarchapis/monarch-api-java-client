package com.monarchapis.api.v1.model;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PermissionMessagesRequest {

	@NotNull
	private List<LocaleInfo> locales;

	@NotNull
	private Set<String> permissions;

	public List<LocaleInfo> getLocales() {
		return locales;
	}

	public void setLocales(List<LocaleInfo> locales) {
		this.locales = locales;
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
