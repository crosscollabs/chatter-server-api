package com.fergal.chatter.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fergal.chatter.conversations.ConversationManagement;
import com.fergal.chatter.domain.conversation.Conversation;
import com.fergal.chatter.dto.ConversationRequest;

@RestController
@RequestMapping("conversation")
public class ConversationController {
	
	private final ConversationManagement conversationManagement;
	
	public ConversationController(ConversationManagement conversationManagement) {
		this.conversationManagement = conversationManagement;
	}
	
	@PostMapping("/create")
	public long createConversation(ConversationRequest conversationRequest) {
		return conversationManagement.createConversation(conversationRequest);
		
	}
	
	@GetMapping("/{id}")
	public Conversation getConversation(long id) {
		return conversationManagement.getConversation(id);
		
	}

}
