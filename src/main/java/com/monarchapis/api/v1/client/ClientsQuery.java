package com.monarchapis.api.v1.client;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ClientsQuery {
	/** The collection offset */
	private Integer offset;

	/** The collection limit */
	private Integer limit;

	/** The client identifier filter */
	private List<String> ids;

	/** The client's application identifier */
	private List<String> applicationIds;

	/** The client's label */
	private List<String> labels;

	/** The enabled flag */
	private Boolean enabled;

	/** The client status (awaiting, approved, rejected) */
	private List<String> statuses;

	/** The client's API key */
	private List<String> apiKeys;

	/** The client's external identifier */
	private List<String> externalIds;

	private ClientsQuery(ClientsQuery.Builder builder) {
		this.offset = builder.offset;
		this.limit = builder.limit;
		this.ids = builder.ids;
		this.applicationIds = builder.applicationIds;
		this.labels = builder.labels;
		this.enabled = builder.enabled;
		this.statuses = builder.statuses;
		this.apiKeys = builder.apiKeys;
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

	public List<String> getApplicationIds() {
		return applicationIds;
	}

	public List<String> getLabels() {
		return labels;
	}

	public Boolean isEnabled() {
		return enabled;
	}

	public List<String> getStatuses() {
		return statuses;
	}

	public List<String> getApiKeys() {
		return apiKeys;
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
		private List<String> applicationIds;
		private List<String> labels;
		private Boolean enabled;
		private List<String> statuses;
		private List<String> apiKeys;
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

		public Builder applicationIds(List<String> applicationIds) {
			this.applicationIds = applicationIds;
			return this;
		}

		public Builder applicationIds(String... applicationIds) {
			this.applicationIds = Arrays.asList(applicationIds);
			return this;
		}

		public Builder labels(List<String> labels) {
			this.labels = labels;
			return this;
		}

		public Builder labels(String... labels) {
			this.labels = Arrays.asList(labels);
			return this;
		}

		public Builder enabled(Boolean enabled) {
			this.enabled = enabled;
			return this;
		}

		public Builder statuses(List<String> statuses) {
			this.statuses = statuses;
			return this;
		}

		public Builder statuses(String... statuses) {
			this.statuses = Arrays.asList(statuses);
			return this;
		}

		public Builder apiKeys(List<String> apiKeys) {
			this.apiKeys = apiKeys;
			return this;
		}

		public Builder apiKeys(String... apiKeys) {
			this.apiKeys = Arrays.asList(apiKeys);
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

		public ClientsQuery build() {
			return new ClientsQuery(this);
		}
	}
}
