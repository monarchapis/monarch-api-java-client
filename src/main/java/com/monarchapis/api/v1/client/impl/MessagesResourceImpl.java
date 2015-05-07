package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.MessagesQuery;
import com.monarchapis.api.v1.client.MessagesResource;
import com.monarchapis.api.v1.model.Message;
import com.monarchapis.api.v1.model.MessageList;
import com.monarchapis.api.v1.model.MessageUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class MessagesResourceImpl extends AbstractResource implements MessagesResource {
	public MessagesResourceImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public MessagesResourceImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public MessageList queryMessages(MessagesQuery query) {
		final RestClient client = newClient("GET", "/messages") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("parentId", query.getParentIds(), CollectionFormat.PIPES) //
				.addQueryCollection("key", query.getKeys(), CollectionFormat.PIPES);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, MessageList.class);
	}

	public void createMessage(MessageUpdate body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/messages") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		client.send();
	}

	public Message loadMessage(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/messages/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Message.class);
	}

	public Message updateMessage(String id, MessageUpdate body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/messages/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Message.class);
	}

	public Message deleteMessage(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/messages/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Message.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}