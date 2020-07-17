package com.fergal.chatter.message;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fergal.chatter.domain.outbox.OutboxItem;

@Service
public interface MessageService {
	
	public boolean sendMessage(Message message);
	
	public List<OutboxItem> getAllMessagesForUser(long id);

}
