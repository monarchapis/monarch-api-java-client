package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.PrincipalProfilesQuery;
import com.monarchapis.api.v1.client.PrincipalProfilesResource;
import com.monarchapis.api.v1.model.PrincipalProfile;
import com.monarchapis.api.v1.model.PrincipalProfileList;
import com.monarchapis.api.v1.model.PrincipalProfileUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class PrincipalProfilesResourceImpl extends AbstractResource implements PrincipalProfilesResource {
	public PrincipalProfilesResourceImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public PrincipalProfilesResourceImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public PrincipalProfileList queryPrincipalProfile(PrincipalProfilesQuery query) {
		final RestClient client = newClient("GET", "/principalProfiles") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("name", query.getNames(), CollectionFormat.PIPES);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, PrincipalProfileList.class);
	}

	public PrincipalProfile createPlan(PrincipalProfileUpdate body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/principalProfiles") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, PrincipalProfile.class);
	}

	public PrincipalProfile loadPrincipalProfile(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/principalProfiles/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, PrincipalProfile.class);
	}

	public PrincipalProfile updatePrincipalProfile(String id, PrincipalProfileUpdate body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/principalProfiles/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, PrincipalProfile.class);
	}

	public PrincipalProfile deletePrincipalProfile(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/principalProfiles/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, PrincipalProfile.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}