package com.github.riese.rafael.todolist.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.riese.rafael.todolist.dao.TodoDao;
import com.github.riese.rafael.todolist.model.Todo;

@Service
public class TodoService {
	
	@Resource
	private TodoDao todoDao;
	
	public List<Todo> getTodos() {
		return todoDao.findAll();
	}
	
	public Todo getByTitle(String title) {
		return todoDao.findByTitle(title);
	}
	
	public Todo persistTodo(Todo todo) throws Exception {
		Todo todoPersisted = null;
		
		try {
			todoPersisted = todoDao.insert(todo);
		} catch(Exception ex) {
			throw new Exception("An error occured on database, please contact the administrator.");
		}
		return todoPersisted;
	}
	
	public boolean deleteTodo(String id) {
		todoDao.deleteById(id);
		return true;
	}

}
