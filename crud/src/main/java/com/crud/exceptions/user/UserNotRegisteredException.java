package com.crud.exceptions.user;

/**
 * This class represents a custom exception 
 * called UserNotRegisteredException.
 * @author Italo Modesto
 */
public class UserNotRegisteredException  extends RuntimeException{

	public UserNotRegisteredException(String message) {
		super(message);
	}
}
