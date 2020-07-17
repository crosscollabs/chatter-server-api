package com.fergal.chatter.message;

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
	
	private long targetConversationId;
	
	private long senderId;
	
	private String content;
	
	private Priority priority;

	
	public Message(long targetConversationId, long senderId, String content, Priority priority) {
		this.targetConversationId = targetConversationId;
		this.senderId = senderId;
		this.content = content;
		this.priority = priority;
	}

	public long getTargetConversationId() {
		return targetConversationId;
	}

	public void setTargetConversationId(long targetConversationId) {
		this.targetConversationId = targetConversationId;
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
	
	

}
