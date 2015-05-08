package com.monarchapis.api.v1.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class UserUpdate implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String userName;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	private Optional<String> roleId = Optional.absent();

	private Optional<String> externalId = Optional.absent();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Optional<String> getRoleId() {
		return roleId;
	}

	public void setRoleId(Optional<String> roleId) {
		this.roleId = roleId;
	}

	public Optional<String> getExternalId() {
		return externalId;
	}

	public void setExternalId(Optional<String> externalId) {
		this.externalId = externalId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
