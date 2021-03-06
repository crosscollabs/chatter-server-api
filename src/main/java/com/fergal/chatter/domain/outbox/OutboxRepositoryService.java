package com.fergal.chatter.domain.outbox;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.fergal.chatter.message.Message.Priority;


@Component
public class OutboxRepositoryService{
	
	private final OutboxItemRepository outboxRepository;
	
	public OutboxRepositoryService(OutboxItemRepository outboxRepository) {
		this.outboxRepository = outboxRepository;
	}
	
	public boolean createOutboxItems(long conversationId,Set<Long> recipients, long senderId, String content, Priority priority) {
		
		Timestamp timestamp = Timestamp.from(Instant.now());
		for( long recipientId : recipients) {
			
			OutboxItem outboxItem = new OutboxItem(conversationId,senderId,recipientId,content,priority,timestamp);
			
			outboxRepository.save(outboxItem);
		}
		
		return true;
		
	}
	
	public List<OutboxItem> getAllOutboxItemsForUser(long userId){
		return outboxRepository.findAllByRecipientId(userId);
	}
	
	public void deleteOutboxItem(long messageId) {
		outboxRepository.deleteById(messageId);
	}
	
	public void deleteAll() {
		outboxRepository.deleteAll();
	}
}
