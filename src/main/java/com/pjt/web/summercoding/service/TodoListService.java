package com.pjt.web.summercoding.service;

import java.util.List;

import com.pjt.web.summercoding.dto.TodoList;

public interface TodoListService {
	public List<TodoList> getTodoLists();
	public List<TodoList> getDoneLists();
	public TodoList getTodoListById(int id);
	public TodoList addTodoList(TodoList todoList);
	public void editTodoList(TodoList todoList);
	public void removeTodoList(int id);
	public void completeTodoList(int id);
	public void cancelTodoList(int id);
}
