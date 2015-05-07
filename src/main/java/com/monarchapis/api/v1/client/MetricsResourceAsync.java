package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.DistinctResponse;
import com.monarchapis.api.v1.model.MetricsResponse;
import com.monarchapis.api.v1.model.ValueCountsResponse;
import com.monarchapis.client.rest.Callback;

public interface MetricsResourceAsync {

	public Future<MetricsResponse> queryMetrics(String eventType, String metric, String tier, String start, String end,
			String query, Boolean fillGaps, Boolean refreshing, Integer limit, Callback<MetricsResponse> callback);

	public Future<ValueCountsResponse> queryCounts(String eventType, String metric, String tier, String start,
			String end, String query, Integer limit, Callback<ValueCountsResponse> callback);

	public Future<DistinctResponse> queryDistinctValues(String eventType, String metric, String start, String end,
			String query, Callback<DistinctResponse> callback);
}