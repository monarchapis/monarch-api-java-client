package com.monarchapis.api.v1.client;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PrincipalClaimsQuery {
	/** The collection offset */
	private Integer offset;

	/** The collection limit */
	private Integer limit;

	/** The principal claims identifier filter */
	private List<String> ids;

	/** The principal claims's name filter */
	private List<String> names;

	/** The principal claims' inherited claims filter */
	private List<String> inherits;

	private PrincipalClaimsQuery(PrincipalClaimsQuery.Builder builder) {
		this.offset = builder.offset;
		this.limit = builder.limit;
		this.ids = builder.ids;
		this.names = builder.names;
		this.inherits = builder.inherits;
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

	public List<String> getInherits() {
		return inherits;
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
		private List<String> inherits;

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

		public Builder inherits(List<String> inherits) {
			this.inherits = inherits;
			return this;
		}

		public Builder inherits(String... inherits) {
			this.inherits = Arrays.asList(inherits);
			return this;
		}

		public PrincipalClaimsQuery build() {
			return new PrincipalClaimsQuery(this);
		}
	}
}
