package com.monarchapis.api.v1.client;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MessagesQuery {
	/** The collection offset */
	private Integer offset;

	/** The collection limit */
	private Integer limit;

	/** The message identifier filter */
	private List<String> ids;

	/** The message's parent identifier filder */
	private List<String> parentIds;

	/** The message's key filter */
	private List<String> keys;

	private MessagesQuery(MessagesQuery.Builder builder) {
		this.offset = builder.offset;
		this.limit = builder.limit;
		this.ids = builder.ids;
		this.parentIds = builder.parentIds;
		this.keys = builder.keys;
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

	public List<String> getParentIds() {
		return parentIds;
	}

	public List<String> getKeys() {
		return keys;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public static class Builder {
		private Integer offset;
		private Integer limit;
		private List<String> ids;
		private List<String> parentIds;
		private List<String> keys;

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

		public Builder parentIds(List<String> parentIds) {
			this.parentIds = parentIds;
			return this;
		}

		public Builder parentIds(String... parentIds) {
			this.parentIds = Arrays.asList(parentIds);
			return this;
		}

		public Builder keys(List<String> keys) {
			this.keys = keys;
			return this;
		}

		public Builder keys(String... keys) {
			this.keys = Arrays.asList(keys);
			return this;
		}

		public MessagesQuery build() {
			return new MessagesQuery(this);
		}
	}
}
