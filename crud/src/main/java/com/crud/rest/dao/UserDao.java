package com.crud.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.crud.rest.model.User;

/**
 * This interface make connection with data base to 
 * manipulate users.
 * @author Italo Modesto
 */
@Repository
public interface UserDao extends JpaRepository<User, String> {

	/**
	 * This is a JpaRepository API method to save an 
	 * object (in this case, a user) in the data base.
	 * @param user: It's the user that will be save.
	 * @return the saved user.
	 */
	public User save(User user);
	
	/**
	 * This method is a JPA custom query to get the user with 
	 * the login equal to the login parameter.
	 * @param login: It's login of the user i want get.
	 * @return the user that have his login equal to the login parameter.
	 */
	@Query("select u from User u where u.login=:plogin")
	public User findByLogin(@Param("plogin")String login);
}
