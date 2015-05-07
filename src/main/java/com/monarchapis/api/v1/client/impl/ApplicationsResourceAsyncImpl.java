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
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;
import com.monarchapis.client.rest.VoidCallback;

public class ApplicationsResourceAsyncImpl extends AbstractResource implements ApplicationsResourceAsync {
	public ApplicationsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public ApplicationsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<ApplicationList> queryApplications(ApplicationsQuery query, Callback<ApplicationList> callback) {
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

	public void createApplication(ApplicationUpdate body, VoidCallback callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/applications") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		client.send(callback);
	}

	public Future<Application> loadApplication(String id, Callback<Application> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/applications/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Application> future = client.future(callback);
		client.send(callbackAdapter(future, Application.class));

		return future;
	}

	public Future<Application> updateApplication(String id, ApplicationUpdate body, Callback<Application> callback) {
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

	public Future<Application> deleteApplication(String id, Callback<Application> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/applications/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Application> future = client.future(callback);
		client.send(callbackAdapter(future, Application.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}