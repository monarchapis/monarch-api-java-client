package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.ClientsQuery;
import com.monarchapis.api.v1.client.ClientsResourceAsync;
import com.monarchapis.api.v1.model.Client;
import com.monarchapis.api.v1.model.ClientList;
import com.monarchapis.api.v1.model.ClientUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class ClientsResourceAsyncImpl extends AbstractResource implements ClientsResourceAsync {
	public ClientsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public ClientsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<ClientList> queryClients(ClientsQuery query, Callback<ClientList> callback) {
		final RestAsyncClient client = newAsyncClient("GET", "/clients") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("applicationId", query.getApplicationIds(), CollectionFormat.PIPES) //
				.addQueryCollection("label", query.getLabels(), CollectionFormat.PIPES) //
				.addQuery("enabled", query.isEnabled()) //
				.addQueryCollection("status", query.getStatuses(), CollectionFormat.PIPES) //
				.addQueryCollection("apiKey", query.getApiKeys(), CollectionFormat.PIPES) //
				.addQueryCollection("externalId", query.getExternalIds(), CollectionFormat.PIPES);

		signRequest(client);
		AsyncFuture<ClientList> future = client.future(callback);
		client.send(callbackAdapter(future, ClientList.class));

		return future;
	}

	public Future<Client> createClient(ClientUpdate body, Callback<Client> callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/clients") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Client> future = client.future(callback);
		client.send(callbackAdapter(future, Client.class));

		return future;
	}

	public Future<Client> loadClient(String id, Callback<Client> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/clients/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Client> future = client.future(callback);
		client.send(callbackAdapter(future, Client.class));

		return future;
	}

	public Future<Client> updateClient(String id, ClientUpdate body, Callback<Client> callback) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/clients/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Client> future = client.future(callback);
		client.send(callbackAdapter(future, Client.class));

		return future;
	}

	public Future<Client> deleteClient(String id, Callback<Client> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/clients/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Client> future = client.future(callback);
		client.send(callbackAdapter(future, Client.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}