package com.monarchapis.api.v1.client;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DevelopersQuery {
	/** The collection offset */
	private Integer offset;

	/** The collection limit */
	private Integer limit;

	/** The developer identifier filter */
	private List<String> ids;

	/** The developer's username */
	private List<String> usernames;

	/** The developer's first name */
	private List<String> firstNames;

	/** The developer's last name */
	private List<String> lastNames;

	/** The developer's roles (for use on the developer portal) */
	private List<String> roles;

	/** The developer's company */
	private List<String> companies;

	/** The developer's title */
	private List<String> titles;

	/** The developer's email */
	private List<String> emails;

	/** The developer's phone */
	private List<String> phones;

	/** The developer's mobile */
	private List<String> mobiles;

	/** The developer's address line 1 */
	private List<String> address1s;

	/** The developer's address line 2 */
	private List<String> address2s;

	/** The developer's locality */
	private List<String> localities;

	/** The developer's region */
	private List<String> regions;

	/** The developer's postal code */
	private List<String> postalCodes;

	/** The developer's country code */
	private List<String> countryCodes;

	/** The developer's registration IP address */
	private List<String> registrationIps;

	/** The developer's external identifier */
	private List<String> externalIds;

	private DevelopersQuery(DevelopersQuery.Builder builder) {
		this.offset = builder.offset;
		this.limit = builder.limit;
		this.ids = builder.ids;
		this.usernames = builder.usernames;
		this.firstNames = builder.firstNames;
		this.lastNames = builder.lastNames;
		this.roles = builder.roles;
		this.companies = builder.companies;
		this.titles = builder.titles;
		this.emails = builder.emails;
		this.phones = builder.phones;
		this.mobiles = builder.mobiles;
		this.address1s = builder.address1s;
		this.address2s = builder.address2s;
		this.localities = builder.localities;
		this.regions = builder.regions;
		this.postalCodes = builder.postalCodes;
		this.countryCodes = builder.countryCodes;
		this.registrationIps = builder.registrationIps;
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

	public List<String> getUsernames() {
		return usernames;
	}

	public List<String> getFirstNames() {
		return firstNames;
	}

	public List<String> getLastNames() {
		return lastNames;
	}

	public List<String> getRoles() {
		return roles;
	}

	public List<String> getCompanies() {
		return companies;
	}

	public List<String> getTitles() {
		return titles;
	}

	public List<String> getEmails() {
		return emails;
	}

	public List<String> getPhones() {
		return phones;
	}

	public List<String> getMobiles() {
		return mobiles;
	}

	public List<String> getAddress1s() {
		return address1s;
	}

	public List<String> getAddress2s() {
		return address2s;
	}

	public List<String> getLocalities() {
		return localities;
	}

	public List<String> getRegions() {
		return regions;
	}

	public List<String> getPostalCodes() {
		return postalCodes;
	}

	public List<String> getCountryCodes() {
		return countryCodes;
	}

	public List<String> getRegistrationIps() {
		return registrationIps;
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
		private List<String> usernames;
		private List<String> firstNames;
		private List<String> lastNames;
		private List<String> roles;
		private List<String> companies;
		private List<String> titles;
		private List<String> emails;
		private List<String> phones;
		private List<String> mobiles;
		private List<String> address1s;
		private List<String> address2s;
		private List<String> localities;
		private List<String> regions;
		private List<String> postalCodes;
		private List<String> countryCodes;
		private List<String> registrationIps;
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

		public Builder usernames(List<String> usernames) {
			this.usernames = usernames;
			return this;
		}

		public Builder usernames(String... usernames) {
			this.usernames = Arrays.asList(usernames);
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

		public Builder roles(List<String> roles) {
			this.roles = roles;
			return this;
		}

		public Builder roles(String... roles) {
			this.roles = Arrays.asList(roles);
			return this;
		}

		public Builder companies(List<String> companies) {
			this.companies = companies;
			return this;
		}

		public Builder companies(String... companies) {
			this.companies = Arrays.asList(companies);
			return this;
		}

		public Builder titles(List<String> titles) {
			this.titles = titles;
			return this;
		}

		public Builder titles(String... titles) {
			this.titles = Arrays.asList(titles);
			return this;
		}

		public Builder emails(List<String> emails) {
			this.emails = emails;
			return this;
		}

		public Builder emails(String... emails) {
			this.emails = Arrays.asList(emails);
			return this;
		}

		public Builder phones(List<String> phones) {
			this.phones = phones;
			return this;
		}

		public Builder phones(String... phones) {
			this.phones = Arrays.asList(phones);
			return this;
		}

		public Builder mobiles(List<String> mobiles) {
			this.mobiles = mobiles;
			return this;
		}

		public Builder mobiles(String... mobiles) {
			this.mobiles = Arrays.asList(mobiles);
			return this;
		}

		public Builder address1s(List<String> address1s) {
			this.address1s = address1s;
			return this;
		}

		public Builder address1s(String... address1s) {
			this.address1s = Arrays.asList(address1s);
			return this;
		}

		public Builder address2s(List<String> address2s) {
			this.address2s = address2s;
			return this;
		}

		public Builder address2s(String... address2s) {
			this.address2s = Arrays.asList(address2s);
			return this;
		}

		public Builder localities(List<String> localities) {
			this.localities = localities;
			return this;
		}

		public Builder localities(String... localities) {
			this.localities = Arrays.asList(localities);
			return this;
		}

		public Builder regions(List<String> regions) {
			this.regions = regions;
			return this;
		}

		public Builder regions(String... regions) {
			this.regions = Arrays.asList(regions);
			return this;
		}

		public Builder postalCodes(List<String> postalCodes) {
			this.postalCodes = postalCodes;
			return this;
		}

		public Builder postalCodes(String... postalCodes) {
			this.postalCodes = Arrays.asList(postalCodes);
			return this;
		}

		public Builder countryCodes(List<String> countryCodes) {
			this.countryCodes = countryCodes;
			return this;
		}

		public Builder countryCodes(String... countryCodes) {
			this.countryCodes = Arrays.asList(countryCodes);
			return this;
		}

		public Builder registrationIps(List<String> registrationIps) {
			this.registrationIps = registrationIps;
			return this;
		}

		public Builder registrationIps(String... registrationIps) {
			this.registrationIps = Arrays.asList(registrationIps);
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

		public DevelopersQuery build() {
			return new DevelopersQuery(this);
		}
	}
}
