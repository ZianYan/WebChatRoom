package com.zianyan.javafinalprojectchatweb.controller;

import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zianyan.javafinalprojectchatweb.model.User;
import com.zianyan.javafinalprojectchatweb.repo.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepo;
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public LoginController(UserRepository userRepo, DataSource dataSource) {
        this.userRepo = userRepo;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	
	@PostMapping("/login")
	public String loginUser(@ModelAttribute User user, Model model) {
		System.out.println(user.toString());
		
		model.addAttribute("loginForm", new User());
		
		Map<String, Object> findUser = findByUsername(user.getUsername());
		System.out.println("Query " + user.getUsername() + " in db: " + findUser);
		
		if (findUser == null) {
			model.addAttribute("message", "Username " + user.getUsername() + " do not exist!");
			return "login";
		}
		
		String pw = (String) findUser.get("password");
		if (!pw.equals(user.getPassword())) {
			model.addAttribute("message", "Incorrect password!");
			return "login";
		}
		
		model.addAttribute("username", user.getUsername());
		return "chatroom";
	}
	
	public Map<String, Object> findByUsername(String username) {
        String sql = "SELECT * FROM user_data WHERE username = ?";

        try {
            return jdbcTemplate.queryForMap(sql, username);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
