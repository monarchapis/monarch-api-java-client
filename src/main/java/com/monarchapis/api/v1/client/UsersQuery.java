package com.monarchapis.api.v1.client;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UsersQuery {
	/** The collection offset */
	private Integer offset;

	/** The collection limit */
	private Integer limit;

	/** The user identifier filter */
	private List<String> ids;

	/** The user's username filter */
	private List<String> userNames;

	/** The user's first name filter */
	private List<String> firstNames;

	/** The user's last name filter */
	private List<String> lastNames;

	/** Flag that denotes the user is a system administrator */
	private Boolean administrator;

	/** The user's external identifier filter */
	private List<String> externalIds;

	private UsersQuery(UsersQuery.Builder builder) {
		this.offset = builder.offset;
		this.limit = builder.limit;
		this.ids = builder.ids;
		this.userNames = builder.userNames;
		this.firstNames = builder.firstNames;
		this.lastNames = builder.lastNames;
		this.administrator = builder.administrator;
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

	public List<String> getUserNames() {
		return userNames;
	}

	public List<String> getFirstNames() {
		return firstNames;
	}

	public List<String> getLastNames() {
		return lastNames;
	}

	public Boolean isAdministrator() {
		return administrator;
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
		private List<String> userNames;
		private List<String> firstNames;
		private List<String> lastNames;
		private Boolean administrator;
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

		public Builder userNames(List<String> userNames) {
			this.userNames = userNames;
			return this;
		}

		public Builder userNames(String... userNames) {
			this.userNames = Arrays.asList(userNames);
			return this;
		}

		public Builder firstNames(List<String> firstNames) {
			this.firstNames = firstNames;
			return this;
		}

		public Builder firstNames(String... firstNames) {
			this.firstNames = Arrays.asList(firstNames);
			return this;
		}

		public Builder lastNames(List<String> lastNames) {
			this.lastNames = lastNames;
			return this;
		}

		public Builder lastNames(String... lastNames) {
			this.lastNames = Arrays.asList(lastNames);
			return this;
		}

		public Builder administrator(Boolean administrator) {
			this.administrator = administrator;
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

		public UsersQuery build() {
			return new UsersQuery(this);
		}
	}
}
