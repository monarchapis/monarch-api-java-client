package com.monarchapis.api.v1.client;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class EnvironmentsQuery {
	/** The collection offset */
	private Integer offset;

	/** The collection limit */
	private Integer limit;

	/** The environment identifier filter */
	private List<String> ids;

	/** The environment's name */
	private List<String> names;

	/** The environment's description */
	private List<String> descriptions;

	/** The environment's system database */
	private List<String> systemDatabases;

	/** The environment's analytics database */
	private List<String> analyticsDatabases;

	private EnvironmentsQuery(EnvironmentsQuery.Builder builder) {
		this.offset = builder.offset;
		this.limit = builder.limit;
		this.ids = builder.ids;
		this.names = builder.names;
		this.descriptions = builder.descriptions;
		this.systemDatabases = builder.systemDatabases;
		this.analyticsDatabases = builder.analyticsDatabases;
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

	public List<String> getDescriptions() {
		return descriptions;
	}

	public List<String> getSystemDatabases() {
		return systemDatabases;
	}

	public List<String> getAnalyticsDatabases() {
		return analyticsDatabases;
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
		private List<String> descriptions;
		private List<String> systemDatabases;
		private List<String> analyticsDatabases;

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

		public Builder descriptions(List<String> descriptions) {
			this.descriptions = descriptions;
			return this;
		}

		public Builder descriptions(String... descriptions) {
			this.descriptions = Arrays.asList(descriptions);
			return this;
		}

		public Builder systemDatabases(List<String> systemDatabases) {
			this.systemDatabases = systemDatabases;
			return this;
		}

		public Builder systemDatabases(String... systemDatabases) {
			this.systemDatabases = Arrays.asList(systemDatabases);
			return this;
		}

		public Builder analyticsDatabases(List<String> analyticsDatabases) {
			this.analyticsDatabases = analyticsDatabases;
			return this;
		}

		public Builder analyticsDatabases(String... analyticsDatabases) {
			this.analyticsDatabases = Arrays.asList(analyticsDatabases);
			return this;
		}

		public EnvironmentsQuery build() {
			return new EnvironmentsQuery(this);
		}
	}
}
