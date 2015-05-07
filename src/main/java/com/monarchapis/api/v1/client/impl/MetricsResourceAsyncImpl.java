package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.MetricsResourceAsync;
import com.monarchapis.api.v1.model.DistinctResponse;
import com.monarchapis.api.v1.model.MetricsResponse;
import com.monarchapis.api.v1.model.ValueCountsResponse;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class MetricsResourceAsyncImpl extends AbstractResource implements MetricsResourceAsync {
	public MetricsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public MetricsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<MetricsResponse> queryMetrics(String eventType, String metric, String tier, String start, String end,
			String query, Boolean fillGaps, Boolean refreshing, Integer limit, Callback<MetricsResponse> callback) {
		require(eventType, "eventType is a required parameter.");
		require(metric, "metric is a required parameter.");
		require(tier, "tier is a required parameter.");
		require(end, "end is a required parameter.");
		require(query, "query is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/{eventType}/metrics/{metric}/{tier}/series") //
				.accepts("application/json") //
				.setPath("eventType", eventType) //
				.setPath("metric", metric) //
				.setPath("tier", tier) //
				.setQuery("start", start) //
				.setQuery("end", end) //
				.setQuery("query", query) //
				.setQuery("fillGaps", fillGaps) //
				.setQuery("refreshing", refreshing) //
				.setQuery("limit", limit);

		signRequest(client);
		AsyncFuture<MetricsResponse> future = client.future(callback);
		client.send(callbackAdapter(future, MetricsResponse.class));

		return future;
	}

	public Future<ValueCountsResponse> queryCounts(String eventType, String metric, String tier, String start,
			String end, String query, Integer limit, Callback<ValueCountsResponse> callback) {
		require(eventType, "eventType is a required parameter.");
		require(metric, "metric is a required parameter.");
		require(tier, "tier is a required parameter.");
		require(end, "end is a required parameter.");
		require(query, "query is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/{eventType}/metrics/{metric}/{tier}/counts") //
				.accepts("application/json") //
				.setPath("eventType", eventType) //
				.setPath("metric", metric) //
				.setPath("tier", tier) //
				.setQuery("start", start) //
				.setQuery("end", end) //
				.setQuery("query", query) //
				.setQuery("limit", limit);

		signRequest(client);
		AsyncFuture<ValueCountsResponse> future = client.future(callback);
		client.send(callbackAdapter(future, ValueCountsResponse.class));

		return future;
	}

	public Future<DistinctResponse> queryDistinctValues(String eventType, String metric, String start, String end,
			String query, Callback<DistinctResponse> callback) {
		require(eventType, "eventType is a required parameter.");
		require(metric, "metric is a required parameter.");
		require(end, "end is a required parameter.");
		require(query, "query is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/{eventType}/metrics/{metric}/distinct") //
				.accepts("application/json") //
				.setPath("eventType", eventType) //
				.setPath("metric", metric) //
				.setQuery("start", start) //
				.setQuery("end", end) //
				.setQuery("query", query);

		signRequest(client);
		AsyncFuture<DistinctResponse> future = client.future(callback);
		client.send(callbackAdapter(future, DistinctResponse.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}