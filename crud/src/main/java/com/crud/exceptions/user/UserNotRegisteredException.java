package com.crud.exceptions.user;

public class UserNotRegisteredException  extends RuntimeException{

	public UserNotRegisteredException(String message) {
		super(message);
	}
}
