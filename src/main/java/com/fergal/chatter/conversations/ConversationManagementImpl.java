package com.fergal.chatter.conversations;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fergal.chatter.domain.conversation.Conversation;
import com.fergal.chatter.domain.conversation.ConversationRepositoryService;
import com.fergal.chatter.dto.ConversationDto;
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
	public ConversationDto getConversation(long id) {
		
		Optional<Conversation> c = conversationRepositoryService.getConversation(id);
		if(c.isPresent()) {
		return new ConversationDto(c.get());
		} else {
			return null;
		}
	}
	
	@Override
	public List<ConversationDto> getAllConversationsForUserId(long id){
		
		return conversationRepositoryService.getAllCoversationsForUser(id)
				.stream().map(c->new ConversationDto(c)).collect(Collectors.toList());
	}

}
