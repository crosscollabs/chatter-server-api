package com.fergal.chatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fergal.chatter.domain.user.User;
import com.fergal.chatter.users.UserManagement;

@SpringBootApplication
public class Application{

	@Autowired
	UserManagement userManagement;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
