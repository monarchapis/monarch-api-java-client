package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.DistinctResponse;
import com.monarchapis.api.v1.model.MetricsResponse;
import com.monarchapis.api.v1.model.ValueCountsResponse;

public interface MetricsResource {

	public MetricsResponse queryMetrics(String eventType, String metric, String tier, String start, String end,
			String query, Boolean fillGaps, Boolean refreshing, Integer limit);

	public ValueCountsResponse queryCounts(String eventType, String metric, String tier, String start, String end,
			String query, Integer limit);

	public DistinctResponse queryDistinctValues(String eventType, String metric, String start, String end, String query);
}