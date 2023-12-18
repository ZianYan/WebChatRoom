package com.zianyan.javafinalprojectchatweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.zianyan.javafinalprojectchatweb.model.ChatMessage;
import com.zianyan.javafinalprojectchatweb.repo.MessageRepository;
import com.zianyan.javafinalprojectchatweb.repo.UserRepository;

@Controller
public class ChatController {
	
	@Autowired
	private MessageRepository messageRepo;
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		System.out.println("register: " + chatMessage.toString());
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
	
	
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		System.out.println("send: " + chatMessage.toString());
		messageRepo.save(chatMessage);
		return chatMessage;
	}
	
	
	@MessageMapping("/chat.history")
	public void requestHistory(@Payload ChatMessage chatMessage) {
		System.out.println("request by: " + chatMessage.toString());
		
		String userDestination = "/topic/public/" + chatMessage.getSender();
		System.out.println("destination: " + userDestination);

		Iterable<ChatMessage> allRecords = messageRepo.findAll();
		List<ChatMessage> allRecordsList = new ArrayList<>();
		allRecords.forEach(allRecordsList::add);

		messagingTemplate.convertAndSend(userDestination, allRecordsList);
	}
	
}
