package com.monarchapis.api.v1.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class EnvironmentSummary {

	@NotNull
	private String name;

	@NotNull
	private Long applications;

	@NotNull
	private Long clients;

	@NotNull
	private Long developers;

	@NotNull
	private Long services;

	@NotNull
	private Long plans;

	@NotNull
	private Long providers;

	@NotNull
	private Long users;

	@NotNull
	private Long roles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getApplications() {
		return applications;
	}

	public void setApplications(Long applications) {
		this.applications = applications;
	}

	public Long getClients() {
		return clients;
	}

	public void setClients(Long clients) {
		this.clients = clients;
	}

	public Long getDevelopers() {
		return developers;
	}

	public void setDevelopers(Long developers) {
		this.developers = developers;
	}

	public Long getServices() {
		return services;
	}

	public void setServices(Long services) {
		this.services = services;
	}

	public Long getPlans() {
		return plans;
	}

	public void setPlans(Long plans) {
		this.plans = plans;
	}

	public Long getProviders() {
		return providers;
	}

	public void setProviders(Long providers) {
		this.providers = providers;
	}

	public Long getUsers() {
		return users;
	}

	public void setUsers(Long users) {
		this.users = users;
	}

	public Long getRoles() {
		return roles;
	}

	public void setRoles(Long roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
