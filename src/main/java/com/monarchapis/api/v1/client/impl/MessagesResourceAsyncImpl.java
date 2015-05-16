package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.MessagesQuery;
import com.monarchapis.api.v1.client.MessagesResourceAsync;
import com.monarchapis.api.v1.model.Message;
import com.monarchapis.api.v1.model.MessageList;
import com.monarchapis.api.v1.model.MessageUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class MessagesResourceAsyncImpl extends AbstractResource implements MessagesResourceAsync {
	public MessagesResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public MessagesResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<MessageList> queryMessages(MessagesQuery query, Callback<MessageList> callback) {
		final RestAsyncClient client = newAsyncClient("GET", "/messages") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("parentId", query.getParentIds(), CollectionFormat.PIPES) //
				.addQueryCollection("key", query.getKeys(), CollectionFormat.PIPES);

		signRequest(client);
		AsyncFuture<MessageList> future = client.future(callback);
		client.send(callbackAdapter(future, MessageList.class));

		return future;
	}

	public Future<Message> createMessage(MessageUpdate body, Callback<Message> callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/messages") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Message> future = client.future(callback);
		client.send(callbackAdapter(future, Message.class));

		return future;
	}

	public Future<Message> loadMessage(String id, Callback<Message> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/messages/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Message> future = client.future(callback);
		client.send(callbackAdapter(future, Message.class));

		return future;
	}

	public Future<Message> updateMessage(String id, MessageUpdate body, Callback<Message> callback) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/messages/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Message> future = client.future(callback);
		client.send(callbackAdapter(future, Message.class));

		return future;
	}

	public Future<Message> deleteMessage(String id, Callback<Message> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/messages/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Message> future = client.future(callback);
		client.send(callbackAdapter(future, Message.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}