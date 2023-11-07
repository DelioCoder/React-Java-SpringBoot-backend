package com.todowebservice.todorestfullwebservices.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import com.todowebservice.todorestfullwebservices.model.Todo;

@Service
public class TodoService
{
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todoCount = 0;
	
	static {
		todos.add(new Todo(todoCount++, "souldeath", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(todoCount++, "souldeath", "Learn DevOps", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(todoCount++, "souldeath", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUsername(String name)
	{
		
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(name);
		
		return todos.stream().filter(predicate).toList();
	}
	
	public Todo addTodoinList(String username, String description, LocalDate targetDate, boolean done)
	{
		Todo todo = new Todo(++todoCount, username, description, targetDate, done);
		
		todos.add(todo);
		
		return todo;
	}
	
	public void deleteTodoById(int id)
	{
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteTodoById(todo.getId());
		todos.add(todo);
		
	}
	
}
