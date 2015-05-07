package com.monarchapis.api.v1.client;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PermissionsQuery {
	/** The collection offset */
	private Integer offset;

	/** The collection limit */
	private Integer limit;

	/** The permission identifier filter */
	private List<String> ids;

	/** The permission's name filter */
	private List<String> names;

	/** The permission's type filter */
	private List<String> types;

	/** The permission's description filter */
	private List<String> descriptions;

	/** The permission's scope filter */
	private List<String> scopes;

	/** The permission's message identifier filter */
	private List<String> messageIds;

	/** The permission's flag filter */
	private List<String> flags;

	private PermissionsQuery(PermissionsQuery.Builder builder) {
		this.offset = builder.offset;
		this.limit = builder.limit;
		this.ids = builder.ids;
		this.names = builder.names;
		this.types = builder.types;
		this.descriptions = builder.descriptions;
		this.scopes = builder.scopes;
		this.messageIds = builder.messageIds;
		this.flags = builder.flags;
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

	public List<String> getNames() {
		return names;
	}

	public List<String> getTypes() {
		return types;
	}

	public List<String> getDescriptions() {
		return descriptions;
	}

	public List<String> getScopes() {
		return scopes;
	}

	public List<String> getMessageIds() {
		return messageIds;
	}

	public List<String> getFlags() {
		return flags;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public static class Builder {
		private Integer offset;
		private Integer limit;
		private List<String> ids;
		private List<String> names;
		private List<String> types;
		private List<String> descriptions;
		private List<String> scopes;
		private List<String> messageIds;
		private List<String> flags;

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

		public Builder names(List<String> names) {
			this.names = names;
			return this;
		}

		public Builder names(String... names) {
			this.names = Arrays.asList(names);
			return this;
		}

		public Builder types(List<String> types) {
			this.types = types;
			return this;
		}

		public Builder types(String... types) {
			this.types = Arrays.asList(types);
			return this;
		}

		public Builder descriptions(List<String> descriptions) {
			this.descriptions = descriptions;
			return this;
		}

		public Builder descriptions(String... descriptions) {
			this.descriptions = Arrays.asList(descriptions);
			return this;
		}

		public Builder scopes(List<String> scopes) {
			this.scopes = scopes;
			return this;
		}

		public Builder scopes(String... scopes) {
			this.scopes = Arrays.asList(scopes);
			return this;
		}

		public Builder messageIds(List<String> messageIds) {
			this.messageIds = messageIds;
			return this;
		}

		public Builder messageIds(String... messageIds) {
			this.messageIds = Arrays.asList(messageIds);
			return this;
		}

		public Builder flags(List<String> flags) {
			this.flags = flags;
			return this;
		}

		public Builder flags(String... flags) {
			this.flags = Arrays.asList(flags);
			return this;
		}

		public PermissionsQuery build() {
			return new PermissionsQuery(this);
		}
	}
}
