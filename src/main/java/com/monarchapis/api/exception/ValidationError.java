package com.monarchapis.api.exception;

public class ValidationError {
	private String message;
	private String path;

	public ValidationError(String message, String path) {
		this.message = message;
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}
}
