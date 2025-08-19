package com.wipro.travelagency.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PackageNotFoundException.class)
	public ResponseEntity<ErrorMessage> handlePackageNotFoundException(PackageNotFoundException packageNotFoundException){
		ErrorMessage errorMessage = new ErrorMessage(packageNotFoundException.getMessage(),"PackageNotFound");
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundException userNotFoundException){
		ErrorMessage errorMessage = new ErrorMessage(userNotFoundException.getMessage(),"UserNotFound");
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleQuestionNotFoundException(BookingNotFoundException bookingNotFoundException){
		ErrorMessage errorMessage = new ErrorMessage(bookingNotFoundException.getMessage(),"BookingNotFound");
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<ErrorMessage> handlePaymentNotFoundException(PaymentNotFoundException paymentNotFoundException){
		ErrorMessage errorMessage = new ErrorMessage(paymentNotFoundException.getMessage(),"BookingNotFound");
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	}
}
