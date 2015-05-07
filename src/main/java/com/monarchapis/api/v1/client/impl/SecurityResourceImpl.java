package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.SecurityResource;
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
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class SecurityResourceImpl extends AbstractResource implements SecurityResource {
	public SecurityResourceImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public SecurityResourceImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public AuthenticationResponse authenticateRequest(AuthenticationRequest body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/requests/authenticate") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, AuthenticationResponse.class);
	}

	public AuthorizationDetails getAuthorizationDetails(AuthorizationRequest body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/authorizations/details") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, AuthorizationDetails.class);
	}

	public void authenticateClient(ClientAuthenticationRequest body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/clients/authenticate") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		checkStatusCode(response);
	}

	public TokenDetails createToken(TokenRequest body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/tokens") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, TokenDetails.class);
	}

	public TokenDetails loadToken(String apiKey, String token, String refresh, String callbackUri) {
		require(apiKey, "apiKey is a required parameter.");

		final RestClient client = newClient("GET", "/tokens") //
				.accepts("application/json") //
				.setQuery("apiKey", apiKey) //
				.setQuery("token", token) //
				.setQuery("refresh", refresh) //
				.setQuery("callbackUri", callbackUri);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, TokenDetails.class);
	}

	public void revokeToken(String apiKey, String token, String callbackUri) {
		require(apiKey, "apiKey is a required parameter.");

		final RestClient client = newClient("DELETE", "/tokens") //
				.accepts("application/json") //
				.setQuery("apiKey", apiKey) //
				.setQuery("token", token) //
				.setQuery("callbackUri", callbackUri);

		signRequest(client);
		client.send();
	}

	public MessageList getPermissionMessages(PermissionMessagesRequest body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/permissions/messages") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, MessageList.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}