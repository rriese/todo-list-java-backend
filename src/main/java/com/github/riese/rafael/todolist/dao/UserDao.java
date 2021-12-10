package com.github.riese.rafael.todolist.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.github.riese.rafael.todolist.model.User;

public interface UserDao extends MongoRepository<User, String>{

	@Query(value = "{ 'username' : ?0 }")
	List<User> findByUsername(String username);
	
}
