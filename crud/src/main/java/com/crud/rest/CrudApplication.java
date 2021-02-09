package com.crud.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

/**
 * This is the main class of the project, because it has 
 * springBootApplication annotation. That's why it
 * is the responsible class for uploading the spring server.
 */
@SpringBootApplication
@ComponentScan("com.crud")
public class CrudApplication {

	/**
	 * This static method start the spring server.
	 * @param args: argument array.
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}    
	    
	    
}
