package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.TokensQuery;
import com.monarchapis.api.v1.client.TokensResource;
import com.monarchapis.api.v1.model.Token;
import com.monarchapis.api.v1.model.TokenList;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class TokensResourceImpl extends AbstractResource implements TokensResource {
	public TokensResourceImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public TokensResourceImpl(String baseUrl, RestClientFactory clientFactory, List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public TokenList query(TokensQuery query) {
		final RestClient client = newClient("GET", "/tokens") //
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
		final RestResponse response = client.send();
		return parseAs(response, TokenList.class);
	}

	public Token create(Token body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/tokens") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Token.class);
	}

	public Token load(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/tokens/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Token.class);
	}

	public Token update(String id, Token body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/tokens/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Token.class);
	}

	public Token delete(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/tokens/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Token.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}