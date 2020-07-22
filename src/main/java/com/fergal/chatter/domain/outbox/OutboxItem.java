package com.fergal.chatter.domain.outbox;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fergal.chatter.message.Message.Priority;

@Entity
public class OutboxItem {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long outboxId;
	
	private long conversationId;
	
	private long recipientId;
	
	private String messageContent;
	
	private long senderId;
	
	private Timestamp timestamp;
	
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	public OutboxItem() {}
	
	public OutboxItem(long conversationId,long senderId,long recipientId, String messageContent, Priority priority, Timestamp timestamp) {
		super();
		this.recipientId = recipientId;
		this.senderId=senderId;
		this.conversationId = conversationId;
		this.messageContent = messageContent;
		this.priority = priority;
		this.timestamp = timestamp;
	}
	

	public long getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(long recipientId) {
		this.recipientId = recipientId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}

	public long getOutboxId() {
		return outboxId;
	}


	public long getConversationId() {
		return conversationId;
	}


	public void setConversationId(long conversationId) {
		this.conversationId = conversationId;
	}


	public Priority getPriority() {
		return priority;
	}


	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
