package com.pjt.web.summercoding.service;

import java.util.List;

import com.pjt.web.summercoding.dto.TodoList;

public interface TodoListService {
	public List<TodoList> getTodoLists() throws Exception;
	public List<TodoList> getDoneLists() throws Exception;
	public TodoList getTodoListById(int id) throws Exception;
	public TodoList addTodoList(TodoList todoList) throws Exception;
	public void editTodoList(TodoList todoList) throws Exception;
	public void removeTodoList(int id) throws Exception;
	public void completeTodoList(int id) throws Exception;
	public void cancelTodoList(int id) throws Exception;
}
