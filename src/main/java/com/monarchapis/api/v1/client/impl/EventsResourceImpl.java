package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.EventsResource;
import com.monarchapis.api.v1.model.EventDescriptor;
import com.monarchapis.api.v1.model.EventsResponse;
import com.monarchapis.api.v1.model.ObjectData;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class EventsResourceImpl extends AbstractResource implements EventsResource {
	public EventsResourceImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public EventsResourceImpl(String baseUrl, RestClientFactory clientFactory, List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public EventDescriptor getEventDescriptor(String eventType) {
		require(eventType, "eventType is a required parameter.");

		final RestClient client = newClient("GET", "/{eventType}") //
				.accepts("application/json") //
				.setPath("eventType", eventType);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, EventDescriptor.class);
	}

	public void collectEvent(String eventType, ObjectData body) {
		require(eventType, "eventType is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/{eventType}/events") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("eventType", eventType) //
				.setBody(toJson(body));

		signRequest(client);
		client.send();
	}

	public EventsResponse queryEvents(String eventType, String start, String end, String query) {
		require(eventType, "eventType is a required parameter.");
		require(end, "end is a required parameter.");
		require(query, "query is a required parameter.");

		final RestClient client = newClient("GET", "/{eventType}/events") //
				.accepts("application/json") //
				.setPath("eventType", eventType) //
				.setQuery("start", start) //
				.setQuery("end", end) //
				.setQuery("query", query);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, EventsResponse.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}