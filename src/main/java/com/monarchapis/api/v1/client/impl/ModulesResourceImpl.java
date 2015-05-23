package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.ModulesResource;
import com.monarchapis.api.v1.model.ConfigurableList;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class ModulesResourceImpl extends AbstractResource implements ModulesResource {
	public ModulesResourceImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public ModulesResourceImpl(String baseUrl, RestClientFactory clientFactory, List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public ConfigurableList listAuthenticators() {

		final RestClient client = newClient("GET", "/authenticators") //
				.accepts("application/json");

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, ConfigurableList.class);
	}

	public ConfigurableList listPolicies() {

		final RestClient client = newClient("GET", "/policies") //
				.accepts("application/json");

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, ConfigurableList.class);
	}

	public ConfigurableList listClaimSources() {

		final RestClient client = newClient("GET", "/claimSources") //
				.accepts("application/json");

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, ConfigurableList.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}