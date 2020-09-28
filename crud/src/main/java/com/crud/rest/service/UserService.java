package com.crud.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.exceptions.user.LoginAlreadyRegisteredException;
import com.crud.exceptions.user.UserNotRegisteredException;
import com.crud.rest.dao.UserDao;
import com.crud.rest.model.User;

/**
 * This class represents the user service and executes
 * the user services.
 * @author Italo Modesto
 */
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * This is the user service constructor.
	 * @return a user service instance.
	 */
	public UserService() {
		
	}
	
	/**
	 * This method creates and saves a new user.
	 * @param user: It's the new user that will be saved.
	 * @return user saved.
	 * @throws LoginAlreadyRegisteredException
	 */
	public User create(User user) {
		User newUser = this.userDao.findByLogin(user.getLogin());
		if (newUser != null) {
			throw new LoginAlreadyRegisteredException("Login inválido. "
										+ "Já existe um usário com este login");
		}
		return this.userDao.save(user);
	}
	
	/**
	 * This method gets a user by its login.
	 * @param login: It's the user login that will be got.
	 * @return the user that have its login equal to the 
	 * login parameter.
	 */
	public User findByLogin(String login) {
		return this.userDao.findByLogin(login);
	}
	

}
