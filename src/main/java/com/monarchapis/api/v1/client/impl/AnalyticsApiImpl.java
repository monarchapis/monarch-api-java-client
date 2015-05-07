package com.monarchapis.api.v1.client.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.monarchapis.api.v1.client.AnalyticsApi;
import com.monarchapis.api.v1.client.EventsResource;
import com.monarchapis.api.v1.client.EventsResourceAsync;
import com.monarchapis.api.v1.client.MetricsResource;
import com.monarchapis.api.v1.client.MetricsResourceAsync;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClientFactory;

public class AnalyticsApiImpl implements AnalyticsApi {
	private String baseUrl;
	private RestClientFactory clientFactory;
	private List<RequestProcessor> requestProcessors;

	public AnalyticsApiImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		this(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public AnalyticsApiImpl(String baseUrl, RestClientFactory clientFactory, List<RequestProcessor> requestProcessors) {
		baseUrl = StringUtils.removeEnd(baseUrl, "/");

		if (StringUtils.isBlank(baseUrl)) {
			throw new IllegalArgumentException("baseUrl must not be blank or null");
		}

		if (clientFactory == null) {
			throw new IllegalArgumentException("clientFactory must not be null");
		}

		this.baseUrl = baseUrl;
		this.clientFactory = clientFactory;
		this.requestProcessors = requestProcessors;
	}

	public EventsResource getEventsResource() {
		return new EventsResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public EventsResourceAsync getEventsResourceAsync() {
		return new EventsResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public MetricsResource getMetricsResource() {
		return new MetricsResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public MetricsResourceAsync getMetricsResourceAsync() {
		return new MetricsResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}
}