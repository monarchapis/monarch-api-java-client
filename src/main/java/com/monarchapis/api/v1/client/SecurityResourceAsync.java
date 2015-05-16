package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.AuthenticationRequest;
import com.monarchapis.api.v1.model.AuthenticationResponse;
import com.monarchapis.api.v1.model.AuthorizationDetails;
import com.monarchapis.api.v1.model.AuthorizationRequest;
import com.monarchapis.api.v1.model.ClientAuthenticationRequest;
import com.monarchapis.api.v1.model.MessageDetailsList;
import com.monarchapis.api.v1.model.PermissionMessagesRequest;
import com.monarchapis.api.v1.model.TokenDetails;
import com.monarchapis.api.v1.model.TokenRequest;
import com.monarchapis.client.rest.Callback;

public interface SecurityResourceAsync {

	public Future<AuthenticationResponse> authenticateRequest(AuthenticationRequest body,
			Callback<AuthenticationResponse> callback);

	public Future<AuthorizationDetails> getAuthorizationDetails(AuthorizationRequest body,
			Callback<AuthorizationDetails> callback);

	public Future<Void> authenticateClient(ClientAuthenticationRequest body, Callback<Void> callback);

	public Future<TokenDetails> createToken(TokenRequest body, Callback<TokenDetails> callback);

	public Future<TokenDetails> loadToken(String apiKey, String token, String refresh, String callbackUri,
			Callback<TokenDetails> callback);

	public Future<Void> revokeToken(String apiKey, String token, String callbackUri, Callback<Void> callback);

	public Future<MessageDetailsList> getPermissionMessages(PermissionMessagesRequest body,
			Callback<MessageDetailsList> callback);
}