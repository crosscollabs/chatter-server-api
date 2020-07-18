package com.fergal.chatter.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fergal.chatter.domain.outbox.OutboxItem;
import com.fergal.chatter.message.Message;
import com.fergal.chatter.message.MessageService;

@RestController
@RequestMapping("message")
public class MessageController {
	
	private final MessageService messageService;
	
	
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	
	@PostMapping("/send")
	public boolean sendMessage(Message message) {
		return messageService.sendMessage(message);
	}
	
	@GetMapping("/getall/{id}")
	public List<OutboxItem> getAllMessagesForUser(@PathVariable long id){
		return messageService.getAllMessagesForUser(id);
	}
	
	@GetMapping("/delete/{id}")
	public boolean deleteDeliveredItem(@PathVariable long messageId) {
		return messageService.deleteDeliveredMessage(messageId);
	}

}
