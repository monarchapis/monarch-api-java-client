package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.UsersQuery;
import com.monarchapis.api.v1.client.UsersResourceAsync;
import com.monarchapis.api.v1.model.Result;
import com.monarchapis.api.v1.model.SetPassword;
import com.monarchapis.api.v1.model.User;
import com.monarchapis.api.v1.model.UserList;
import com.monarchapis.api.v1.model.UserUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;
import com.monarchapis.client.rest.VoidCallback;

public class UsersResourceAsyncImpl extends AbstractResource implements UsersResourceAsync {
	public UsersResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public UsersResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<UserList> queryUsers(UsersQuery query, Callback<UserList> callback) {
		final RestAsyncClient client = newAsyncClient("GET", "/users") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("userName", query.getUserNames(), CollectionFormat.PIPES) //
				.addQueryCollection("firstName", query.getFirstNames(), CollectionFormat.PIPES) //
				.addQueryCollection("lastName", query.getLastNames(), CollectionFormat.PIPES) //
				.addQuery("administrator", query.isAdministrator()) //
				.addQueryCollection("externalId", query.getExternalIds(), CollectionFormat.PIPES);

		signRequest(client);
		AsyncFuture<UserList> future = client.future(callback);
		client.send(callbackAdapter(future, UserList.class));

		return future;
	}

	public void createUser(UserUpdate body, VoidCallback callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/users") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		client.send(callback);
	}

	public Future<User> loadUser(String id, Callback<User> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/users/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<User> future = client.future(callback);
		client.send(callbackAdapter(future, User.class));

		return future;
	}

	public Future<User> updateUser(String id, UserUpdate body, Callback<User> callback) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/users/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<User> future = client.future(callback);
		client.send(callbackAdapter(future, User.class));

		return future;
	}

	public Future<User> deleteUser(String id, Callback<User> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/users/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<User> future = client.future(callback);
		client.send(callbackAdapter(future, User.class));

		return future;
	}

	public Future<Result> setPassword(String id, SetPassword body, Callback<Result> callback) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/users/{id}/password") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

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