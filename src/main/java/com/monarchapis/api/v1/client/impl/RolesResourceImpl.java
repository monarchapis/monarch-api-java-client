package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.RolesQuery;
import com.monarchapis.api.v1.client.RolesResource;
import com.monarchapis.api.v1.model.Role;
import com.monarchapis.api.v1.model.RoleList;
import com.monarchapis.api.v1.model.RoleUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class RolesResourceImpl extends AbstractResource implements RolesResource {
	public RolesResourceImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public RolesResourceImpl(String baseUrl, RestClientFactory clientFactory, List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public RoleList query(RolesQuery query) {
		final RestClient client = newClient("GET", "/roles") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("roleName", query.getRoleNames(), CollectionFormat.PIPES) //
				.addQueryCollection("displayName", query.getDisplayNames(), CollectionFormat.PIPES) //
				.addQueryCollection("description", query.getDescriptions(), CollectionFormat.PIPES);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, RoleList.class);
	}

	public Role create(RoleUpdate body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/roles") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Role.class);
	}

	public Role load(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/roles/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Role.class);
	}

	public Role update(String id, RoleUpdate body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/roles/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Role.class);
	}

	public Role delete(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/roles/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Role.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}