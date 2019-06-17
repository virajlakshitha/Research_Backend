package com.tech.ring.enums;

public enum TechRingApplicationErrors {
	
	USER_NAME_ALREADY_EXISTS("001","User name already exists. Please try another user name."),
	USER_NOT_CREATED("002","User not created"),
	USER_CAN_NOT_FIND("003","User can not find"),
	USER_NAME_NOT_FOUND("004","User name can not found"),
	USER_ROLE_NOT_FOUND("005","User role can not found"),
	LAPTOP_ALLREADY_EXISTS("006","Laptop allready exists"),
	LAPTOP_NOT_CREATED("007","Laptop is not created, Please try again little while"),
	LAPTOP_BRAND_NAME_ALREADY_EXISTS("008","Laptop Brand Name already exists, Please try another brand name"),
	LAPTOP_BRAND_NOT_CREATED("009","Laptop brand not created"),
	LAPTOP_BRAND_NOT_FOUND("0010","Laptop brand not found"),
	CAN_NOT_FIND_MATCHING_RESULT("0011","Sorry , We can not find matching result");
	
	private String statusCode;
	private String statusMessage;
	
	private TechRingApplicationErrors(String statusCode, String statusMessage) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
}
