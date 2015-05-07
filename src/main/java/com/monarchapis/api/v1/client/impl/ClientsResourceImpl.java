package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.ClientsQuery;
import com.monarchapis.api.v1.client.ClientsResource;
import com.monarchapis.api.v1.model.Client;
import com.monarchapis.api.v1.model.ClientList;
import com.monarchapis.api.v1.model.ClientUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class ClientsResourceImpl extends AbstractResource implements ClientsResource {
	public ClientsResourceImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public ClientsResourceImpl(String baseUrl, RestClientFactory clientFactory, List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public ClientList queryClients(ClientsQuery query) {
		final RestClient client = newClient("GET", "/clients") //
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
		final RestResponse response = client.send();
		return parseAs(response, ClientList.class);
	}

	public void createClient(ClientUpdate body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/clients") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		client.send();
	}

	public Client loadClient(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/clients/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Client.class);
	}

	public Client updateClient(String id, ClientUpdate body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/clients/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Client.class);
	}

	public Client deleteClient(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/clients/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Client.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}