package com.fergal.chatter.domain.conversation;

import java.util.HashSet;
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
	
	public void addUsersToConversation(Set<Long> newMembers, long conversationId) {
		
		Conversation conversation = conversationRepository.findById(conversationId).get();
		
		Set<Long> discreteMembers = new HashSet<>();
		discreteMembers.addAll(newMembers);
		discreteMembers.addAll(conversation.getAllUsers());
		
		conversation.setAllUsers(discreteMembers);
		
		conversationRepository.save(conversation);
		
	}
	
	public Optional<Conversation> getConversation(long id){
		return conversationRepository.findById(id);
	}
	
	public void deleteAll() {
		conversationRepository.deleteAll();
	}
}
