package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.DevelopersQuery;
import com.monarchapis.api.v1.client.DevelopersResourceAsync;
import com.monarchapis.api.v1.model.Developer;
import com.monarchapis.api.v1.model.DeveloperList;
import com.monarchapis.api.v1.model.DeveloperUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class DevelopersResourceAsyncImpl extends AbstractResource implements DevelopersResourceAsync {
	public DevelopersResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public DevelopersResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<DeveloperList> queryDevelopers(DevelopersQuery query, Callback<DeveloperList> callback) {
		final RestAsyncClient client = newAsyncClient("GET", "/developers") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("username", query.getUsernames(), CollectionFormat.PIPES) //
				.addQueryCollection("firstName", query.getFirstNames(), CollectionFormat.PIPES) //
				.addQueryCollection("lastName", query.getLastNames(), CollectionFormat.PIPES) //
				.addQueryCollection("roles", query.getRoles(), CollectionFormat.PIPES) //
				.addQueryCollection("company", query.getCompanies(), CollectionFormat.PIPES) //
				.addQueryCollection("title", query.getTitles(), CollectionFormat.PIPES) //
				.addQueryCollection("email", query.getEmails(), CollectionFormat.PIPES) //
				.addQueryCollection("phone", query.getPhones(), CollectionFormat.PIPES) //
				.addQueryCollection("mobile", query.getMobiles(), CollectionFormat.PIPES) //
				.addQueryCollection("address1", query.getAddress1s(), CollectionFormat.PIPES) //
				.addQueryCollection("address2", query.getAddress2s(), CollectionFormat.PIPES) //
				.addQueryCollection("locality", query.getLocalities(), CollectionFormat.PIPES) //
				.addQueryCollection("region", query.getRegions(), CollectionFormat.PIPES) //
				.addQueryCollection("postalCode", query.getPostalCodes(), CollectionFormat.PIPES) //
				.addQueryCollection("countryCode", query.getCountryCodes(), CollectionFormat.PIPES) //
				.addQueryCollection("registrationIp", query.getRegistrationIps(), CollectionFormat.PIPES) //
				.addQueryCollection("externalId", query.getExternalIds(), CollectionFormat.PIPES);

		signRequest(client);
		AsyncFuture<DeveloperList> future = client.future(callback);
		client.send(callbackAdapter(future, DeveloperList.class));

		return future;
	}

	public Future<Developer> createDeveloper(DeveloperUpdate body, Callback<Developer> callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/developers") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Developer> future = client.future(callback);
		client.send(callbackAdapter(future, Developer.class));

		return future;
	}

	public Future<Developer> loadDeveloper(String id, Callback<Developer> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/developers/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Developer> future = client.future(callback);
		client.send(callbackAdapter(future, Developer.class));

		return future;
	}

	public Future<Developer> updateDeveloper(String id, DeveloperUpdate body, Callback<Developer> callback) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/developers/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Developer> future = client.future(callback);
		client.send(callbackAdapter(future, Developer.class));

		return future;
	}

	public Future<Developer> deleteDeveloper(String id, Callback<Developer> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/developers/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Developer> future = client.future(callback);
		client.send(callbackAdapter(future, Developer.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}