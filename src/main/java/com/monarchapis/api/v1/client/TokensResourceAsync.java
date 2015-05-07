package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Token;
import com.monarchapis.api.v1.model.TokenList;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.VoidCallback;

public interface TokensResourceAsync {

	public Future<TokenList> queryTokens(TokensQuery query, Callback<TokenList> callback);

	public void createToken(Token body, VoidCallback callback);

	public Future<Token> loadToken(String id, Callback<Token> callback);

	public Future<Token> updateToken(String id, Token body, Callback<Token> callback);

	public Future<Token> deleteToken(String id, Callback<Token> callback);
}