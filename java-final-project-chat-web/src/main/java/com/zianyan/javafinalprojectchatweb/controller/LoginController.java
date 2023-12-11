package com.zianyan.javafinalprojectchatweb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zianyan.javafinalprojectchatweb.model.User;
import com.zianyan.javafinalprojectchatweb.repo.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	
	@PostMapping("/login")
	public String loginUser(@ModelAttribute User user, Model model) {
		System.out.println(user.toString());
		model.addAttribute("loginForm", new User());
		System.out.println(userRepo.findByUsername(user.getUsername()));
		Optional<User> findUser = userRepo.findByUsername(user.getUsername());
		if (findUser.isEmpty()) {
			model.addAttribute("message", "Username " + user.getUsername() + " do not exist!");
			return "login";
		}
		String pw = findUser.get().getPassword();
		if (!pw.equals(user.getPassword())) {
			model.addAttribute("message", "Incorrect password!");
			return "login";
		}
		
		model.addAttribute("username", user.getUsername());
		return "chatroom";
		
	}
}
