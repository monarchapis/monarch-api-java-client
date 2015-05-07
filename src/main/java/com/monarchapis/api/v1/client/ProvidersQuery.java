package com.monarchapis.api.v1.client;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ProvidersQuery {
	/** The collection offset */
	private Integer offset;

	/** The collection limit */
	private Integer limit;

	/** The provider identifier filter */
	private List<String> ids;

	/** The provider's label filter */
	private List<String> labels;

	private Boolean enabled;

	/** The provider's API key filter */
	private List<String> apiKeys;

	private ProvidersQuery(ProvidersQuery.Builder builder) {
		this.offset = builder.offset;
		this.limit = builder.limit;
		this.ids = builder.ids;
		this.labels = builder.labels;
		this.enabled = builder.enabled;
		this.apiKeys = builder.apiKeys;
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

	public List<String> getLabels() {
		return labels;
	}

	public Boolean isEnabled() {
		return enabled;
	}

	public List<String> getApiKeys() {
		return apiKeys;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public static class Builder {
		private Integer offset;
		private Integer limit;
		private List<String> ids;
		private List<String> labels;
		private Boolean enabled;
		private List<String> apiKeys;

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

		public Builder apiKeys(List<String> apiKeys) {
			this.apiKeys = apiKeys;
			return this;
		}

		public Builder apiKeys(String... apiKeys) {
			this.apiKeys = Arrays.asList(apiKeys);
			return this;
		}

		public ProvidersQuery build() {
			return new ProvidersQuery(this);
		}
	}
}
