package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.ProvidersQuery;
import com.monarchapis.api.v1.client.ProvidersResource;
import com.monarchapis.api.v1.model.Provider;
import com.monarchapis.api.v1.model.ProviderList;
import com.monarchapis.api.v1.model.ProviderUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class ProvidersResourceImpl extends AbstractResource implements ProvidersResource {
	public ProvidersResourceImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public ProvidersResourceImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public ProviderList query(ProvidersQuery query) {
		final RestClient client = newClient("GET", "/providers") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("label", query.getLabels(), CollectionFormat.PIPES) //
				.addQuery("enabled", query.isEnabled()) //
				.addQueryCollection("apiKey", query.getApiKeys(), CollectionFormat.PIPES);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, ProviderList.class);
	}

	public Provider create(ProviderUpdate body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/providers") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Provider.class);
	}

	public Provider load(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/providers/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Provider.class);
	}

	public Provider update(String id, ProviderUpdate body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/providers/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Provider.class);
	}

	public Provider delete(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/providers/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Provider.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}