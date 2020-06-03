package com.crud.rest.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.exceptions.user.InvalidPasswordException;
import com.crud.exceptions.user.UserNotRegisteredException;
import com.crud.rest.model.User;
import com.crud.rest.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/v1/auth")
public class LoginController {

	private final String TOKEN_KEY = "caneca";
	private UserService userService;
	
	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/login")
	public LoginResponse authenticate(@RequestBody User user) {
		User userAuth = this.userService.findByLogin(user.getLogin());
		if(userAuth == null) {
			throw new UserNotRegisteredException("Não há nenhum usuário "
											   + "cadastrado com este login");
		}
		if(!userAuth.getPassword().equals(user.getPassword())) {
			throw new InvalidPasswordException("Senha inválida");
		}
		String token = Jwts.builder()
				       .setSubject(userAuth.getLogin())
				       .signWith(SignatureAlgorithm.HS512, this.TOKEN_KEY)
				       .setExpiration(new Date(System.currentTimeMillis() + 1 * 60 *1000)) 
				       .compact();
		return new LoginResponse(token);
	}
	
	public class LoginResponse {
		private String token;
		
		public LoginResponse(String token) {
			this.token = token;
		}
		
		public String getToken() {
			return this.token;
		}
		
		public void setToken(String token) {
			this.token = token;
		}
	}
}
