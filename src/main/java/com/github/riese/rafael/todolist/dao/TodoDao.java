package com.github.riese.rafael.todolist.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.github.riese.rafael.todolist.model.Todo;

public interface TodoDao extends MongoRepository<Todo, String>{

	@Query(value = "{ 'title' : ?0 }")
	Todo findByTitle(String title);
	
}
