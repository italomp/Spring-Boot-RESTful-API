package com.crud.rest.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This class represents a system's user
 * @author Italo Modesto 
 */
@Entity
public class User {
	/**
	 * The login attribute is the class identifier and
	 * is generated manually by this API.
	 */
	@Id
	private String login; 
	private String password;
	private String name;
	
	/**
	 * This is an empty constructor that JPA requires us to use in models.
	 * @return a new instance of the user object.
	 */
	public User() {
		
	}
	
	/**
	 * This is the user constructor used to instantiate new user objects.
	 * @param login: It's the user login.
	 * @param password: It's the user password.
	 * @param name: It's the user name.
	 * @return a new user instance.
	 */
	public User(String login, String password, String name) {
		this.login = login;
		this.password = password;
		this.name = name;
	}

	/**
	 * This method return the user login
	 * @return the user login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * This method sets the user login
	 * @param login: It's the new login value.
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * This method return the user password
	 * @return the user password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method sets the user password
	 * @param password: It's the new password value.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method return the name password
	 * @return the user name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the user name
	 * @param name: It's the new name value.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
