package com.monarchapis.api.v1.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Optional;

public class AuthenticationResponse {

	@NotNull
	private Integer code;

	private Optional<String> reason = Optional.absent();

	private Optional<String> message = Optional.absent();

	private Optional<String> developerMessage = Optional.absent();

	private Optional<String> errorCode = Optional.absent();

	@NotNull
	private List<HttpHeader> responseHeaders;

	private Optional<VariableContext> vars = Optional.absent();

	private Optional<ObjectNode> claims = Optional.absent();

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Optional<String> getReason() {
		return reason;
	}

	public void setReason(Optional<String> reason) {
		this.reason = reason;
	}

	public Optional<String> getMessage() {
		return message;
	}

	public void setMessage(Optional<String> message) {
		this.message = message;
	}

	public Optional<String> getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(Optional<String> developerMessage) {
		this.developerMessage = developerMessage;
	}

	public Optional<String> getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Optional<String> errorCode) {
		this.errorCode = errorCode;
	}

	public List<HttpHeader> getResponseHeaders() {
		return responseHeaders;
	}

	public void setResponseHeaders(List<HttpHeader> responseHeaders) {
		this.responseHeaders = responseHeaders;
	}

	public Optional<VariableContext> getVars() {
		return vars;
	}

	public void setVars(Optional<VariableContext> vars) {
		this.vars = vars;
	}

	public Optional<ObjectNode> getClaims() {
		return claims;
	}

	public void setClaims(Optional<ObjectNode> claims) {
		this.claims = claims;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
