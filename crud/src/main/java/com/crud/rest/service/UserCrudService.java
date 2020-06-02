package com.crud.rest.service;

import org.springframework.stereotype.Service;

import com.crud.rest.dao.UserCrudDao;
import com.crud.rest.model.UserCrud;
import com.crud.exceptions.userCrud.LoginAlreadyRegisteredException;

@Service
public class UserCrudService {
	
	private UserCrudDao userCrudDao;
	
	public UserCrudService(UserCrudDao userCrudDao) {
		this.userCrudDao = userCrudDao;
	}
	
	public UserCrud create(UserCrud user) {
		UserCrud newUser = this.userCrudDao.findByLogin(user.getLogin());
		if (newUser != null) {
			throw new LoginAlreadyRegisteredException("Login inválido. "
										+ "Já existe um usário com este login");
		}
		return this.userCrudDao.save(user);
	}
	

}
