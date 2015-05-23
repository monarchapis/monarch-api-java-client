package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.PlansQuery;
import com.monarchapis.api.v1.client.PlansResource;
import com.monarchapis.api.v1.model.Plan;
import com.monarchapis.api.v1.model.PlanList;
import com.monarchapis.api.v1.model.PlanUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class PlansResourceImpl extends AbstractResource implements PlansResource {
	public PlansResourceImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public PlansResourceImpl(String baseUrl, RestClientFactory clientFactory, List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public PlanList query(PlansQuery query) {
		final RestClient client = newClient("GET", "/plans") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("name", query.getNames(), CollectionFormat.PIPES) //
				.addQueryCollection("priceAmount", query.getPriceAmounts(), CollectionFormat.PIPES) //
				.addQueryCollection("priceCurrency", query.getPriceCurrencies(), CollectionFormat.PIPES);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, PlanList.class);
	}

	public Plan create(PlanUpdate body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/plans") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Plan.class);
	}

	public Plan load(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/plans/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Plan.class);
	}

	public Plan update(String id, PlanUpdate body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/plans/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Plan.class);
	}

	public Plan delete(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/plans/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Plan.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}