package com.example.restservice.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping("/api/messages")
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}

	@PostMapping("/api/messages")
	public Message postMessage(@RequestBody Message message) {
		return messageService.saveMessage(message);
	}
}
