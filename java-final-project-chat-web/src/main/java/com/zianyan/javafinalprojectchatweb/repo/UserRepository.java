package com.zianyan.javafinalprojectchatweb.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.zianyan.javafinalprojectchatweb.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	Optional<User> findByUsername(String username);
}
