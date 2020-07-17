package com.fergal.chatter.scenarios;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fergal.chatter.conversations.ConversationManagement;
import com.fergal.chatter.domain.conversation.Conversation;
import com.fergal.chatter.domain.conversation.ConversationRepositoryService;
import com.fergal.chatter.domain.outbox.OutboxItem;
import com.fergal.chatter.domain.outbox.OutboxRepositoryService;
import com.fergal.chatter.domain.user.UserRepositoryService;
import com.fergal.chatter.dto.ConversationRequest;
import com.fergal.chatter.message.Message;
import com.fergal.chatter.message.MessageService;
import com.fergal.chatter.message.Message.Priority;
import com.fergal.chatter.users.UserManagement;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BasicMessageFlowTests {
	
	@Autowired
	private UserManagement userManagement;
	
	@Autowired
	private UserRepositoryService userRepositoryService;
	
	@Autowired
	private ConversationManagement conversationManagement;
	
	@Autowired
	private ConversationRepositoryService conversationRepositoryService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private OutboxRepositoryService outboxRepositoryService;
	
	@BeforeEach
	public void setup() {
		userRepositoryService.deleteAll();
		conversationRepositoryService.deleteAll();
		outboxRepositoryService.deleteAll();
	}
	
	@Test
	public void testTwoUsersCanStartAConversationAndMessage() {
		//create 2 users
		long userid1 = userManagement.createUser("Fergal", "McMahon", "fergalmcm");
		
		long userid2 = userManagement.createUser("Shane", "O' Leary", "shaneol");
		
		String CONVERSATION_NAME="First Chat";
		
		String MESSAGE_CONTENT="First test message to group";
		
		Set<Long> allUsers = new HashSet<>(Arrays.asList(userid1,userid2));
		
		List<Long> allUsersList = new ArrayList<>();
		allUsersList.addAll(allUsers);
		
		ConversationRequest conversationRequest = new ConversationRequest(allUsersList,CONVERSATION_NAME);
		//create a conversation with both users
		long conversationId = conversationManagement.createConversation(conversationRequest);
		
		Conversation conversation = conversationManagement.getConversation(conversationId);
		
		assertTrue(conversation.getAllUsers().containsAll(allUsers));
		
		//send a message from one user to the conversation.
		Message message = new Message(conversationId,userid1,MESSAGE_CONTENT,Priority.MEDIUM);
		
		messageService.sendMessage(message);
		
		//assert the other user can retrieve that message
		List<OutboxItem> outboxItems =outboxRepositoryService.getAllOutboxItemsForUser(userid2);
		
		assertEquals(MESSAGE_CONTENT,outboxItems.get(0).getMessageContent());
		assertEquals(Priority.MEDIUM, outboxItems.get(0).getPriority());
		
		List<OutboxItem> senderItems = outboxRepositoryService.getAllOutboxItemsForUser(userid1);
		assertEquals(0, senderItems.size());
	}

}
