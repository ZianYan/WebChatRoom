package com.zianyan.javafinalprojectchatweb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zianyan.javafinalprojectchatweb.model.User;
import com.zianyan.javafinalprojectchatweb.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
	
}
