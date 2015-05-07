package com.monarchapis.api.v1.client;

public interface AnalyticsApi {

	EventsResource getEventsResource();

	EventsResourceAsync getEventsResourceAsync();

	MetricsResource getMetricsResource();

	MetricsResourceAsync getMetricsResourceAsync();

}