package com.crud.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.crud.exceptions.product.ProductNotRegisteredException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ProductNotRegisteredException.class)
	public ResponseEntity<CustomError> productNotRegistered(Exception ex, WebRequest request) {
		CustomError errorMessage = new CustomError(new Date(),
												   ex.getMessage(),
												   request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({InternalError.class, Exception.class})
	public ResponseEntity<CustomError> someException(Exception ex, WebRequest request){
		CustomError errorMessage = new CustomError(new Date(),
				   								   ex.getMessage(),
				   								   request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
