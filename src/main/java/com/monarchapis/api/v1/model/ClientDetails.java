package com.monarchapis.api.v1.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class ClientDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String id;

	@NotNull
	private String apiKey;

	private Optional<Long> expiration = Optional.absent();

	@NotNull
	private Boolean autoAuthorize;

	@NotNull
	private Boolean allowWebView;

	@NotNull
	private Boolean allowPopup;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public Optional<Long> getExpiration() {
		return expiration;
	}

	public void setExpiration(Optional<Long> expiration) {
		this.expiration = expiration;
	}

	public Boolean isAutoAuthorize() {
		return autoAuthorize;
	}

	public void setAutoAuthorize(Boolean autoAuthorize) {
		this.autoAuthorize = autoAuthorize;
	}

	public Boolean isAllowWebView() {
		return allowWebView;
	}

	public void setAllowWebView(Boolean allowWebView) {
		this.allowWebView = allowWebView;
	}

	public Boolean isAllowPopup() {
		return allowPopup;
	}

	public void setAllowPopup(Boolean allowPopup) {
		this.allowPopup = allowPopup;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
