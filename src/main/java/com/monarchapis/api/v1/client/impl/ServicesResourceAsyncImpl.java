package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.ServicesQuery;
import com.monarchapis.api.v1.client.ServicesResourceAsync;
import com.monarchapis.api.v1.model.Service;
import com.monarchapis.api.v1.model.ServiceList;
import com.monarchapis.api.v1.model.ServiceUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class ServicesResourceAsyncImpl extends AbstractResource implements ServicesResourceAsync {
	public ServicesResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public ServicesResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<ServiceList> query(ServicesQuery query, Callback<ServiceList> callback) {
		final RestAsyncClient client = newAsyncClient("GET", "/services") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("name", query.getNames(), CollectionFormat.PIPES) //
				.addQueryCollection("type", query.getTypes(), CollectionFormat.PIPES) //
				.addQueryCollection("description", query.getDescriptions(), CollectionFormat.PIPES) //
				.addQuery("accessControl", query.isAccessControl()) //
				.addQueryCollection("uriPrefix", query.getUriPrefixes(), CollectionFormat.PIPES) //
				.addQueryCollection("versionLocation", query.getVersionLocations(), CollectionFormat.PIPES) //
				.addQueryCollection("defaultVersion", query.getDefaultVersions(), CollectionFormat.PIPES) //
				.addQueryCollection("flags", query.getFlags(), CollectionFormat.PIPES);

		signRequest(client);
		AsyncFuture<ServiceList> future = client.future(callback);
		client.send(callbackAdapter(future, ServiceList.class));

		return future;
	}

	public Future<Service> create(ServiceUpdate body, Callback<Service> callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/services") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Service> future = client.future(callback);
		client.send(callbackAdapter(future, Service.class));

		return future;
	}

	public Future<Service> load(String id, Callback<Service> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/services/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Service> future = client.future(callback);
		client.send(callbackAdapter(future, Service.class));

		return future;
	}

	public Future<Service> update(String id, ServiceUpdate body, Callback<Service> callback) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/services/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Service> future = client.future(callback);
		client.send(callbackAdapter(future, Service.class));

		return future;
	}

	public Future<Service> delete(String id, Callback<Service> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/services/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Service> future = client.future(callback);
		client.send(callbackAdapter(future, Service.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}