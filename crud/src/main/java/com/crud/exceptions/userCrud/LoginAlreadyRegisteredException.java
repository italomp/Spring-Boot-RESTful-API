package com.crud.exceptions.userCrud;

public class LoginAlreadyRegisteredException extends RuntimeException{

	public LoginAlreadyRegisteredException(String message) {
		super(message);
	}
}
