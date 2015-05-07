package com.monarchapis.api.v1.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Optional;

public class AuthenticationRequest {

	@NotNull
	private String protocol;

	@NotNull
	private String method;

	@NotNull
	private String host;

	@NotNull
	private Integer port;

	@NotNull
	private String path;

	private Optional<String> querystring = Optional.absent();

	@NotNull
	private Headers headers;

	@NotNull
	private String ipAddress;

	@NotNull
	private PayloadHashes payloadHashes;

	private Optional<Float> requestWeight = Optional.absent();

	@NotNull
	private Boolean performAuthorization;

	@NotNull
	private Boolean bypassRateLimiting;

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Optional<String> getQuerystring() {
		return querystring;
	}

	public void setQuerystring(Optional<String> querystring) {
		this.querystring = querystring;
	}

	public Headers getHeaders() {
		return headers;
	}

	public void setHeaders(Headers headers) {
		this.headers = headers;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public PayloadHashes getPayloadHashes() {
		return payloadHashes;
	}

	public void setPayloadHashes(PayloadHashes payloadHashes) {
		this.payloadHashes = payloadHashes;
	}

	public Optional<Float> getRequestWeight() {
		return requestWeight;
	}

	public void setRequestWeight(Optional<Float> requestWeight) {
		this.requestWeight = requestWeight;
	}

	public Boolean isPerformAuthorization() {
		return performAuthorization;
	}

	public void setPerformAuthorization(Boolean performAuthorization) {
		this.performAuthorization = performAuthorization;
	}

	public Boolean isBypassRateLimiting() {
		return bypassRateLimiting;
	}

	public void setBypassRateLimiting(Boolean bypassRateLimiting) {
		this.bypassRateLimiting = bypassRateLimiting;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
