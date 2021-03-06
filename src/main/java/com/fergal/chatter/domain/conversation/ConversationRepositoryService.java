package com.fergal.chatter.domain.conversation;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class ConversationRepositoryService {

	
	private final ConversationRepository conversationRepository;
	
	public ConversationRepositoryService(ConversationRepository conversationRepository) {
		this.conversationRepository = conversationRepository;
	}
	
	public long createConverasation(Set<Long> members, String conversationName) {

		Conversation conversation = new Conversation(conversationName,members);
		
		conversation = conversationRepository.save(conversation);
		return conversation.getId();
		
	}
	
	public Optional<Conversation> getConversation(long id){
		return conversationRepository.findById(id);
	}
	
	public List<Conversation> getAllCoversationsForUser(long id){
		return conversationRepository.findAllConversationsForUserId(id);
	}
	
	public void deleteAll() {
		conversationRepository.deleteAll();
	}
}
