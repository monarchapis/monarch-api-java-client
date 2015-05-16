package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.ServicesQuery;
import com.monarchapis.api.v1.client.ServicesResource;
import com.monarchapis.api.v1.model.Service;
import com.monarchapis.api.v1.model.ServiceList;
import com.monarchapis.api.v1.model.ServiceUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class ServicesResourceImpl extends AbstractResource implements ServicesResource {
	public ServicesResourceImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public ServicesResourceImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public ServiceList queryServices(ServicesQuery query) {
		final RestClient client = newClient("GET", "/services") //
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
		final RestResponse response = client.send();
		return parseAs(response, ServiceList.class);
	}

	public Service createService(ServiceUpdate body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/services") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Service.class);
	}

	public Service loadService(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/services/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Service.class);
	}

	public Service updateService(String id, ServiceUpdate body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/services/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Service.class);
	}

	public Service deleteService(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/services/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Service.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}