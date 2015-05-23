package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.ProvidersQuery;
import com.monarchapis.api.v1.client.ProvidersResourceAsync;
import com.monarchapis.api.v1.model.Provider;
import com.monarchapis.api.v1.model.ProviderList;
import com.monarchapis.api.v1.model.ProviderUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class ProvidersResourceAsyncImpl extends AbstractResource implements ProvidersResourceAsync {
	public ProvidersResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public ProvidersResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<ProviderList> query(ProvidersQuery query, Callback<ProviderList> callback) {
		final RestAsyncClient client = newAsyncClient("GET", "/providers") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("label", query.getLabels(), CollectionFormat.PIPES) //
				.addQuery("enabled", query.isEnabled()) //
				.addQueryCollection("apiKey", query.getApiKeys(), CollectionFormat.PIPES);

		signRequest(client);
		AsyncFuture<ProviderList> future = client.future(callback);
		client.send(callbackAdapter(future, ProviderList.class));

		return future;
	}

	public Future<Provider> create(ProviderUpdate body, Callback<Provider> callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/providers") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Provider> future = client.future(callback);
		client.send(callbackAdapter(future, Provider.class));

		return future;
	}

	public Future<Provider> load(String id, Callback<Provider> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/providers/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Provider> future = client.future(callback);
		client.send(callbackAdapter(future, Provider.class));

		return future;
	}

	public Future<Provider> update(String id, ProviderUpdate body, Callback<Provider> callback) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/providers/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Provider> future = client.future(callback);
		client.send(callbackAdapter(future, Provider.class));

		return future;
	}

	public Future<Provider> delete(String id, Callback<Provider> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/providers/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Provider> future = client.future(callback);
		client.send(callbackAdapter(future, Provider.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}