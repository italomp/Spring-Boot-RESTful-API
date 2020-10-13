package com.crud.rest;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

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
