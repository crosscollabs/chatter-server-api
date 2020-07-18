package com.fergal.chatter.dto;

import java.util.List;

public class ConversationRequest {
	
	private List<Long> members;
	
	private String conversationName;
	
	public ConversationRequest(List<Long> members, String conversationName) {
		this.members = members;
		this.conversationName = conversationName;
	}

	public List<Long> getMembers() {
		return members;
	}

	public void setMembers(List<Long> members) {
		this.members = members;
	}

	public String getConversationName() {
		return conversationName;
	}

	public void setConversationName(String conversationName) {
		this.conversationName = conversationName;
	}
}
