package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.LogEntriesQuery;
import com.monarchapis.api.v1.client.LogEntriesResource;
import com.monarchapis.api.v1.model.LogEntry;
import com.monarchapis.api.v1.model.LogEntryList;
import com.monarchapis.api.v1.model.LogEntryUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class LogEntriesResourceImpl extends AbstractResource implements LogEntriesResource {
	public LogEntriesResourceImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public LogEntriesResourceImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public LogEntryList queryLogEntries(LogEntriesQuery query) {
		final RestClient client = newClient("GET", "/logEntries") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("level", query.getLevels(), CollectionFormat.PIPES) //
				.addQueryCollection("message", query.getMessages(), CollectionFormat.PIPES);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, LogEntryList.class);
	}

	public void createLogEntry(LogEntryUpdate body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/logEntries") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		client.send();
	}

	public LogEntry loadLogEntry(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/logEntries/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, LogEntry.class);
	}

	public LogEntry updateLogEntry(String id, LogEntryUpdate body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/logEntries/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, LogEntry.class);
	}

	public LogEntry deleteLogEntry(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/logEntries/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, LogEntry.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}