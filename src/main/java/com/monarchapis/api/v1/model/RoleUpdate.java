package com.monarchapis.api.v1.model;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class RoleUpdate {

	@NotNull
	private String roleName;

	@NotNull
	private String displayName;

	private Optional<String> description = Optional.absent();

	@NotNull
	private Set<String> permissions;

	@NotNull
	private StringMap accessLevels;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Optional<String> getDescription() {
		return description;
	}

	public void setDescription(Optional<String> description) {
		this.description = description;
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
