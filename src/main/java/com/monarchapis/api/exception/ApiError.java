package com.monarchapis.api.exception;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;

@XmlRootElement(name = "error")
public class ApiError {
	private int code = 500;
	private String reason;
	private String message;
	private String developerMessage;
	private String errorCode;
	private String moreInfo;
	private DateTime time;

	public ApiError() {
		this.time = DateTime.now();
	}

	public ApiError(Builder builder) {
		this();
		this.code = builder.code;
		this.reason = builder.reason;
		this.message = builder.message;
		this.developerMessage = builder.developerMessage;
		this.errorCode = builder.errorCode;
		this.moreInfo = builder.moreInfo;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public ApiError code(int code) {
		setCode(code);
		return this;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public ApiError reason(String reason) {
		setReason(reason);
		return this;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ApiError message(String message) {
		setMessage(message);
		return this;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public ApiError developerMessage(String developerMessage) {
		setDeveloperMessage(developerMessage);
		return this;
	}

	public DateTime getTime() {
		return time;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public ApiError errorCode(String errorCode) {
		setErrorCode(errorCode);
		return this;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

	public ApiError moreInfo(String moreInfo) {
		setMoreInfo(moreInfo);
		return this;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public static class Builder {
		private int code = 500;
		private String reason;
		private String message;
		private String developerMessage;
		private String errorCode;
		private String moreInfo;

		public Builder code(int code) {
			this.code = code;
			return this;
		}

		public Builder reason(String reason) {
			this.reason = reason;
			return this;
		}

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		public Builder developerMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public Builder errorCode(String errorCode) {
			this.errorCode = errorCode;
			return this;
		}

		public Builder moreInfo(String moreInfo) {
			this.moreInfo = moreInfo;
			return this;
		}

		public ApiError build() {
			return new ApiError(this);
		}
	}
}
