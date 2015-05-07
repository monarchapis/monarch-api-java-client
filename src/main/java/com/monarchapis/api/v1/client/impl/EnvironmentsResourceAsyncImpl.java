package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.EnvironmentsQuery;
import com.monarchapis.api.v1.client.EnvironmentsResourceAsync;
import com.monarchapis.api.v1.model.Environment;
import com.monarchapis.api.v1.model.EnvironmentList;
import com.monarchapis.api.v1.model.EnvironmentSummary;
import com.monarchapis.api.v1.model.EnvironmentUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;
import com.monarchapis.client.rest.VoidCallback;

public class EnvironmentsResourceAsyncImpl extends AbstractResource implements EnvironmentsResourceAsync {
	public EnvironmentsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public EnvironmentsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<EnvironmentList> queryEnvironments(EnvironmentsQuery query, Callback<EnvironmentList> callback) {
		final RestAsyncClient client = newAsyncClient("GET", "/environments") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("name", query.getNames(), CollectionFormat.PIPES) //
				.addQueryCollection("description", query.getDescriptions(), CollectionFormat.PIPES) //
				.addQueryCollection("systemDatabase", query.getSystemDatabases(), CollectionFormat.PIPES) //
				.addQueryCollection("analyticsDatabase", query.getAnalyticsDatabases(), CollectionFormat.PIPES);

		signRequest(client);
		AsyncFuture<EnvironmentList> future = client.future(callback);
		client.send(callbackAdapter(future, EnvironmentList.class));

		return future;
	}

	public void createEnvironment(EnvironmentUpdate body, VoidCallback callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/environments") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		client.send(callback);
	}

	public Future<Environment> loadEnvironment(String id, Callback<Environment> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/environments/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Environment> future = client.future(callback);
		client.send(callbackAdapter(future, Environment.class));

		return future;
	}

	public Future<Environment> updateEnvironment(String id, EnvironmentUpdate body, Callback<Environment> callback) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/environments/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Environment> future = client.future(callback);
		client.send(callbackAdapter(future, Environment.class));

		return future;
	}

	public Future<Environment> deleteEnvironment(String id, Callback<Environment> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/environments/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Environment> future = client.future(callback);
		client.send(callbackAdapter(future, Environment.class));

		return future;
	}

	public Future<EnvironmentSummary> getSummary(Callback<EnvironmentSummary> callback) {

		final RestAsyncClient client = newAsyncClient("GET", "/environment/summary") //
				.accepts("application/json");

		signRequest(client);
		AsyncFuture<EnvironmentSummary> future = client.future(callback);
		client.send(callbackAdapter(future, EnvironmentSummary.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}