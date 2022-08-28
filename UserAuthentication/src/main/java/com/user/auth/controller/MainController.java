package com.user.auth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.auth.model.User;
import com.user.auth.service.UserNotFoundException;
import com.user.auth.service.UserService;

import net.bytebuddy.utility.RandomString;



@Controller
public class MainController {
	
	
	@Autowired
	public UserService userService;

	
	// get all the user 
	@GetMapping("/user")
	public ResponseEntity<List<User>> getUsers() {

		List<User> list = userService.getAllUser();

		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);

	}

	@RequestMapping("/form")
	public String home() {

		return "home";
	}

	@PostMapping("/authform")
	public String form(@ModelAttribute("user") User use) {
		userService.adduser(use); 
		return "welcome";
	}
	
	@GetMapping("/forgotpassword")
	public String forgotpassword(Model model) {
		model.addAttribute("pageTitle","forgot password");
		return"forgotpassword";
	}
	
	@PostMapping("/forgotpassword")
	
	public String forgotpasswordform(HttpServletRequest request,Model model) {
		String email=request.getParameter("email");
		String token=RandomString.make(50);
		System.out.println("email" +email);
		System.out.println("token" +token);
		
		try {
			userService.updateRestPasswordToken(token, email);
			
			
		} catch (UserNotFoundException e) {
			model.addAttribute("error",e.getMessage());
		}
		
		return"forgotpassword";
	}
	

}
