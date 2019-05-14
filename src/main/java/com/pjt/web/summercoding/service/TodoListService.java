package com.pjt.web.summercoding.service;

import java.util.List;

import com.pjt.web.summercoding.dto.TodoList;

public interface TodoListService {
	public List<TodoList> getTodoLists();
	public TodoList addTodoList(TodoList todoList);
}
