package com.fergal.chatter.dto;

import java.util.List;

import com.fergal.chatter.domain.conversation.Conversation;

public class ConversationDto {
	
	private List<Long> allUsers;
	
	private String conversationName;
	
	private long conversationId;
	
	public ConversationDto() {}
	
	public ConversationDto(List<Long> allUsers, String conversationName, long conversationId) {
		this.allUsers=allUsers;
		this.conversationName=conversationName;
		this.conversationId=conversationId;
	}
	
	public ConversationDto(Conversation conversation) {
		super();
		this.conversationName = conversation.getConversationName();
		this.conversationId = conversation.getId();
		
		this.allUsers = conversation.getAllUsers();
		
	}

	public List<Long> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(List<Long> allUsers) {
		this.allUsers = allUsers;
	}

	public String getConversationName() {
		return conversationName;
	}

	public void setConversationName(String conversationName) {
		this.conversationName = conversationName;
	}

	public long getConversationId() {
		return conversationId;
	}

	public void setConversationId(long conversationId) {
		this.conversationId = conversationId;
	}
	
	

}
