package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.ApplicationsQuery;
import com.monarchapis.api.v1.client.ApplicationsResourceAsync;
import com.monarchapis.api.v1.model.Application;
import com.monarchapis.api.v1.model.ApplicationList;
import com.monarchapis.api.v1.model.ApplicationUpdate;
import com.monarchapis.api.v1.model.ClientList;
import com.monarchapis.api.v1.model.Developer;
import com.monarchapis.api.v1.model.DeveloperList;
import com.monarchapis.api.v1.model.Result;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class ApplicationsResourceAsyncImpl extends AbstractResource implements ApplicationsResourceAsync {
	public ApplicationsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public ApplicationsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<ApplicationList> query(ApplicationsQuery query, Callback<ApplicationList> callback) {
		final RestAsyncClient client = newAsyncClient("GET", "/applications") //
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
		AsyncFuture<ApplicationList> future = client.future(callback);
		client.send(callbackAdapter(future, ApplicationList.class));

		return future;
	}

	public Future<Application> create(ApplicationUpdate body, Callback<Application> callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/applications") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Application> future = client.future(callback);
		client.send(callbackAdapter(future, Application.class));

		return future;
	}

	public Future<Application> load(String id, Callback<Application> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/applications/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Application> future = client.future(callback);
		client.send(callbackAdapter(future, Application.class));

		return future;
	}

	public Future<Application> update(String id, ApplicationUpdate body, Callback<Application> callback) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/applications/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Application> future = client.future(callback);
		client.send(callbackAdapter(future, Application.class));

		return future;
	}

	public Future<Application> delete(String id, Callback<Application> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/applications/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Application> future = client.future(callback);
		client.send(callbackAdapter(future, Application.class));

		return future;
	}

	public Future<ClientList> getClients(String id, Callback<ClientList> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/applications/{id}/clients") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<ClientList> future = client.future(callback);
		client.send(callbackAdapter(future, ClientList.class));

		return future;
	}

	public Future<DeveloperList> getDevelopers(String id, Callback<DeveloperList> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/applications/{id}/developers") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<DeveloperList> future = client.future(callback);
		client.send(callbackAdapter(future, DeveloperList.class));

		return future;
	}

	public Future<Developer> getDeveloper(String id, String developerId, Callback<Developer> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/applications/{id}/developers/{developerId}") //
				.accepts("application/json") //
				.setPath("id", id) //
				.setPath("developerId", developerId);

		signRequest(client);
		AsyncFuture<Developer> future = client.future(callback);
		client.send(callbackAdapter(future, Developer.class));

		return future;
	}

	public Future<Developer> addApplication(String id, String developerId, Callback<Developer> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/applications/{id}/developers/{developerId}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setPath("developerId", developerId);

		signRequest(client);
		AsyncFuture<Developer> future = client.future(callback);
		client.send(callbackAdapter(future, Developer.class));

		return future;
	}

	public Future<Result> removeDeveloper(String id, String developerId, Callback<Result> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/applications/{id}/developers/{developerId}") //
				.accepts("application/json") //
				.setPath("id", id) //
				.setPath("developerId", developerId);

		signRequest(client);
		AsyncFuture<Result> future = client.future(callback);
		client.send(callbackAdapter(future, Result.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}