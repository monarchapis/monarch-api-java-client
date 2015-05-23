package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.UsersQuery;
import com.monarchapis.api.v1.client.UsersResource;
import com.monarchapis.api.v1.model.Result;
import com.monarchapis.api.v1.model.SetPassword;
import com.monarchapis.api.v1.model.User;
import com.monarchapis.api.v1.model.UserList;
import com.monarchapis.api.v1.model.UserUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class UsersResourceImpl extends AbstractResource implements UsersResource {
	public UsersResourceImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public UsersResourceImpl(String baseUrl, RestClientFactory clientFactory, List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public UserList query(UsersQuery query) {
		final RestClient client = newClient("GET", "/users") //
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
		final RestResponse response = client.send();
		return parseAs(response, UserList.class);
	}

	public User create(UserUpdate body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/users") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, User.class);
	}

	public User load(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/users/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, User.class);
	}

	public User update(String id, UserUpdate body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/users/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, User.class);
	}

	public User delete(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/users/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, User.class);
	}

	public Result setPassword(String id, SetPassword body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/users/{id}/password") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Result.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}