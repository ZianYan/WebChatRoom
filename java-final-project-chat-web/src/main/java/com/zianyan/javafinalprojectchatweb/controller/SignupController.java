package com.zianyan.javafinalprojectchatweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zianyan.javafinalprojectchatweb.model.User;
import com.zianyan.javafinalprojectchatweb.repo.UserRepository;


@Controller
public class SignupController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("signupForm", new User());
		return "signup";
	}
	
	@PostMapping("/index")
	public String registerUser(@ModelAttribute User user, Model model) {
		System.out.println(user.toString());
		model.addAttribute("signupForm", new User());
		if (userRepo.findByUsername(user.getUsername()).isEmpty()) {
			User user_inserted = userRepo.save(user);
			model.addAttribute("message", user_inserted.getUsername() + " successfully registered!");
			return "index";
		} 
		model.addAttribute("message", "Username already exists, please choose another username!");
		return "signup";
		
	}
}
