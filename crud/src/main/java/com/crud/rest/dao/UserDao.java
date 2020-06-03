package com.crud.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.crud.rest.model.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {

	public User save(User user);
	
	@Query("select u from User u where u.login=:plogin")
	public User findByLogin(@Param("plogin")String login);
}
