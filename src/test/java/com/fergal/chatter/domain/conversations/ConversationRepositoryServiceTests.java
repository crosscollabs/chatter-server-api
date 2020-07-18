package com.fergal.chatter.domain.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fergal.chatter.domain.conversation.Conversation;
import com.fergal.chatter.domain.conversation.ConversationRepositoryService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class ConversationRepositoryServiceTests {
	
	@Autowired
	private ConversationRepositoryService conversationRepositoryService;
	
	@BeforeEach
	public void setup() {
		conversationRepositoryService.deleteAll();
	}
	
	@Test
	public void testConversationRepoWorksCorrectly() {
		Set<Long> users = new HashSet<>();
		users.add(1l);
		users.add(2l);
		long id =conversationRepositoryService.createConverasation(users,"test");
	
Conversation conversation = conversationRepositoryService.getConversation(id).get();

assertEquals("test",conversation.getConversationName());
	}

}
