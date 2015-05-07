package com.monarchapis.api.v1.client;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class RolesQuery {
	/** The collection offset */
	private Integer offset;

	/** The collection limit */
	private Integer limit;

	/** The role identifier filter */
	private List<String> ids;

	/** The role's name filter */
	private List<String> roleNames;

	/** The role's display name filter */
	private List<String> displayNames;

	/** The role's description filter */
	private List<String> descriptions;

	private RolesQuery(RolesQuery.Builder builder) {
		this.offset = builder.offset;
		this.limit = builder.limit;
		this.ids = builder.ids;
		this.roleNames = builder.roleNames;
		this.displayNames = builder.displayNames;
		this.descriptions = builder.descriptions;
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

	public List<String> getRoleNames() {
		return roleNames;
	}

	public List<String> getDisplayNames() {
		return displayNames;
	}

	public List<String> getDescriptions() {
		return descriptions;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public static class Builder {
		private Integer offset;
		private Integer limit;
		private List<String> ids;
		private List<String> roleNames;
		private List<String> displayNames;
		private List<String> descriptions;

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

		public Builder roleNames(List<String> roleNames) {
			this.roleNames = roleNames;
			return this;
		}

		public Builder roleNames(String... roleNames) {
			this.roleNames = Arrays.asList(roleNames);
			return this;
		}

		public Builder displayNames(List<String> displayNames) {
			this.displayNames = displayNames;
			return this;
		}

		public Builder displayNames(String... displayNames) {
			this.displayNames = Arrays.asList(displayNames);
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

		public RolesQuery build() {
			return new RolesQuery(this);
		}
	}
}
