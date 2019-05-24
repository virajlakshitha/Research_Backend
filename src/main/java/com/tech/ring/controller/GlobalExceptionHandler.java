package com.tech.ring.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.exception.TechRingError;
import com.tech.ring.exception.TechRingException;
import com.tech.ring.response.TechRingResponse;





@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	Log logger = LogFactory.getLog(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value = TechRingException.class)
	public TechRingResponse handleGlobleException(TechRingException techRingException) {
		
		TechRingError mongoError = new TechRingError();
		mongoError.setCode(techRingException.getErrorCode());
		mongoError.setMessage(techRingException.getErrorMessage());
		
		TechRingResponse techResponse = new TechRingResponse();
		techResponse.setResponseCode("000");
		techResponse.setResponseObject(mongoError);
		
		return techResponse;
	}
}
