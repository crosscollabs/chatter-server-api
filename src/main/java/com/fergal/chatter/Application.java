package com.fergal.chatter;


import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fergal.chatter.conversations.ConversationManagement;
import com.fergal.chatter.message.MessageService;
import com.fergal.chatter.users.UserManagement;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	UserManagement userManagement;
	
	@Autowired
	ConversationManagement conversationManagement;
	
	@Autowired
	MessageService messageService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Override
	public void run(String... args) throws Exception {
//		long user1 = 1l;
//		long user2 = 2l;
//		
//		userManagement.createUser("Fergal", "McMahon","fergalmcm");
//		userManagement.createUser("Shane", "O'Leary", "shaneol");
//		
//		List<Long> members = new ArrayList<>();
//		members.add(user1);
//		members.add(user2);
//		ConversationRequest conversationRequest = new ConversationRequest(members,"Test");
//		long conversationId = conversationManagement.createConversation(conversationRequest);
//
//		Message message = new Message(conversationId,user1,"Hello!",Priority.LOW);
//		messageService.sendMessage(message);
	}
}
