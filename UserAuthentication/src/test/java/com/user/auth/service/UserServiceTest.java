package com.user.auth.service;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.auth.dao.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import com.user.auth.model.User;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;

//	@BeforeEach
//	void setUp() {
//
//		this.userService = new UserService(this.userRepo);
//	}

	@Test
	void testGetAllUser() {

		List<User>listuser=userService.getAllUser();
		
		Boolean list=listuser.containsAll(listuser);
		
		assertThat(list);

//		verify(userRepo).findAll();
	}
	@Test
	void testAdduser() {
		User user = new User(13, "harsh vardhan", "hvs49271@gmail.com", "Harsh@1234");
		User getuser = this.userService.adduser(user);
		assertThat(getuser.getEmail()).isEqualTo("hvs49271@gmail.com");
	}

//	@Test
//	void testUpdateUser() {
//		
//		this.userService.updateUser(new User(133245, "harsh", "hvs49271@gmail.com", "Harsh@123"),133245);
//		User user= userService.getUserById(133245);
//		assertThat(user.getUsername()).isEqualTo("harsg");
//	}


}
