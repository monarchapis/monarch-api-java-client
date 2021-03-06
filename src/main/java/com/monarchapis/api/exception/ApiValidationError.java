package com.monarchapis.api.exception;

import java.util.Set;

public class ApiValidationError extends ApiError {
	private Set<ValidationError> validationErrors;

	public ApiValidationError() {
		super();
	}

	public ApiValidationError(Builder builder) {
		super(builder);
		this.validationErrors = builder.validationErrors;
	}

	public Set<ValidationError> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(Set<ValidationError> validationErrors) {
		this.validationErrors = validationErrors;
	}

	public static class Builder extends ApiError.Builder {
		private Set<ValidationError> validationErrors;

		public Builder validationErrors(Set<ValidationError> validationErrors) {
			this.validationErrors = validationErrors;
			return this;
		}

		public ApiValidationError build() {
			return new ApiValidationError(this);
		}
	}
}
