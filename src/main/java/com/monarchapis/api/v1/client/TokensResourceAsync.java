package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Token;
import com.monarchapis.api.v1.model.TokenList;
import com.monarchapis.client.rest.Callback;

public interface TokensResourceAsync {

	public Future<TokenList> query(TokensQuery query, Callback<TokenList> callback);

	public Future<Token> create(Token body, Callback<Token> callback);

	public Future<Token> load(String id, Callback<Token> callback);

	public Future<Token> update(String id, Token body, Callback<Token> callback);

	public Future<Token> delete(String id, Callback<Token> callback);
}