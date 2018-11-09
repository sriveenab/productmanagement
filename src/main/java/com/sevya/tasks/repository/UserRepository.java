package com.sevya.tasks.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sevya.tasks.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query("FROM User user where user.email = :email")
	public User findUserByEmail(@Param("email") String email);

}
