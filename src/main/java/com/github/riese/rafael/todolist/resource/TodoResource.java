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
import com.github.riese.rafael.todolist.model.Todo;
import com.github.riese.rafael.todolist.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoResource {

	@Resource
	private TodoService todoService;
	
	@GetMapping("/")
	public List<Todo> getUsers() {
		return todoService.getTodos();
	}
	
	@PostMapping("/")
	public Todo persistTodo(@RequestBody Todo todo) throws Exception {
		return todoService.persistTodo(todo);
	}
	
	@GetMapping("/{title}")
	public ResponseEntity<?> getTodoByTitle(@PathVariable("title") String title) {
        Todo todo = todoService.getByTitle(title);
        
        if (todo != null) {
        	return new ResponseEntity<>(todo, HttpStatus.OK);
        } else {
        	return new ResponseEntity<>(new EmptyJson(), HttpStatus.OK);
        }
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteTodo(@PathVariable String id) {
		return todoService.deleteTodo(id);
	}
	
}
