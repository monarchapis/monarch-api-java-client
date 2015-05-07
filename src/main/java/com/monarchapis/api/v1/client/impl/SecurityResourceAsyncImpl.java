package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.SecurityResourceAsync;
import com.monarchapis.api.v1.model.AuthenticationRequest;
import com.monarchapis.api.v1.model.AuthenticationResponse;
import com.monarchapis.api.v1.model.AuthorizationDetails;
import com.monarchapis.api.v1.model.AuthorizationRequest;
import com.monarchapis.api.v1.model.ClientAuthenticationRequest;
import com.monarchapis.api.v1.model.MessageList;
import com.monarchapis.api.v1.model.PermissionMessagesRequest;
import com.monarchapis.api.v1.model.TokenDetails;
import com.monarchapis.api.v1.model.TokenRequest;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;
import com.monarchapis.client.rest.VoidCallback;

public class SecurityResourceAsyncImpl extends AbstractResource implements SecurityResourceAsync {
	public SecurityResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public SecurityResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<AuthenticationResponse> authenticateRequest(AuthenticationRequest body,
			Callback<AuthenticationResponse> callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/requests/authenticate") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<AuthenticationResponse> future = client.future(callback);
		client.send(callbackAdapter(future, AuthenticationResponse.class));

		return future;
	}

	public Future<AuthorizationDetails> getAuthorizationDetails(AuthorizationRequest body,
			Callback<AuthorizationDetails> callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/authorizations/details") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<AuthorizationDetails> future = client.future(callback);
		client.send(callbackAdapter(future, AuthorizationDetails.class));

		return future;
	}

	public void authenticateClient(ClientAuthenticationRequest body, VoidCallback callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/clients/authenticate") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		client.send(callback);
	}

	public Future<TokenDetails> createToken(TokenRequest body, Callback<TokenDetails> callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/tokens") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<TokenDetails> future = client.future(callback);
		client.send(callbackAdapter(future, TokenDetails.class));

		return future;
	}

	public Future<TokenDetails> loadClient(String apiKey, String token, String refresh, String callbackUri,
			Callback<TokenDetails> callback) {
		require(apiKey, "apiKey is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/tokens") //
				.accepts("application/json") //
				.setQuery("apiKey", apiKey) //
				.setQuery("token", token) //
				.setQuery("refresh", refresh) //
				.setQuery("callbackUri", callbackUri);

		signRequest(client);
		AsyncFuture<TokenDetails> future = client.future(callback);
		client.send(callbackAdapter(future, TokenDetails.class));

		return future;
	}

	public void deleteClient(String apiKey, String token, String callbackUri, VoidCallback callback) {
		require(apiKey, "apiKey is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/tokens") //
				.accepts("application/json") //
				.setQuery("apiKey", apiKey) //
				.setQuery("token", token) //
				.setQuery("callbackUri", callbackUri);

		signRequest(client);
		client.send(callback);
	}

	public Future<MessageList> getPermissionMessages(PermissionMessagesRequest body, Callback<MessageList> callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/permissions/messages") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<MessageList> future = client.future(callback);
		client.send(callbackAdapter(future, MessageList.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}