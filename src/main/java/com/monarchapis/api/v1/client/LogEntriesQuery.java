package com.monarchapis.api.v1.client;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class LogEntriesQuery {
	/** The collection offset */
	private Integer offset;

	/** The collection limit */
	private Integer limit;

	/** The log entry identifier filter */
	private List<String> ids;

	/** The log entry level filter */
	private List<String> levels;

	/** The log entry message filter */
	private List<String> messages;

	private LogEntriesQuery(LogEntriesQuery.Builder builder) {
		this.offset = builder.offset;
		this.limit = builder.limit;
		this.ids = builder.ids;
		this.levels = builder.levels;
		this.messages = builder.messages;
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

	public List<String> getLevels() {
		return levels;
	}

	public List<String> getMessages() {
		return messages;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public static class Builder {
		private Integer offset;
		private Integer limit;
		private List<String> ids;
		private List<String> levels;
		private List<String> messages;

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

		public Builder levels(List<String> levels) {
			this.levels = levels;
			return this;
		}

		public Builder levels(String... levels) {
			this.levels = Arrays.asList(levels);
			return this;
		}

		public Builder messages(List<String> messages) {
			this.messages = messages;
			return this;
		}

		public Builder messages(String... messages) {
			this.messages = Arrays.asList(messages);
			return this;
		}

		public LogEntriesQuery build() {
			return new LogEntriesQuery(this);
		}
	}
}
