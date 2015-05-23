package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Token;
import com.monarchapis.api.v1.model.TokenList;

public interface TokensResource {

	public TokenList query(TokensQuery query);

	public Token create(Token body);

	public Token load(String id);

	public Token update(String id, Token body);

	public Token delete(String id);
}