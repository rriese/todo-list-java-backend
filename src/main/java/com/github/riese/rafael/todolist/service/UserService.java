package com.github.riese.rafael.todolist.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.riese.rafael.todolist.dao.UserDao;
import com.github.riese.rafael.todolist.model.User;

@Service
public class UserService {
	
	@Resource
	private UserDao userDao;

	public List<User> getUsers() {
		return userDao.findAll();
	}
	
	public User getUserByUsername(String username) {
		List<User> user = userDao.findByUsername(username);
		return user.size() > 0 ? user.get(0) : null;
	}
	
	public User persistUser(User user) throws Exception {
		return userDao.insert(user);
	}
	
	public boolean deleteUser(String username) {
		User user = this.getUserByUsername(username);
		
		if (user != null) {
			userDao.deleteById(user.getId());
			return true;			
		}
		return false;
	}
	
}
