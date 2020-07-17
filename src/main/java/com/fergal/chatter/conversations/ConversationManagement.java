package com.fergal.chatter.conversations;

import org.springframework.stereotype.Service;

import com.fergal.chatter.domain.conversation.Conversation;
import com.fergal.chatter.dto.ConversationRequest;

@Service
public interface ConversationManagement {

	public long createConversation(ConversationRequest conversationRequest);
	
	public Conversation getConversation(long id);
}
