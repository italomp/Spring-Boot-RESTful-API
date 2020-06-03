package com.crud.exceptions.user;

public class LoginAlreadyRegisteredException extends RuntimeException{

	public LoginAlreadyRegisteredException(String message) {
		super(message);
	}
}
