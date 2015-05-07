package com.monarchapis.api.v1.model;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UserPermissions {

	@NotNull
	private String name;

	@NotNull
	private Boolean administrator;

	@NotNull
	private Set<String> permissions;

	@NotNull
	private StringMap accessLevels;

	@NotNull
	private Boolean usersLocked;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(Boolean administrator) {
		this.administrator = administrator;
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

	public Boolean isUsersLocked() {
		return usersLocked;
	}

	public void setUsersLocked(Boolean usersLocked) {
		this.usersLocked = usersLocked;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
