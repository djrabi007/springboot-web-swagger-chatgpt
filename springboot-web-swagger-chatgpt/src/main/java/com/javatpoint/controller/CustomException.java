package com.javatpoint.controller;

public class CustomException extends RuntimeException {

	private final String errorCode;
	private final String errorMessage;

	public CustomException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}

