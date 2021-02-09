package com.crud.exceptions.product;

/**
 * This class represents a custom exception 
 * called ProductNotRegisteredException.
 * @author Italo Modesto
 */
public class ProductNotRegisteredException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ProductNotRegisteredException(String message) {
		super(message);
	}
}
