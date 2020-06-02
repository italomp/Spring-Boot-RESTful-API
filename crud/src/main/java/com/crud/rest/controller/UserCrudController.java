package com.crud.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.rest.model.UserCrud;
import com.crud.rest.service.UserCrudService;

@RestController
@RequestMapping("/v1/user")
public class UserCrudController {
	
	private UserCrudService userCrudService;
	
	public UserCrudController(UserCrudService userCrudService) {
		this.userCrudService = userCrudService;
	}
	
	@PostMapping("/")
	public ResponseEntity create(@RequestBody UserCrud user) {
		UserCrud newUser = this.userCrudService.create(user);
		return new ResponseEntity(HttpStatus.OK);
	}
}
