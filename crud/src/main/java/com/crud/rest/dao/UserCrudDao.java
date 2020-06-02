package com.crud.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.crud.rest.model.UserCrud;

@Repository
public interface UserCrudDao extends JpaRepository<UserCrud, String> {

	public UserCrud save(UserCrud user);
	
	@Query("select u from UserCrud u where u.login=:plogin")
	public UserCrud findByLogin(@Param("plogin")String login);
}
