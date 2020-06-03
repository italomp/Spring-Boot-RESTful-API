package com.crud.rest.service;

import org.springframework.stereotype.Service;

import com.crud.exceptions.user.LoginAlreadyRegisteredException;
import com.crud.exceptions.user.UserNotRegisteredException;
import com.crud.rest.dao.UserDao;
import com.crud.rest.model.User;

@Service
public class UserService {
	
	private UserDao userDao;
	
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User create(User user) {
		User newUser = this.userDao.findByLogin(user.getLogin());
		if (newUser != null) {
			throw new LoginAlreadyRegisteredException("Login inválido. "
										+ "Já existe um usário com este login");
		}
		return this.userDao.save(user);
	}
	
	public User findByLogin(String login) {
		return this.userDao.findByLogin(login);
	}
	

}
