package com.fergal.chatter.web.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.fergal.chatter.conversations.ConversationManagement;
import com.fergal.chatter.domain.conversation.ConversationRepositoryService;
import com.fergal.chatter.domain.user.User;
import com.fergal.chatter.domain.user.UserRepositoryService;
import com.fergal.chatter.dto.ConversationDto;
import com.fergal.chatter.dto.ConversationRequest;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class ConversationControllerTests {
	
	@Autowired
	ConversationManagement conversationManagement;
	
	@Autowired
	ConversationRepositoryService conversationRepositoryService;
	
	@Autowired
	UserRepositoryService userRepositoryService;
	
	private List<Long> allUsers = new ArrayList<>();
	private long user1Id;
	private long user2Id;
	@BeforeEach
	void setup() {
		conversationRepositoryService.deleteAll();
		userRepositoryService.deleteAll();
		
		user1Id =userRepositoryService.createUser(new User("first1","last1","display1"));
		user2Id =userRepositoryService.createUser(new User("first2","last2","display2"));
		
		allUsers.add(user1Id);
		allUsers.add(user2Id);
		
		RestAssuredMockMvc.standaloneSetup(new ConversationController(conversationManagement));
	}
	
	@Test
	void testCanCreateAndFindConversationForUser() {
		
		
		ConversationRequest conversation = new ConversationRequest(allUsers,"conversation1");
		
		
		long response = Long.parseLong(given().contentType("application/json;charset=utf-8").body(conversation).post("conversation/create").thenReturn().asString());
	
		assertNotNull(response);
		
		given().get("conversation/"+response).then().body("conversationName", is("conversation1"));
	
		ConversationDto[] userResponse =given().contentType(ContentType.JSON).get("conversation/user/all/"+user1Id).thenReturn().as(ConversationDto[].class);

		assertEquals(1, userResponse.length);
		
		assertEquals("conversation1",userResponse[0].getConversationName());
	}

}
