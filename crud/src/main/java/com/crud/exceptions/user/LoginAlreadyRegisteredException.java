package com.crud.exceptions.user;

/**
 * This class represents a custom exception 
 * called LoginAlreadyRegisteredException.
 * @author Italo Modesto
 */
public class LoginAlreadyRegisteredException extends RuntimeException{

	public LoginAlreadyRegisteredException(String message) {
		super(message);
	}
}
