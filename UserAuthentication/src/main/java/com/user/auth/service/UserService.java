package com.user.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.auth.dao.UserRepository;
import com.user.auth.model.User;

@Component
public class UserService {

	@Autowired
	public UserRepository userRepository;

	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	
	//get all user login details
	public List<User> getAllUser() {
		List<User> list = (List<User>) this.userRepository.findAll();
		return list;
	}
	
	//add user login to the database
	public User adduser(User u) {
		User result = userRepository.save(u);
		return result;
	}

	// update the user update
	public void updateUser(User user, int Userid) {

		user.setId(Userid);
		userRepository.save(user);

	}
	
	// getting single user by id and also check the status of the code
	public User getUserById(int id) {
		User user = null;
		// i use try block to check the status code
		try {
			
			user = this.userRepository.findById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	
	public void updateRestPasswordToken(String email, String token) throws UserNotFoundException {

		User user = userRepository.findByEmail(email);

		if (user != null) {
			user.setResetPasswordToken(token);
			userRepository.save(user);
		} else {
			throw new UserNotFoundException("Could not find any user with the entered email" + email);
		}
	}

	public User get(String resetPasswordToken) {
		return userRepository.findByResetPasswordToken(resetPasswordToken);
	}

	public void UpadtePassword(User user, String newpassword) {
		user.setPassword(newpassword);
		userRepository.save(user);
	}

}
