package com.fergal.chatter.message;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fergal.chatter.conversations.ConversationManagement;
import com.fergal.chatter.domain.outbox.OutboxItem;
import com.fergal.chatter.domain.outbox.OutboxRepositoryService;

@Service
public class MessageServiceImpl implements MessageService{

	private final ConversationManagement conversationManagement;
	
	private final OutboxRepositoryService outboxRepositoryService;
	
	public MessageServiceImpl(ConversationManagement conversationManagement,
			OutboxRepositoryService outboxRepositoryService) {
		this.conversationManagement = conversationManagement;
		this.outboxRepositoryService = outboxRepositoryService;
		
	}
	
	
	@Override
	public boolean sendMessage(Message message) {
		Set<Long> recipients = new HashSet<>();
		recipients.addAll(conversationManagement.getConversation(message.getTargetConversationId()).
				getAllUsers()
				.stream().filter(u-> u!=message.getSenderId())
				.collect(Collectors.toList()));
		
		return outboxRepositoryService.createOutboxItems(message.getTargetConversationId(), recipients, message.getSenderId(),
				message.getContent(), message.getPriority());
		
	}

	@Override
	public List<OutboxItem> getAllMessagesForUser(long id) {
		return outboxRepositoryService.getAllOutboxItemsForUser(id);
	}

}
