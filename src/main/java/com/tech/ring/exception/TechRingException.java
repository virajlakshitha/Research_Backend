package com.tech.ring.exception;

import com.tech.ring.enums.TechRingApplicationErrors;

public class TechRingException extends RuntimeException{
	
	private String errorCode;
	private String errorMessage;
	
	public TechRingException(TechRingApplicationErrors errors) {
		this.errorCode = errors.getStatusCode();
		this.errorMessage = errors.getStatusMessage();
	}
	
	public TechRingException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
