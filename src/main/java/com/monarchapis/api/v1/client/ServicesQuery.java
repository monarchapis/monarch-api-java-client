package com.monarchapis.api.v1.client;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ServicesQuery {
	/** The collection offset */
	private Integer offset;

	/** The collection limit */
	private Integer limit;

	/** The service identifier filter */
	private List<String> ids;

	/** The service's name filter */
	private List<String> names;

	/** The service's display name filter */
	private List<String> types;

	/** The service's description filter */
	private List<String> descriptions;

	private Boolean accessControl;

	/** The service's URI prefix filter */
	private List<String> uriPrefixes;

	/** The service's URI version location filter */
	private List<String> versionLocations;

	/** The service's default version filter */
	private List<String> defaultVersions;

	/** The service's flags filter */
	private List<String> flags;

	private ServicesQuery(ServicesQuery.Builder builder) {
		this.offset = builder.offset;
		this.limit = builder.limit;
		this.ids = builder.ids;
		this.names = builder.names;
		this.types = builder.types;
		this.descriptions = builder.descriptions;
		this.accessControl = builder.accessControl;
		this.uriPrefixes = builder.uriPrefixes;
		this.versionLocations = builder.versionLocations;
		this.defaultVersions = builder.defaultVersions;
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

	public Boolean isAccessControl() {
		return accessControl;
	}

	public List<String> getUriPrefixes() {
		return uriPrefixes;
	}

	public List<String> getVersionLocations() {
		return versionLocations;
	}

	public List<String> getDefaultVersions() {
		return defaultVersions;
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
		private Boolean accessControl;
		private List<String> uriPrefixes;
		private List<String> versionLocations;
		private List<String> defaultVersions;
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

		public Builder accessControl(Boolean accessControl) {
			this.accessControl = accessControl;
			return this;
		}

		public Builder uriPrefixes(List<String> uriPrefixes) {
			this.uriPrefixes = uriPrefixes;
			return this;
		}

		public Builder uriPrefixes(String... uriPrefixes) {
			this.uriPrefixes = Arrays.asList(uriPrefixes);
			return this;
		}

		public Builder versionLocations(List<String> versionLocations) {
			this.versionLocations = versionLocations;
			return this;
		}

		public Builder versionLocations(String... versionLocations) {
			this.versionLocations = Arrays.asList(versionLocations);
			return this;
		}

		public Builder defaultVersions(List<String> defaultVersions) {
			this.defaultVersions = defaultVersions;
			return this;
		}

		public Builder defaultVersions(String... defaultVersions) {
			this.defaultVersions = Arrays.asList(defaultVersions);
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

		public ServicesQuery build() {
			return new ServicesQuery(this);
		}
	}
}
