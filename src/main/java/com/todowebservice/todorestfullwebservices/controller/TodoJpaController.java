package com.todowebservice.todorestfullwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todowebservice.todorestfullwebservices.model.Todo;
import com.todowebservice.todorestfullwebservices.repository.TodoRepository;
import com.todowebservice.todorestfullwebservices.service.TodoService;

@RestController
public class TodoJpaController
{

	@Autowired
	private TodoRepository todoRepository;
	
	@GetMapping("/users/{username}/list-todo")
	public List<Todo> getTodos(@PathVariable String username)
	{
		
		return this.todoRepository.findTodosByUsername(username);
		
		
	}
	
	@GetMapping("/users/{username}/todo/{id}")
	public Todo getTodoById(@PathVariable String username, @PathVariable int id)
	{
		
		return this.todoRepository.findById(id).get();
		
	}
	
	@DeleteMapping("/users/{username}/todo/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id)
	{
		
		this.todoRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/users/{username}/todo/{id}")
	public Todo updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo)
	{
		
		this.todoRepository.save(todo);
		
		return todo;
		
	}
	
	@PostMapping("/users/{username}/todo")
	public Todo createTodo(@PathVariable String username, @RequestBody Todo todo)
	{
		
		todo.setUsername(username);
		todo.setId(null);
		
		return this.todoRepository.save(todo);
	
	}
	
}
