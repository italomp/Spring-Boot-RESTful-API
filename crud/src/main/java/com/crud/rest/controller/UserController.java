package com.crud.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.rest.model.User;
import com.crud.rest.service.UserService;

/**
 * This class represents the user controller and
 * contains the user routes.
 * @author Italo Modesto
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * This is the user controller constructor.
	 * @return a user controller instance.
	 */
	public UserController() {
		
	}
	
	/**
	 * This method creates and saves a new user and
	 * return a response with HttpStatus.
	 * @param user: It's the new user that will be saved.
	 * @return a responseEntity with HttpStatus. 
	 */
	@PostMapping("/")
	public ResponseEntity create(@RequestBody User user) {
		User newUser = this.userService.create(user);
		return new ResponseEntity(HttpStatus.OK);
	}
}
