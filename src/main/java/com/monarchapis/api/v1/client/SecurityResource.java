package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.AuthenticationRequest;
import com.monarchapis.api.v1.model.AuthenticationResponse;
import com.monarchapis.api.v1.model.AuthorizationDetails;
import com.monarchapis.api.v1.model.AuthorizationRequest;
import com.monarchapis.api.v1.model.ClientAuthenticationRequest;
import com.monarchapis.api.v1.model.MessageList;
import com.monarchapis.api.v1.model.PermissionMessagesRequest;
import com.monarchapis.api.v1.model.TokenDetails;
import com.monarchapis.api.v1.model.TokenRequest;

public interface SecurityResource {

	public AuthenticationResponse authenticateRequest(AuthenticationRequest body);

	public AuthorizationDetails getAuthorizationDetails(AuthorizationRequest body);

	public void authenticateClient(ClientAuthenticationRequest body);

	public TokenDetails createToken(TokenRequest body);

	public TokenDetails loadToken(String apiKey, String token, String refresh, String callbackUri);

	public void revokeToken(String apiKey, String token, String callbackUri);

	public MessageList getPermissionMessages(PermissionMessagesRequest body);
}