package com.fergal.chatter.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fergal.chatter.domain.user.User;
import com.fergal.chatter.users.UserManagement;

@RestController
@RequestMapping("user")
public class UserController {
	
	private final UserManagement userManagement;
	
	public UserController(UserManagement userManagement) {
		this.userManagement = userManagement;
	}
	
	@PostMapping("/create")
	public String createUser(User user) {
	long userId=	userManagement.createUser(user.getFirstName(), user.getLastName(), user.getDisplayName());
		return ""+userId;
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable long id) {
		User user = userManagement.getUser(id);
		return user;
	}
	
	@GetMapping("/test")
	public String test() {
		return "Hello!";
	}

}
