package com.crud.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.rest.model.User;
import com.crud.rest.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/")
	public ResponseEntity create(@RequestBody User user) {
		User newUser = this.userService.create(user);
		return new ResponseEntity(HttpStatus.OK);
	}
}
