package com.crud.rest.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
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

/**
 * This class is responsible for authenticating a user 
 * who tries to login.
 * @author Italo Modesto
 */
@RestController
@RequestMapping("/v1/auth")
@CrossOrigin
public class LoginController {

	/**
	 * The TOKEN_KEY attribute is the key used to 
	 * generate and unzip the token.
	 */
	private final String TOKEN_KEY = "caneca";
	private UserService userService;
	
	/**
	 * This is the LoginController constructor.
	 * @param userService: It's a userService instance used
	 *        by the LoginController in its methods.
	 * @return a new LoginController instance.
	 */
	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * This method authenticates a user. It verify if the 
	 * user login and user password are correct and then 
	 * generates a token.
	 * To generate the token, the Jwts Builder sets subject
	 * that will be encapsulated in token, then sets the
	 * algorithms that will signing the token, then sets
	 * the expiration date (in milliseconds), and then 
	 * compact the token.
	 * 
	 * @param use: It's a user with his login and password.
	 * @return a LoginResponse with a token for the user 
	 *         to use it in validation process.
	 * @throws UserNotRegisteredException, InvalidPasswordException.
	 */
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
	
	/**
	 * This represents a login response.
	 * @author Italo Modesto
	 */
	public class LoginResponse {
		private String token;
		
		/**
		 * This is the LoginResponse constructor.
		 * @return a new LoginResponse instance.
		 */
		public LoginResponse(String token) {
			this.token = token;
		}
		
		/**
		 * This method returns the this class instance token.
		 * @return the this class instance token.
		 */
		public String getToken() {
			return this.token;
		}
		
		/**
		 * This method sets the this class instance token.
		 */
		public void setToken(String token) {
			this.token = token;
		}
	}
}
