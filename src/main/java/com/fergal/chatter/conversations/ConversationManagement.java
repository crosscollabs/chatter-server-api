package com.fergal.chatter.conversations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fergal.chatter.dto.ConversationDto;
import com.fergal.chatter.dto.ConversationRequest;

@Service
public interface ConversationManagement {

	public long createConversation(ConversationRequest conversationRequest);
	
	public ConversationDto getConversation(long id);
	
	public List<ConversationDto> getAllConversationsForUserId(long id);
}
