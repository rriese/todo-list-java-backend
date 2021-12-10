package com.github.riese.rafael.todolist.resource;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.riese.rafael.todolist.dao.EmptyJson;
import com.github.riese.rafael.todolist.model.User;
import com.github.riese.rafael.todolist.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Resource
	private UserService userService;

	@GetMapping("/")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username) {
        User user = userService.getUserByUsername(username);
        
        if (user != null) {
        	return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
        	return new ResponseEntity<>(new EmptyJson(), HttpStatus.OK);
        }
	}
	
	@PostMapping("/")
	public User persistUser(@RequestBody User user) throws Exception {
		return userService.persistUser(user);
	}
	
	@DeleteMapping("/{username}")
	public boolean deleteUser(@PathVariable String username) {
		return userService.deleteUser(username);
	}
	
}
