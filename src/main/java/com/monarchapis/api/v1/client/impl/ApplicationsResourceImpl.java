package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.ApplicationsQuery;
import com.monarchapis.api.v1.client.ApplicationsResource;
import com.monarchapis.api.v1.model.Application;
import com.monarchapis.api.v1.model.ApplicationList;
import com.monarchapis.api.v1.model.ApplicationUpdate;
import com.monarchapis.api.v1.model.ClientList;
import com.monarchapis.api.v1.model.Developer;
import com.monarchapis.api.v1.model.DeveloperList;
import com.monarchapis.api.v1.model.Result;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class ApplicationsResourceImpl extends AbstractResource implements ApplicationsResource {
	public ApplicationsResourceImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public ApplicationsResourceImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public ApplicationList query(ApplicationsQuery query) {
		final RestClient client = newClient("GET", "/applications") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("name", query.getNames(), CollectionFormat.PIPES) //
				.addQueryCollection("description", query.getDescriptions(), CollectionFormat.PIPES) //
				.addQueryCollection("applicationUrl", query.getApplicationUrls(), CollectionFormat.PIPES) //
				.addQueryCollection("applicationImageUrl", query.getApplicationImageUrls(), CollectionFormat.PIPES) //
				.addQueryCollection("companyName", query.getCompanyNames(), CollectionFormat.PIPES) //
				.addQueryCollection("companyUrl", query.getCompanyUrls(), CollectionFormat.PIPES) //
				.addQueryCollection("companyImageUrl", query.getCompanyImageUrls(), CollectionFormat.PIPES) //
				.addQueryCollection("callbackUri", query.getCallbackUris(), CollectionFormat.PIPES) //
				.addQueryCollection("planId", query.getPlanIds(), CollectionFormat.PIPES) //
				.addQueryCollection("externalId", query.getExternalIds(), CollectionFormat.PIPES);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, ApplicationList.class);
	}

	public Application create(ApplicationUpdate body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/applications") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Application.class);
	}

	public Application load(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/applications/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Application.class);
	}

	public Application update(String id, ApplicationUpdate body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/applications/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Application.class);
	}

	public Application delete(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/applications/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Application.class);
	}

	public ClientList getClients(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/applications/{id}/clients") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, ClientList.class);
	}

	public DeveloperList getDevelopers(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/applications/{id}/developers") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, DeveloperList.class);
	}

	public Developer getDeveloper(String id, String developerId) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/applications/{id}/developers/{developerId}") //
				.accepts("application/json") //
				.setPath("id", id) //
				.setPath("developerId", developerId);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Developer.class);
	}

	public Developer addApplication(String id, String developerId) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("PUT", "/applications/{id}/developers/{developerId}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setPath("developerId", developerId);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Developer.class);
	}

	public Result removeDeveloper(String id, String developerId) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/applications/{id}/developers/{developerId}") //
				.accepts("application/json") //
				.setPath("id", id) //
				.setPath("developerId", developerId);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Result.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}