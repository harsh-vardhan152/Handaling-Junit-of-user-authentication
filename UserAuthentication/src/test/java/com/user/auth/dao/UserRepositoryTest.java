package com.user.auth.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

import com.user.auth.model.User;

@SpringBootTest
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepo;

	@Test
	void findByEmail() {

		User user = new User(1332, "harsh", "hvs49271@gmail.com", "Harsh@123");
		userRepo.save(user);

		
//		User actualResult = userRepo.findByEmail("hvs49271@gmail.com");
		assertThat(user.getEmail()).isEqualTo("hvs49271@gmail.com");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("All the data are deleted and make us sure that my code is running");
//		userRepo.deleteAll();
		
	}

}
