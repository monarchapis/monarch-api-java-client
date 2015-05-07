package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.LogEntriesQuery;
import com.monarchapis.api.v1.client.LogEntriesResourceAsync;
import com.monarchapis.api.v1.model.LogEntry;
import com.monarchapis.api.v1.model.LogEntryList;
import com.monarchapis.api.v1.model.LogEntryUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;
import com.monarchapis.client.rest.VoidCallback;

public class LogEntriesResourceAsyncImpl extends AbstractResource implements LogEntriesResourceAsync {
	public LogEntriesResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public LogEntriesResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<LogEntryList> queryLogEntries(LogEntriesQuery query, Callback<LogEntryList> callback) {
		final RestAsyncClient client = newAsyncClient("GET", "/logEntries") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("level", query.getLevels(), CollectionFormat.PIPES) //
				.addQueryCollection("message", query.getMessages(), CollectionFormat.PIPES);

		signRequest(client);
		AsyncFuture<LogEntryList> future = client.future(callback);
		client.send(callbackAdapter(future, LogEntryList.class));

		return future;
	}

	public void createLogEntry(LogEntryUpdate body, VoidCallback callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/logEntries") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		client.send(callback);
	}

	public Future<LogEntry> loadLogEntry(String id, Callback<LogEntry> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/logEntries/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<LogEntry> future = client.future(callback);
		client.send(callbackAdapter(future, LogEntry.class));

		return future;
	}

	public Future<LogEntry> updateLogEntry(String id, LogEntryUpdate body, Callback<LogEntry> callback) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/logEntries/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<LogEntry> future = client.future(callback);
		client.send(callbackAdapter(future, LogEntry.class));

		return future;
	}

	public Future<LogEntry> deleteLogEntry(String id, Callback<LogEntry> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/logEntries/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<LogEntry> future = client.future(callback);
		client.send(callbackAdapter(future, LogEntry.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}