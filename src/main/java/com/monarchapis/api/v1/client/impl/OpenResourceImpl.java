package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.OpenResource;
import com.monarchapis.api.v1.model.ServiceInfo;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class OpenResourceImpl extends AbstractResource implements OpenResource {
	public OpenResourceImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public OpenResourceImpl(String baseUrl, RestClientFactory clientFactory, List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public ServiceInfo getServiceInfo(String environmentName, String serviceName, String providerKey) {
		require(environmentName, "environmentName is a required parameter.");

		final RestClient client = newClient("GET", "/serviceInfo") //
				.accepts("application/json") //
				.setQuery("environmentName", environmentName) //
				.setQuery("serviceName", serviceName) //
				.setQuery("providerKey", providerKey);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, ServiceInfo.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}