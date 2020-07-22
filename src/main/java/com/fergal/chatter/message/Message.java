package com.fergal.chatter.message;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.stream.Stream;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Message {
	public enum Priority {
	    LOW(100), MEDIUM(200), HIGH(300);
	 
	    private int priority;
	 
	    private Priority(int priority) {
	        this.priority = priority;
	    }
	 
	    public int getPriority() {
	        return priority;
	    }
	 
	    public static Priority of(int priority) {
	      return Stream.of(Priority.values()).filter(p -> p.getPriority()==priority).findFirst().get();
	    }
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private long conversationId;
	
	private long senderId;
	
	private String content;
	
	private Priority priority;
	
	private Timestamp timestamp;

	public Message() {}
	
	public Message(long conversationId, long senderId, String content, Priority priority) {
		this.conversationId = conversationId;
		this.senderId = senderId;
		this.content = content;
		this.priority = priority;
		this.timestamp = Timestamp.from(Instant.now());
	}

	public long getConversationId() {
		return conversationId;
	}

	public void setConversationId(long targetConversationId) {
		this.conversationId = targetConversationId;
	}

	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}

	public long getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	
	
	
	

}
