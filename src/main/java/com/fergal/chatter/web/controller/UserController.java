package com.fergal.chatter.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fergal.chatter.domain.user.User;
import com.fergal.chatter.users.UserManagement;

import javassist.NotFoundException;

@RestController
@RequestMapping("user")
public class UserController {
	
	private final UserManagement userManagement;
	
	public UserController(UserManagement userManagement) {
		this.userManagement = userManagement;
	}
	
	@PostMapping(value="/create",
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public long createUser(@RequestBody User user) {
		System.out.println(user.getDisplayName());
	return	userManagement.createUser(user.getFirstName(), user.getLastName(), user.getDisplayName());

	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable long id) throws NotFoundException {
		
		try {
		return userManagement.getUser(id);
		} catch(NotFoundException e) {
	         throw new ResponseStatusException(
	  	           HttpStatus.NOT_FOUND, "User Not Found", e);
		}
	}
	
	@GetMapping("/test")
	public String test() {
		return "Hello!";
	}

}
