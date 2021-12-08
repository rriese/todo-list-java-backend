package com.github.riese.rafael.todolist.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.riese.rafael.todolist.dao.UserDao;
import com.github.riese.rafael.todolist.models.User;

@Service
public class UserService {
	
	@Resource
	private UserDao userDao;
	
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
	public User getUserByUsername(String username) {
		return userDao.getUsers().stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
	}
	
	public User persistUser(User user) throws Exception {
		userDao.addUser(user);
		return user;
	}
	
	public boolean deleteUser(String username) {
		return userDao.removeUser(username);
	}
	
}
