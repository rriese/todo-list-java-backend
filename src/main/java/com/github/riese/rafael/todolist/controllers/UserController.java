package com.github.riese.rafael.todolist.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.riese.rafael.todolist.models.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private List<User> users = new ArrayList<User>();
	
	@GetMapping("/")
	public List<User> getUsers() {
		return this.users;
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
	}
	
	@PostMapping("/")
	public User persistUser(@RequestBody User user) {
		this.users.add(user);
		return user;
	}
	
	@DeleteMapping("/{username}")
	public boolean deleteUser(@PathVariable String username) {
		return users.removeIf(c -> c.getUsername().equals(username));
	}
	
}
