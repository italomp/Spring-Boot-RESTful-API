package com.crud.exceptions.user;

/**
 * This class represents a custom exception 
 * called InvalidPasswordException.
 * @author Italo Modesto
 */
public class InvalidPasswordException extends RuntimeException{

	public InvalidPasswordException(String message) {
		super(message);
	}
}
