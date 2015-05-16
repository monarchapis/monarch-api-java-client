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

	public ApplicationList queryApplications(ApplicationsQuery query) {
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

	public Application createApplication(ApplicationUpdate body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/applications") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Application.class);
	}

	public Application loadApplication(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/applications/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Application.class);
	}

	public Application updateApplication(String id, ApplicationUpdate body) {
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

	public Application deleteApplication(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/applications/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Application.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}