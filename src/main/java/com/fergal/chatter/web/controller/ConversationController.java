package com.fergal.chatter.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fergal.chatter.conversations.ConversationManagement;
import com.fergal.chatter.dto.ConversationDto;
import com.fergal.chatter.dto.ConversationRequest;

@RestController
@RequestMapping("conversation")
public class ConversationController {
	
	private final ConversationManagement conversationManagement;
	
	public ConversationController(ConversationManagement conversationManagement) {
		this.conversationManagement = conversationManagement;
	}
	
	@PostMapping("/create")
	public long createConversation(@RequestBody ConversationRequest conversationRequest) {
		return conversationManagement.createConversation(conversationRequest);
		
	}
	
	@GetMapping("/{id}")
	public ConversationDto getConversation(@PathVariable long id) {
		return conversationManagement.getConversation(id);
		
	}
	
	@GetMapping("/user/all/{id}")
	public  List<ConversationDto> getAllConversationsForUser(@PathVariable long id){
		return conversationManagement.getAllConversationsForUserId(id);
		
	}
	
	

}
