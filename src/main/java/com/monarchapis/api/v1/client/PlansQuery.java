package com.monarchapis.api.v1.client;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PlansQuery {
	/** The collection offset */
	private Integer offset;

	/** The collection limit */
	private Integer limit;

	/** The plan identifier filter */
	private List<String> ids;

	/** The plan's name filter */
	private List<String> names;

	/** The plan's price amount filter */
	private List<Float> priceAmounts;

	/** The plan's price currency filter */
	private List<String> priceCurrencies;

	private PlansQuery(PlansQuery.Builder builder) {
		this.offset = builder.offset;
		this.limit = builder.limit;
		this.ids = builder.ids;
		this.names = builder.names;
		this.priceAmounts = builder.priceAmounts;
		this.priceCurrencies = builder.priceCurrencies;
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

	public List<Float> getPriceAmounts() {
		return priceAmounts;
	}

	public List<String> getPriceCurrencies() {
		return priceCurrencies;
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
		private List<Float> priceAmounts;
		private List<String> priceCurrencies;

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

		public Builder priceAmounts(List<Float> priceAmounts) {
			this.priceAmounts = priceAmounts;
			return this;
		}

		public Builder priceAmounts(Float... priceAmounts) {
			this.priceAmounts = Arrays.asList(priceAmounts);
			return this;
		}

		public Builder priceCurrencies(List<String> priceCurrencies) {
			this.priceCurrencies = priceCurrencies;
			return this;
		}

		public Builder priceCurrencies(String... priceCurrencies) {
			this.priceCurrencies = Arrays.asList(priceCurrencies);
			return this;
		}

		public PlansQuery build() {
			return new PlansQuery(this);
		}
	}
}
