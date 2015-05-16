package com.monarchapis.api.v1.client.impl;

import java.util.List;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.TokensQuery;
import com.monarchapis.api.v1.client.TokensResourceAsync;
import com.monarchapis.api.v1.model.Token;
import com.monarchapis.api.v1.model.TokenList;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.AsyncFuture;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestAsyncClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class TokensResourceAsyncImpl extends AbstractResource implements TokensResourceAsync {
	public TokensResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public TokensResourceAsyncImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public Future<TokenList> queryTokens(TokensQuery query, Callback<TokenList> callback) {
		final RestAsyncClient client = newAsyncClient("GET", "/tokens") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("clientId", query.getClientIds(), CollectionFormat.PIPES) //
				.addQueryCollection("scheme", query.getSchemes(), CollectionFormat.PIPES) //
				.addQueryCollection("token", query.getTokens(), CollectionFormat.PIPES) //
				.addQueryCollection("refreshToken", query.getRefreshTokens(), CollectionFormat.PIPES) //
				.addQueryCollection("tokenType", query.getTokenTypes(), CollectionFormat.PIPES) //
				.addQueryCollection("grantType", query.getGrantTypes(), CollectionFormat.PIPES) //
				.addQueryCollection("lifecycle", query.getLifecycles(), CollectionFormat.PIPES) //
				.addQueryCollection("userCode", query.getUserCodes(), CollectionFormat.PIPES) //
				.addQueryCollection("fromToken", query.getFromTokens(), CollectionFormat.PIPES) //
				.addQueryCollection("permissionIds", query.getPermissionIds(), CollectionFormat.PIPES) //
				.addQueryCollection("state", query.getStates(), CollectionFormat.PIPES) //
				.addQueryCollection("uri", query.getUris(), CollectionFormat.PIPES) //
				.addQueryCollection("userId", query.getUserIds(), CollectionFormat.PIPES) //
				.addQueryCollection("userContext", query.getUserContexts(), CollectionFormat.PIPES) //
				.addQueryCollection("externalId", query.getExternalIds(), CollectionFormat.PIPES);

		signRequest(client);
		AsyncFuture<TokenList> future = client.future(callback);
		client.send(callbackAdapter(future, TokenList.class));

		return future;
	}

	public Future<Token> createToken(Token body, Callback<Token> callback) {
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("POST", "/tokens") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Token> future = client.future(callback);
		client.send(callbackAdapter(future, Token.class));

		return future;
	}

	public Future<Token> loadToken(String id, Callback<Token> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("GET", "/tokens/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Token> future = client.future(callback);
		client.send(callbackAdapter(future, Token.class));

		return future;
	}

	public Future<Token> updateToken(String id, Token body, Callback<Token> callback) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestAsyncClient client = newAsyncClient("PUT", "/tokens/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		AsyncFuture<Token> future = client.future(callback);
		client.send(callbackAdapter(future, Token.class));

		return future;
	}

	public Future<Token> deleteToken(String id, Callback<Token> callback) {
		require(id, "id is a required parameter.");

		final RestAsyncClient client = newAsyncClient("DELETE", "/tokens/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		AsyncFuture<Token> future = client.future(callback);
		client.send(callbackAdapter(future, Token.class));

		return future;
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}