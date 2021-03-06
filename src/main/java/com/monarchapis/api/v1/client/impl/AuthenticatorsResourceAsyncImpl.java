package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.AuthenticatorsResourceAsync;
import com.monarchapis.api.v1.model.ConfigurableList;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class AuthenticatorsResourceAsyncImpl extends AbstractResource implements AuthenticatorsResourceAsync {
	public AuthenticatorsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public AuthenticatorsResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<ConfigurableList> listAuthenticators(Callback<ConfigurableList> callback) {

		final RestAsyncClient client = newAsyncClient("GET", "/authenticators") //
				.accepts("application/json");

		signRequest(client);
		AsyncFuture<ConfigurableList> future = client.future(callback);
		client.send(callbackAdapter(future, ConfigurableList.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}