package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.EnvironmentsQuery;
import com.monarchapis.api.v1.client.EnvironmentsResource;
import com.monarchapis.api.v1.model.Environment;
import com.monarchapis.api.v1.model.EnvironmentList;
import com.monarchapis.api.v1.model.EnvironmentSummary;
import com.monarchapis.api.v1.model.EnvironmentUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class EnvironmentsResourceImpl extends AbstractResource implements EnvironmentsResource {
	public EnvironmentsResourceImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public EnvironmentsResourceImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public EnvironmentList queryEnvironments(EnvironmentsQuery query) {
		final RestClient client = newClient("GET", "/environments") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("name", query.getNames(), CollectionFormat.PIPES) //
				.addQueryCollection("description", query.getDescriptions(), CollectionFormat.PIPES) //
				.addQueryCollection("systemDatabase", query.getSystemDatabases(), CollectionFormat.PIPES) //
				.addQueryCollection("analyticsDatabase", query.getAnalyticsDatabases(), CollectionFormat.PIPES);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, EnvironmentList.class);
	}

	public Environment createEnvironment(EnvironmentUpdate body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/environments") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Environment.class);
	}

	public Environment loadEnvironment(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/environments/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Environment.class);
	}

	public Environment updateEnvironment(String id, EnvironmentUpdate body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/environments/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Environment.class);
	}

	public Environment deleteEnvironment(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/environments/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Environment.class);
	}

	public EnvironmentSummary getSummary() {

		final RestClient client = newClient("GET", "/environment/summary") //
				.accepts("application/json");

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, EnvironmentSummary.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}