package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.PermissionsQuery;
import com.monarchapis.api.v1.client.PermissionsResource;
import com.monarchapis.api.v1.model.Permission;
import com.monarchapis.api.v1.model.PermissionList;
import com.monarchapis.api.v1.model.PermissionUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class PermissionsResourceImpl extends AbstractResource implements PermissionsResource {
	public PermissionsResourceImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public PermissionsResourceImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public PermissionList query(PermissionsQuery query) {
		final RestClient client = newClient("GET", "/permissions") //
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
		final RestResponse response = client.send();
		return parseAs(response, PermissionList.class);
	}

	public Permission create(PermissionUpdate body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/permissions") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Permission.class);
	}

	public Permission load(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/permissions/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Permission.class);
	}

	public Permission update(String id, PermissionUpdate body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/permissions/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Permission.class);
	}

	public Permission delete(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/permissions/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Permission.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}