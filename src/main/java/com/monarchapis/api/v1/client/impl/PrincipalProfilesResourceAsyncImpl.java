package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.PrincipalProfilesQuery;
import com.monarchapis.api.v1.client.PrincipalProfilesResourceAsync;
import com.monarchapis.api.v1.model.PrincipalProfile;
import com.monarchapis.api.v1.model.PrincipalProfileList;
import com.monarchapis.api.v1.model.PrincipalProfileUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class PrincipalProfilesResourceAsyncImpl extends AbstractResource implements PrincipalProfilesResourceAsync {
	public PrincipalProfilesResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public PrincipalProfilesResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<PrincipalProfileList> queryPrincipalProfile(PrincipalProfilesQuery query,
			Callback<PrincipalProfileList> callback) {
		final RestAsyncClient client = newAsyncClient("GET", "/principalProfiles") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("name", query.getNames(), CollectionFormat.PIPES);

		signRequest(client);
		AsyncFuture<PrincipalProfileList> future = client.future(callback);
		client.send(callbackAdapter(future, PrincipalProfileList.class));

		return future;
	}

	public Future<PrincipalProfile> createPlan(PrincipalProfileUpdate body, Callback<PrincipalProfile> callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/principalProfiles") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<PrincipalProfile> future = client.future(callback);
		client.send(callbackAdapter(future, PrincipalProfile.class));

		return future;
	}

	public Future<PrincipalProfile> loadPrincipalProfile(String id, Callback<PrincipalProfile> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/principalProfiles/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<PrincipalProfile> future = client.future(callback);
		client.send(callbackAdapter(future, PrincipalProfile.class));

		return future;
	}

	public Future<PrincipalProfile> updatePrincipalProfile(String id, PrincipalProfileUpdate body,
			Callback<PrincipalProfile> callback) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/principalProfiles/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<PrincipalProfile> future = client.future(callback);
		client.send(callbackAdapter(future, PrincipalProfile.class));

		return future;
	}

	public Future<PrincipalProfile> deletePrincipalProfile(String id, Callback<PrincipalProfile> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/principalProfiles/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<PrincipalProfile> future = client.future(callback);
		client.send(callbackAdapter(future, PrincipalProfile.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}