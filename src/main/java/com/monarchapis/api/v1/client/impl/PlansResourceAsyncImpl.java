package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.PlansQuery;
import com.monarchapis.api.v1.client.PlansResourceAsync;
import com.monarchapis.api.v1.model.Plan;
import com.monarchapis.api.v1.model.PlanList;
import com.monarchapis.api.v1.model.PlanUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;
import com.monarchapis.client.rest.VoidCallback;

public class PlansResourceAsyncImpl extends AbstractResource implements PlansResourceAsync {
	public PlansResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public PlansResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<PlanList> queryPlans(PlansQuery query, Callback<PlanList> callback) {
		final RestAsyncClient client = newAsyncClient("GET", "/plans") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("name", query.getNames(), CollectionFormat.PIPES) //
				.addQueryCollection("priceAmount", query.getPriceAmounts(), CollectionFormat.PIPES) //
				.addQueryCollection("priceCurrency", query.getPriceCurrencies(), CollectionFormat.PIPES);

		signRequest(client);
		AsyncFuture<PlanList> future = client.future(callback);
		client.send(callbackAdapter(future, PlanList.class));

		return future;
	}

	public void createPlan(PlanUpdate body, VoidCallback callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/plans") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		client.send(callback);
	}

	public Future<Plan> loadPlan(String id, Callback<Plan> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/plans/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Plan> future = client.future(callback);
		client.send(callbackAdapter(future, Plan.class));

		return future;
	}

	public Future<Plan> updatePlan(String id, PlanUpdate body, Callback<Plan> callback) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/plans/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Plan> future = client.future(callback);
		client.send(callbackAdapter(future, Plan.class));

		return future;
	}

	public Future<Plan> deletePlan(String id, Callback<Plan> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/plans/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Plan> future = client.future(callback);
		client.send(callbackAdapter(future, Plan.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}