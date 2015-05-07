package com.monarchapis.api.v1.client.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.monarchapis.api.v1.client.SecurityResource;
import com.monarchapis.api.v1.client.SecurityResourceAsync;
import com.monarchapis.api.v1.client.ServiceApi;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClientFactory;

public class ServiceApiImpl implements ServiceApi {
	private String baseUrl;
	private RestClientFactory clientFactory;
	private List<RequestProcessor> requestProcessors;

	public ServiceApiImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		this(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public ServiceApiImpl(String baseUrl, RestClientFactory clientFactory, List<RequestProcessor> requestProcessors) {
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

	public SecurityResource getSecurityResource() {
		return new SecurityResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public SecurityResourceAsync getSecurityResourceAsync() {
		return new SecurityResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}
}