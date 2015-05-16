package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.PrincipalClaimsQuery;
import com.monarchapis.api.v1.client.PrincipalClaimsResource;
import com.monarchapis.api.v1.model.PrincipalClaims;
import com.monarchapis.api.v1.model.PrincipalClaimsList;
import com.monarchapis.api.v1.model.PrincipalClaimsUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class PrincipalClaimsResourceImpl extends AbstractResource implements PrincipalClaimsResource {
	public PrincipalClaimsResourceImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public PrincipalClaimsResourceImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public PrincipalClaimsList queryPrincipalClaims(PrincipalClaimsQuery query) {
		final RestClient client = newClient("GET", "/principalClaims") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("name", query.getNames(), CollectionFormat.PIPES) //
				.addQueryCollection("inherits", query.getInherits(), CollectionFormat.PIPES);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, PrincipalClaimsList.class);
	}

	public PrincipalClaims createPlan(PrincipalClaimsUpdate body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/principalClaims") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, PrincipalClaims.class);
	}

	public PrincipalClaims loadPrincipalClaims(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/principalClaims/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, PrincipalClaims.class);
	}

	public PrincipalClaims updatePrincipalClaims(String id, PrincipalClaimsUpdate body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/principalClaims/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, PrincipalClaims.class);
	}

	public PrincipalClaims deletePrincipalClaims(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/principalClaims/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, PrincipalClaims.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}