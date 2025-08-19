package com.wipro.travelagency.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PackageNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleQuestionNotFoundException(PackageNotFoundException packageNotFoundException){
		ErrorMessage errorMessage = new ErrorMessage(packageNotFoundException.getMessage(),"UserNotFound");
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	}
}
