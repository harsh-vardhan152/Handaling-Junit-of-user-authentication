package com.user.auth.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.user.auth.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.email =:n")
	public User findByEmail(@Param("n")String email);
	
	
	public User findByResetPasswordToken(String token);
	
	public User findById(int id);

}
