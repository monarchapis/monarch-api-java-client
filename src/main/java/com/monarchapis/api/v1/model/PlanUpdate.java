package com.monarchapis.api.v1.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PlanUpdate implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String name;

	@NotNull
	private Float priceAmount;

	@NotNull
	private String priceCurrency;

	@NotNull
	private List<Quota> quotas;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPriceAmount() {
		return priceAmount;
	}

	public void setPriceAmount(Float priceAmount) {
		this.priceAmount = priceAmount;
	}

	public String getPriceCurrency() {
		return priceCurrency;
	}

	public void setPriceCurrency(String priceCurrency) {
		this.priceCurrency = priceCurrency;
	}

	public List<Quota> getQuotas() {
		return quotas;
	}

	public void setQuotas(List<Quota> quotas) {
		this.quotas = quotas;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
