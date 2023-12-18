package com.zianyan.javafinalprojectchatweb.repo;


import org.springframework.data.repository.CrudRepository;

import com.zianyan.javafinalprojectchatweb.model.ChatMessage;

public interface MessageRepository extends CrudRepository<ChatMessage, Integer>{

}
