package com.fergal.chatter.conversations;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.fergal.chatter.domain.conversation.Conversation;
import com.fergal.chatter.domain.conversation.ConversationRepositoryService;
import com.fergal.chatter.dto.ConversationRequest;

@Service
public class ConversationManagementImpl implements ConversationManagement {
	
	private final ConversationRepositoryService conversationRepositoryService;
	
	public ConversationManagementImpl(ConversationRepositoryService conversationRepositoryService) {
		this.conversationRepositoryService = conversationRepositoryService;
	}

	@Override
	public long createConversation(ConversationRequest conversationRequest) {

		
		return conversationRepositoryService.createConverasation(new HashSet<Long>(conversationRequest.getMembers()),
				conversationRequest.getConversationName());
	}

	@Override
	public Conversation getConversation(long id) {
		
		return conversationRepositoryService.getConversation(id).get();
	}

}
