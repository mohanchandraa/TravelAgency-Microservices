package com.wipro.travelagency.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DestinationNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleQuestionNotFoundException(DestinationNotFoundException destinationNotFoundException){
		ErrorMessage errorMessage = new ErrorMessage(destinationNotFoundException.getMessage(),"DestinationNotFound");
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	}
}
