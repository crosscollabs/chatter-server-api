package com.fergal.chatter.web.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.fergal.chatter.domain.user.User;
import com.fergal.chatter.domain.user.UserRepositoryService;
import com.fergal.chatter.users.UserManagement;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

import javassist.NotFoundException;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.hamcrest.Matchers;

@SpringBootTest
@ActiveProfiles("test")
public class UserControllerTests {
	
	@Autowired
	private UserManagement userManagement;
	
	@Autowired
	private UserRepositoryService userRepositoryService;

	@BeforeEach
	void setup() {
			userRepositoryService.deleteAll();
		RestAssuredMockMvc.standaloneSetup(new UserController(userManagement));
	}
	
	@Test
	void testUserControllerFindsUser() throws NotFoundException {

		User user = new User("Fergal","McMahon","fergalmcm");
		
		String response = given().contentType("application/json;charset=utf-8").body(user).when().post("user/create").thenReturn().asString();

		long responseLong = Long.parseLong(response);
		System.out.println(responseLong);
		
		assertNotNull(responseLong);
		
		given().when().get("/user/"+responseLong).then().body("firstName", Matchers.is("Fergal"));
	}
	
	@Test
	void testUserControllerFindsNoUser() throws NotFoundException {

		int statusCode = given().when().get("user/2").thenReturn().getStatusCode();
		assertEquals(statusCode, 404);
		
	}

}
