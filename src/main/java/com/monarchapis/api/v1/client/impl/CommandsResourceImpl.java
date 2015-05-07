package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.CommandsResource;
import com.monarchapis.api.v1.model.ObjectData;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class CommandsResourceImpl extends AbstractResource implements CommandsResource {
	public CommandsResourceImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public CommandsResourceImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public ObjectData processCommand(String commandType, ObjectData body) {
		require(commandType, "commandType is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/{commandType}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("commandType", commandType) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, ObjectData.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}