package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.ConfigurableList;

public interface ModulesResource {

	public ConfigurableList listAuthenticators();

	public ConfigurableList listPolicies();

	public ConfigurableList listClaimSources();
}