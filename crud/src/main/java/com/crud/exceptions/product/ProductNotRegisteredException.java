package com.crud.exceptions.product;

/**
 * This class represents a custom exception 
 * called ProductNotRegisteredException.
 * @author Italo Modesto
 */
public class ProductNotRegisteredException extends RuntimeException{

	public ProductNotRegisteredException(String message) {
		super(message);
	}
}
