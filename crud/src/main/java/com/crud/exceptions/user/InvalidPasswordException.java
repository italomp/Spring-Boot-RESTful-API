package com.crud.exceptions.user;

public class InvalidPasswordException extends RuntimeException{

	public InvalidPasswordException(String message) {
		super(message);
	}
}
