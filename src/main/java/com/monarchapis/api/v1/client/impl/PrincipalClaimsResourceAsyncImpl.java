package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.PrincipalClaimsQuery;
import com.monarchapis.api.v1.client.PrincipalClaimsResourceAsync;
import com.monarchapis.api.v1.model.PrincipalClaims;
import com.monarchapis.api.v1.model.PrincipalClaimsList;
import com.monarchapis.api.v1.model.PrincipalClaimsUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class PrincipalClaimsResourceAsyncImpl extends AbstractResource implements PrincipalClaimsResourceAsync {
	public PrincipalClaimsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public PrincipalClaimsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<PrincipalClaimsList> queryPrincipalClaims(PrincipalClaimsQuery query,
			Callback<PrincipalClaimsList> callback) {
		final RestAsyncClient client = newAsyncClient("GET", "/principalClaims") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("name", query.getNames(), CollectionFormat.PIPES) //
				.addQueryCollection("inherits", query.getInherits(), CollectionFormat.PIPES);

		signRequest(client);
		AsyncFuture<PrincipalClaimsList> future = client.future(callback);
		client.send(callbackAdapter(future, PrincipalClaimsList.class));

		return future;
	}

	public Future<PrincipalClaims> createPlan(PrincipalClaimsUpdate body, Callback<PrincipalClaims> callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/principalClaims") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<PrincipalClaims> future = client.future(callback);
		client.send(callbackAdapter(future, PrincipalClaims.class));

		return future;
	}

	public Future<PrincipalClaims> loadPrincipalClaims(String id, Callback<PrincipalClaims> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/principalClaims/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<PrincipalClaims> future = client.future(callback);
		client.send(callbackAdapter(future, PrincipalClaims.class));

		return future;
	}

	public Future<PrincipalClaims> updatePrincipalClaims(String id, PrincipalClaimsUpdate body,
			Callback<PrincipalClaims> callback) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/principalClaims/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<PrincipalClaims> future = client.future(callback);
		client.send(callbackAdapter(future, PrincipalClaims.class));

		return future;
	}

	public Future<PrincipalClaims> deletePrincipalClaims(String id, Callback<PrincipalClaims> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/principalClaims/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<PrincipalClaims> future = client.future(callback);
		client.send(callbackAdapter(future, PrincipalClaims.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}