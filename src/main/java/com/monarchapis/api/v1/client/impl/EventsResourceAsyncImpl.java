package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.EventsResourceAsync;
import com.monarchapis.api.v1.model.EventDescriptor;
import com.monarchapis.api.v1.model.EventsResponse;
import com.monarchapis.api.v1.model.ObjectData;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;
import com.monarchapis.client.rest.VoidCallback;

public class EventsResourceAsyncImpl extends AbstractResource implements EventsResourceAsync {
	public EventsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public EventsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<EventDescriptor> getEventDescriptor(String eventType, Callback<EventDescriptor> callback) {
		require(eventType, "eventType is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/{eventType}") //
				.accepts("application/json") //
				.setPath("eventType", eventType);

		signRequest(client);
		AsyncFuture<EventDescriptor> future = client.future(callback);
		client.send(callbackAdapter(future, EventDescriptor.class));

		return future;
	}

	public void collectEvent(String eventType, ObjectData body, VoidCallback callback) {
		require(eventType, "eventType is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/{eventType}/events") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("eventType", eventType) //
				.setBody(toJson(body));

		signRequest(client);
		client.send(callback);
	}

	public Future<EventsResponse> queryEvents(String eventType, String start, String end, String query,
			Callback<EventsResponse> callback) {
		require(eventType, "eventType is a required parameter.");
		require(end, "end is a required parameter.");
		require(query, "query is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/{eventType}/events") //
				.accepts("application/json") //
				.setPath("eventType", eventType) //
				.setQuery("start", start) //
				.setQuery("end", end) //
				.setQuery("query", query);

		signRequest(client);
		AsyncFuture<EventsResponse> future = client.future(callback);
		client.send(callbackAdapter(future, EventsResponse.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}