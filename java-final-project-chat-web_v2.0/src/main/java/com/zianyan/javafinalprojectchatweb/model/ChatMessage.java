package com.zianyan.javafinalprojectchatweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "message_history")
public class ChatMessage {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "sender")
	private String sender;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "type")
	private MessageType type;
	
	public enum MessageType {
		CHAT,
		LEAVE,
		JOIN,
		REQUEST_HISTORY
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ChatMessage [content=" + content + ", sender=" + sender + ", type=" + type + "]";
	}
	
	
}
