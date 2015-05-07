package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.OpenResourceAsync;
import com.monarchapis.api.v1.model.ServiceInfo;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class OpenResourceAsyncImpl extends AbstractResource implements OpenResourceAsync {
	public OpenResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public OpenResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<ServiceInfo> getServiceInfo(String environmentName, String serviceName, String providerKey,
			Callback<ServiceInfo> callback) {
		require(environmentName, "environmentName is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/serviceInfo") //
				.accepts("application/json") //
				.setQuery("environmentName", environmentName) //
				.setQuery("serviceName", serviceName) //
				.setQuery("providerKey", providerKey);

		signRequest(client);
		AsyncFuture<ServiceInfo> future = client.future(callback);
		client.send(callbackAdapter(future, ServiceInfo.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}