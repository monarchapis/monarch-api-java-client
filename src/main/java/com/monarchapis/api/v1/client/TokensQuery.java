package com.monarchapis.api.v1.client;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TokensQuery {
	/** The collection offset */
	private Integer offset;

	/** The collection limit */
	private Integer limit;

	/** The token identifier filter */
	private List<String> ids;

	/** The token's client identifier filter */
	private List<String> clientIds;

	/** The token's scheme filter */
	private List<String> schemes;

	/** The token's value filter */
	private List<String> tokens;

	/** The token's refresh token filter */
	private List<String> refreshTokens;

	/** The token's type filter */
	private List<String> tokenTypes;

	/** The token's grant type filter */
	private List<String> grantTypes;

	/** The token's lifecycle filter */
	private List<String> lifecycles;

	/** The token's user code filter */
	private List<String> userCodes;

	/** The token's from token filter */
	private List<String> fromTokens;

	/** The token's permission identifier filter */
	private List<String> permissionIds;

	/** The token's state filter */
	private List<String> states;

	/** The token's URI filter */
	private List<String> uris;

	/** The token's user identifier filter */
	private List<String> userIds;

	/** The token's user context filter */
	private List<String> userContexts;

	/** The token's external identifier filter */
	private List<String> externalIds;

	private TokensQuery(TokensQuery.Builder builder) {
		this.offset = builder.offset;
		this.limit = builder.limit;
		this.ids = builder.ids;
		this.clientIds = builder.clientIds;
		this.schemes = builder.schemes;
		this.tokens = builder.tokens;
		this.refreshTokens = builder.refreshTokens;
		this.tokenTypes = builder.tokenTypes;
		this.grantTypes = builder.grantTypes;
		this.lifecycles = builder.lifecycles;
		this.userCodes = builder.userCodes;
		this.fromTokens = builder.fromTokens;
		this.permissionIds = builder.permissionIds;
		this.states = builder.states;
		this.uris = builder.uris;
		this.userIds = builder.userIds;
		this.userContexts = builder.userContexts;
		this.externalIds = builder.externalIds;
	}

	public Integer getOffset() {
		return offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public List<String> getIds() {
		return ids;
	}

	public List<String> getClientIds() {
		return clientIds;
	}

	public List<String> getSchemes() {
		return schemes;
	}

	public List<String> getTokens() {
		return tokens;
	}

	public List<String> getRefreshTokens() {
		return refreshTokens;
	}

	public List<String> getTokenTypes() {
		return tokenTypes;
	}

	public List<String> getGrantTypes() {
		return grantTypes;
	}

	public List<String> getLifecycles() {
		return lifecycles;
	}

	public List<String> getUserCodes() {
		return userCodes;
	}

	public List<String> getFromTokens() {
		return fromTokens;
	}

	public List<String> getPermissionIds() {
		return permissionIds;
	}

	public List<String> getStates() {
		return states;
	}

	public List<String> getUris() {
		return uris;
	}

	public List<String> getUserIds() {
		return userIds;
	}

	public List<String> getUserContexts() {
		return userContexts;
	}

	public List<String> getExternalIds() {
		return externalIds;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public static class Builder {
		private Integer offset;
		private Integer limit;
		private List<String> ids;
		private List<String> clientIds;
		private List<String> schemes;
		private List<String> tokens;
		private List<String> refreshTokens;
		private List<String> tokenTypes;
		private List<String> grantTypes;
		private List<String> lifecycles;
		private List<String> userCodes;
		private List<String> fromTokens;
		private List<String> permissionIds;
		private List<String> states;
		private List<String> uris;
		private List<String> userIds;
		private List<String> userContexts;
		private List<String> externalIds;

		public Builder offset(Integer offset) {
			this.offset = offset;
			return this;
		}

		public Builder limit(Integer limit) {
			this.limit = limit;
			return this;
		}

		public Builder ids(List<String> ids) {
			this.ids = ids;
			return this;
		}

		public Builder ids(String... ids) {
			this.ids = Arrays.asList(ids);
			return this;
		}

		public Builder clientIds(List<String> clientIds) {
			this.clientIds = clientIds;
			return this;
		}

		public Builder clientIds(String... clientIds) {
			this.clientIds = Arrays.asList(clientIds);
			return this;
		}

		public Builder schemes(List<String> schemes) {
			this.schemes = schemes;
			return this;
		}

		public Builder schemes(String... schemes) {
			this.schemes = Arrays.asList(schemes);
			return this;
		}

		public Builder tokens(List<String> tokens) {
			this.tokens = tokens;
			return this;
		}

		public Builder tokens(String... tokens) {
			this.tokens = Arrays.asList(tokens);
			return this;
		}

		public Builder refreshTokens(List<String> refreshTokens) {
			this.refreshTokens = refreshTokens;
			return this;
		}

		public Builder refreshTokens(String... refreshTokens) {
			this.refreshTokens = Arrays.asList(refreshTokens);
			return this;
		}

		public Builder tokenTypes(List<String> tokenTypes) {
			this.tokenTypes = tokenTypes;
			return this;
		}

		public Builder tokenTypes(String... tokenTypes) {
			this.tokenTypes = Arrays.asList(tokenTypes);
			return this;
		}

		public Builder grantTypes(List<String> grantTypes) {
			this.grantTypes = grantTypes;
			return this;
		}

		public Builder grantTypes(String... grantTypes) {
			this.grantTypes = Arrays.asList(grantTypes);
			return this;
		}

		public Builder lifecycles(List<String> lifecycles) {
			this.lifecycles = lifecycles;
			return this;
		}

		public Builder lifecycles(String... lifecycles) {
			this.lifecycles = Arrays.asList(lifecycles);
			return this;
		}

		public Builder userCodes(List<String> userCodes) {
			this.userCodes = userCodes;
			return this;
		}

		public Builder userCodes(String... userCodes) {
			this.userCodes = Arrays.asList(userCodes);
			return this;
		}

		public Builder fromTokens(List<String> fromTokens) {
			this.fromTokens = fromTokens;
			return this;
		}

		public Builder fromTokens(String... fromTokens) {
			this.fromTokens = Arrays.asList(fromTokens);
			return this;
		}

		public Builder permissionIds(List<String> permissionIds) {
			this.permissionIds = permissionIds;
			return this;
		}

		public Builder permissionIds(String... permissionIds) {
			this.permissionIds = Arrays.asList(permissionIds);
			return this;
		}

		public Builder states(List<String> states) {
			this.states = states;
			return this;
		}

		public Builder states(String... states) {
			this.states = Arrays.asList(states);
			return this;
		}

		public Builder uris(List<String> uris) {
			this.uris = uris;
			return this;
		}

		public Builder uris(String... uris) {
			this.uris = Arrays.asList(uris);
			return this;
		}

		public Builder userIds(List<String> userIds) {
			this.userIds = userIds;
			return this;
		}

		public Builder userIds(String... userIds) {
			this.userIds = Arrays.asList(userIds);
			return this;
		}

		public Builder userContexts(List<String> userContexts) {
			this.userContexts = userContexts;
			return this;
		}

		public Builder userContexts(String... userContexts) {
			this.userContexts = Arrays.asList(userContexts);
			return this;
		}

		public Builder externalIds(List<String> externalIds) {
			this.externalIds = externalIds;
			return this;
		}

		public Builder externalIds(String... externalIds) {
			this.externalIds = Arrays.asList(externalIds);
			return this;
		}

		public TokensQuery build() {
			return new TokensQuery(this);
		}
	}
}
