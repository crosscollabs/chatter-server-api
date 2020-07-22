package com.fergal.chatter.web.controller;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.fergal.chatter.domain.conversation.ConversationRepositoryService;
import com.fergal.chatter.domain.outbox.OutboxItem;
import com.fergal.chatter.domain.outbox.OutboxRepositoryService;
import com.fergal.chatter.domain.user.User;
import com.fergal.chatter.domain.user.UserRepositoryService;
import com.fergal.chatter.message.Message;
import com.fergal.chatter.message.Message.Priority;
import com.fergal.chatter.message.MessageService;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class MessageControllerTests {

	
	@Autowired
	MessageService messageService;
	
	@Autowired
	ConversationRepositoryService conversationRepositoryService;
	
	@Autowired
	UserRepositoryService userRepositoryService;
	
	@Autowired
	OutboxRepositoryService outboxRepositoryService;
	
	
	private long user1Id;
	private long user2Id;
	
	private long conversation1Id;
	
	@BeforeEach
	void setup() {
		conversationRepositoryService.deleteAll();
		userRepositoryService.deleteAll();
		outboxRepositoryService.deleteAll();
		
		user1Id = userRepositoryService.createUser(new User("first1","last1","display1"));
		user2Id = userRepositoryService.createUser(new User("first2","last2","display2"));
		Set<Long> allUsers = new HashSet<>();
		allUsers.add(user1Id);
		allUsers.add(user2Id);
		
		conversation1Id = conversationRepositoryService.createConverasation(allUsers, "conversation1");
		
		
		RestAssuredMockMvc.standaloneSetup(new MessageController(messageService));
	}
	
	@Test
	void testMessageCreationAndRetrieval() {
		final String CONTENT = "Hello!";
		Message message = new Message(conversation1Id,user1Id,CONTENT,Priority.LOW);
		
		boolean response = given().contentType("application/json;charset=utf-8").body(message).post("message/send").thenReturn().as(Boolean.class);
		assertTrue(response);
		
		OutboxItem[] allMessages = given().get("message/getall/"+user2Id).thenReturn().as(OutboxItem[].class);

		assertEquals(1,allMessages.length);
		
		assertEquals(CONTENT,allMessages[0].getMessageContent());
		
		long messageId = allMessages[0].getOutboxId();
		
		boolean deleteResponse = given().get("message/delete/"+messageId).thenReturn().as(Boolean.class);
		assertTrue(deleteResponse);

	}
}
