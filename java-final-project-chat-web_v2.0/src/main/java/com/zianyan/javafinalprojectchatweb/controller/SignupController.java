package com.zianyan.javafinalprojectchatweb.controller;

import java.util.Map;

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
public class SignupController {
	
	@Autowired
	private UserRepository userRepo;
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SignupController(UserRepository userRepo, DataSource dataSource) {
        this.userRepo = userRepo;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        createTableIfNotExists();
    }
	
	private void createTableIfNotExists() {
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS user_data (" +
	            "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
	            "username VARCHAR(255), " +
	            "password VARCHAR(255))");
		jdbcTemplate.update("INSERT INTO user_data (username, password) VALUES (?, ?)",
                "testUser", "testPassword");
		jdbcTemplate.update("INSERT INTO user_data (username, password) VALUES (?, ?)",
                "Vincent", "abc123");
		jdbcTemplate.update("INSERT INTO user_data (username, password) VALUES (?, ?)",
                "admin", "admin");
		
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("signupForm", new User());
		return "signup";
	}
	
	@PostMapping("/index")
	public String registerUser(@ModelAttribute User user, Model model) {
		System.out.println(user.toString());
		
		model.addAttribute("signupForm", new User());
		
		System.out.println("Query " + user.getUsername() + " in db: " + findByUsername(user.getUsername()));
		
		if (findByUsername(user.getUsername()) == null) {
			jdbcTemplate.update("INSERT INTO user_data (username, password) VALUES (?, ?)",
                    user.getUsername(), user.getPassword());
			model.addAttribute("message", user.getUsername() + " successfully registered!");
			return "index";
		} else {
			model.addAttribute("message", "Username already exists, please choose another username!");
		}
		return "signup";
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
