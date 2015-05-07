package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.AuthenticationRequest;
import com.monarchapis.api.v1.model.AuthenticationResponse;
import com.monarchapis.api.v1.model.AuthorizationDetails;
import com.monarchapis.api.v1.model.AuthorizationRequest;
import com.monarchapis.api.v1.model.ClientAuthenticationRequest;
import com.monarchapis.api.v1.model.MessageList;
import com.monarchapis.api.v1.model.PermissionMessagesRequest;
import com.monarchapis.api.v1.model.TokenDetails;
import com.monarchapis.api.v1.model.TokenRequest;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.VoidCallback;

public interface SecurityResourceAsync {

	public Future<AuthenticationResponse> authenticateRequest(AuthenticationRequest body,
			Callback<AuthenticationResponse> callback);

	public Future<AuthorizationDetails> getAuthorizationDetails(AuthorizationRequest body,
			Callback<AuthorizationDetails> callback);

	public void authenticateClient(ClientAuthenticationRequest body, VoidCallback callback);

	public Future<TokenDetails> createToken(TokenRequest body, Callback<TokenDetails> callback);

	public Future<TokenDetails> loadClient(String apiKey, String token, String refresh, String callbackUri,
			Callback<TokenDetails> callback);

	public void deleteClient(String apiKey, String token, String callbackUri, VoidCallback callback);

	public Future<MessageList> getPermissionMessages(PermissionMessagesRequest body, Callback<MessageList> callback);
}