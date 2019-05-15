package com.pjt.web.summercoding.service;

import java.util.List;

import com.pjt.web.summercoding.dto.TodoList;

public interface TodoListService {
	public List<TodoList> getTodoLists() throws Exception;
	public List<TodoList> getDoneLists() throws Exception;
	public TodoList addTodoList(TodoList todoList) throws Exception;
	public int removeTodoList(Long id) throws Exception;
}
