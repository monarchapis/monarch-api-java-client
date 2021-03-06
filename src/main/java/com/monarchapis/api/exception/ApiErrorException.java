package com.monarchapis.api.exception;

public class ApiErrorException extends ApiException {
	private static final long serialVersionUID = -6106308203401428275L;

	private ApiError error;

	public ApiErrorException(ApiError error) {
		this(error, null);
	}

	public ApiErrorException(ApiError error, Throwable t) {
		super(error.getMessage(), t);
		this.error = error;
	}

	public ApiErrorException(ApiError.Builder builder) {
		this(builder.build());
	}

	public ApiErrorException(ApiError.Builder builder, Throwable t) {
		this(builder.build(), t);
	}

	public ApiError getError() {
		return error;
	}
}