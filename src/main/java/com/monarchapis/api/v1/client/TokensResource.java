package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Token;
import com.monarchapis.api.v1.model.TokenList;

public interface TokensResource {

	public TokenList queryTokens(TokensQuery query);

	public Token createToken(Token body);

	public Token loadToken(String id);

	public Token updateToken(String id, Token body);

	public Token deleteToken(String id);
}