package com.github.riese.rafael.todolist.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.riese.rafael.todolist.models.User;

@Repository
public class UserDao {
	
	private List<User> usersDB = new ArrayList<User>();
	
	public void addUser(User user) throws Exception {
		boolean hasAlreadyUserWithUsername = this.usersDB.stream().filter(u -> u.getUsername().equals(user.getUsername())).findFirst().isPresent();
		if (hasAlreadyUserWithUsername) throw new Exception("Username already in use!");
		this.usersDB.add(user);
	}
	
	public List<User> getUsers() {
		return this.usersDB;
	}
	
	public boolean removeUser(String username) {
		return this.usersDB.removeIf(user -> user.getUsername().equals(username));
	}
	
}
