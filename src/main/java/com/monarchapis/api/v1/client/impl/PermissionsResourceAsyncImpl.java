package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.PermissionsQuery;
import com.monarchapis.api.v1.client.PermissionsResourceAsync;
import com.monarchapis.api.v1.model.Permission;
import com.monarchapis.api.v1.model.PermissionList;
import com.monarchapis.api.v1.model.PermissionUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;
import com.monarchapis.client.rest.VoidCallback;

public class PermissionsResourceAsyncImpl extends AbstractResource implements PermissionsResourceAsync {
	public PermissionsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public PermissionsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<PermissionList> queryPermissions(PermissionsQuery query, Callback<PermissionList> callback) {
		final RestAsyncClient client = newAsyncClient("GET", "/permissions") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("name", query.getNames(), CollectionFormat.PIPES) //
				.addQueryCollection("type", query.getTypes(), CollectionFormat.PIPES) //
				.addQueryCollection("description", query.getDescriptions(), CollectionFormat.PIPES) //
				.addQueryCollection("scope", query.getScopes(), CollectionFormat.PIPES) //
				.addQueryCollection("messageId", query.getMessageIds(), CollectionFormat.PIPES) //
				.addQueryCollection("flags", query.getFlags(), CollectionFormat.PIPES);

		signRequest(client);
		AsyncFuture<PermissionList> future = client.future(callback);
		client.send(callbackAdapter(future, PermissionList.class));

		return future;
	}

	public void createPermission(PermissionUpdate body, VoidCallback callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/permissions") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		client.send(callback);
	}

	public Future<Permission> loadPermission(String id, Callback<Permission> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/permissions/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Permission> future = client.future(callback);
		client.send(callbackAdapter(future, Permission.class));

		return future;
	}

	public Future<Permission> updatePermission(String id, PermissionUpdate body, Callback<Permission> callback) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/permissions/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Permission> future = client.future(callback);
		client.send(callbackAdapter(future, Permission.class));

		return future;
	}

	public Future<Permission> deletePermission(String id, Callback<Permission> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/permissions/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Permission> future = client.future(callback);
		client.send(callbackAdapter(future, Permission.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}