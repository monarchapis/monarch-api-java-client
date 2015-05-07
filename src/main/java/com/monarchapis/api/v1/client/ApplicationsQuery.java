package com.monarchapis.api.v1.client;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Sets;

public class ApplicationsQuery {
	/** The collection offset */
	private Integer offset;

	/** The collection limit */
	private Integer limit;

	/** The application identifier filter */
	private Set<String> ids;

	/** The application name filter */
	private List<String> names;

	/** The application description filter */
	private List<String> descriptions;

	/** The application URL filter */
	private List<String> applicationUrls;

	/** The application image/logo URL filter */
	private List<String> applicationImageUrls;

	/** The company filter */
	private List<String> companyNames;

	/** The company URL filter */
	private List<String> companyUrls;

	/** The company image URL filter */
	private List<String> companyImageUrls;

	/** The callback URIs */
	private List<String> callbackUris;

	/** The plan identifier */
	private List<String> planIds;

	/** The external identifier */
	private List<String> externalIds;

	private ApplicationsQuery(ApplicationsQuery.Builder builder) {
		this.offset = builder.offset;
		this.limit = builder.limit;
		this.ids = builder.ids;
		this.names = builder.names;
		this.descriptions = builder.descriptions;
		this.applicationUrls = builder.applicationUrls;
		this.applicationImageUrls = builder.applicationImageUrls;
		this.companyNames = builder.companyNames;
		this.companyUrls = builder.companyUrls;
		this.companyImageUrls = builder.companyImageUrls;
		this.callbackUris = builder.callbackUris;
		this.planIds = builder.planIds;
		this.externalIds = builder.externalIds;
	}

	public Integer getOffset() {
		return offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public Set<String> getIds() {
		return ids;
	}

	public List<String> getNames() {
		return names;
	}

	public List<String> getDescriptions() {
		return descriptions;
	}

	public List<String> getApplicationUrls() {
		return applicationUrls;
	}

	public List<String> getApplicationImageUrls() {
		return applicationImageUrls;
	}

	public List<String> getCompanyNames() {
		return companyNames;
	}

	public List<String> getCompanyUrls() {
		return companyUrls;
	}

	public List<String> getCompanyImageUrls() {
		return companyImageUrls;
	}

	public List<String> getCallbackUris() {
		return callbackUris;
	}

	public List<String> getPlanIds() {
		return planIds;
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
		private Set<String> ids;
		private List<String> names;
		private List<String> descriptions;
		private List<String> applicationUrls;
		private List<String> applicationImageUrls;
		private List<String> companyNames;
		private List<String> companyUrls;
		private List<String> companyImageUrls;
		private List<String> callbackUris;
		private List<String> planIds;
		private List<String> externalIds;

		public Builder offset(Integer offset) {
			this.offset = offset;
			return this;
		}

		public Builder limit(Integer limit) {
			this.limit = limit;
			return this;
		}

		public Builder ids(Set<String> ids) {
			this.ids = ids;
			return this;
		}

		public Builder ids(String... ids) {
			this.ids = Sets.newHashSet(ids);
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

		public Builder applicationUrls(List<String> applicationUrls) {
			this.applicationUrls = applicationUrls;
			return this;
		}

		public Builder applicationUrls(String... applicationUrls) {
			this.applicationUrls = Arrays.asList(applicationUrls);
			return this;
		}

		public Builder applicationImageUrls(List<String> applicationImageUrls) {
			this.applicationImageUrls = applicationImageUrls;
			return this;
		}

		public Builder applicationImageUrls(String... applicationImageUrls) {
			this.applicationImageUrls = Arrays.asList(applicationImageUrls);
			return this;
		}

		public Builder companyNames(List<String> companyNames) {
			this.companyNames = companyNames;
			return this;
		}

		public Builder companyNames(String... companyNames) {
			this.companyNames = Arrays.asList(companyNames);
			return this;
		}

		public Builder companyUrls(List<String> companyUrls) {
			this.companyUrls = companyUrls;
			return this;
		}

		public Builder companyUrls(String... companyUrls) {
			this.companyUrls = Arrays.asList(companyUrls);
			return this;
		}

		public Builder companyImageUrls(List<String> companyImageUrls) {
			this.companyImageUrls = companyImageUrls;
			return this;
		}

		public Builder companyImageUrls(String... companyImageUrls) {
			this.companyImageUrls = Arrays.asList(companyImageUrls);
			return this;
		}

		public Builder callbackUris(List<String> callbackUris) {
			this.callbackUris = callbackUris;
			return this;
		}

		public Builder callbackUris(String... callbackUris) {
			this.callbackUris = Arrays.asList(callbackUris);
			return this;
		}

		public Builder planIds(List<String> planIds) {
			this.planIds = planIds;
			return this;
		}

		public Builder planIds(String... planIds) {
			this.planIds = Arrays.asList(planIds);
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

		public ApplicationsQuery build() {
			return new ApplicationsQuery(this);
		}
	}
}
