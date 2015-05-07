package com.monarchapis.api.v1.client.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.monarchapis.api.v1.client.CommandApi;
import com.monarchapis.api.v1.client.CommandsResource;
import com.monarchapis.api.v1.client.CommandsResourceAsync;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClientFactory;

public class CommandApiImpl implements CommandApi {
	private String baseUrl;
	private RestClientFactory clientFactory;
	private List<RequestProcessor> requestProcessors;

	public CommandApiImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		this(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public CommandApiImpl(String baseUrl, RestClientFactory clientFactory, List<RequestProcessor> requestProcessors) {
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

	public CommandsResource getCommandsResource() {
		return new CommandsResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public CommandsResourceAsync getCommandsResourceAsync() {
		return new CommandsResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}
}