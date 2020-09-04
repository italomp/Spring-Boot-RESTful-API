package com.crud.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.crud.exceptions.product.ProductNotRegisteredException;
import com.crud.exceptions.user.InvalidPasswordException;
import com.crud.exceptions.user.LoginAlreadyRegisteredException;
import com.crud.exceptions.user.UserNotRegisteredException;

/**
 * This class represents a general exception handler.
 * This class is marked with the controllerAdvice annotation.
 * So it catches and handles all exceptions thrown in classes
 * marked with the controller annotation.
 * @author Italo Modesto
 */
@ControllerAdvice
public class RestExceptionHandler {

	/**
	 * This method handles ProductNotRegisteredException, returning a CustomError with
	 * date, message and request url.
	 * @param ex: It's the caught exception.
	 * @param request: It's the request that caused the exception.
	 * @return a responseEntity with the customError and the httpStatus.
	 */
	@ExceptionHandler(ProductNotRegisteredException.class)
	public ResponseEntity<CustomError> productNotRegistered(Exception ex, WebRequest request) {
		CustomError errorMessage = new CustomError(new Date(),
												   ex.getMessage(),
												   request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * This method handles LoginAlreadyRegisteredException, returning a CustomError with
	 * date, message and request url.
	 * @param ex: It's the caught exception.
	 * @param request: It's the request that caused the exception.
	 * @return a responseEntity with the customError and the httpStatus.
	 */
	@ExceptionHandler(LoginAlreadyRegisteredException.class)
	public ResponseEntity<CustomError> loginAlreadyRegistered(Exception ex, WebRequest request){
		CustomError errorMessage = new CustomError(new Date(), 
												   ex.getMessage(), 
												   request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
	}
	
	/**
	 * This method handles UserNotRegisteredException, returning a CustomError with
	 * date, message and request url.
	 * @param ex: It's the caught exception.
	 * @param request: It's the request that caused the exception.
	 * @return a responseEntity with the customError and the httpStatus.
	 */
	@ExceptionHandler(UserNotRegisteredException.class)
	public ResponseEntity<CustomError> userNotRegistered(Exception ex, WebRequest request){
		CustomError errorMessage = new CustomError(new Date(), 
												   ex.getMessage(), 
												   request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * This method handles InvalidPasswordException, returning a CustomError with
	 * date, message and request url.
	 * @param ex: It's the caught exception.
	 * @param request: It's the request that caused the exception.
	 * @return a responseEntity with the customError and the httpStatus.
	 */
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<CustomError> invalidPassword(Exception ex, WebRequest request){
		CustomError errorMessage = new CustomError(new Date(), 
												   ex.getMessage(), 
												   request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
	}
	
	/**
	 * This method handles InvalidPasswordException, returning a CustomError with
	 * date, message and request url.
	 * @param ex: It's the caught exception.
	 * @param request: It's the request that caused the exception.
	 * @return a responseEntity with the customError and the httpStatus.
	 */
	@ExceptionHandler({InternalError.class, Exception.class})
	public ResponseEntity<CustomError> someException(Exception ex, WebRequest request){
		CustomError errorMessage = new CustomError(new Date(),
				   								   ex.getMessage(),
				   								   request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
