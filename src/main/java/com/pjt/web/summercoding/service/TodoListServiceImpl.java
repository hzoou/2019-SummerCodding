package com.pjt.web.summercoding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pjt.web.summercoding.dao.TodoListDao;
import com.pjt.web.summercoding.dto.TodoList;

@Service
public class TodoListServiceImpl implements TodoListService {
	@Autowired
	TodoListDao todolistDao;

	@Override
	public List<TodoList> getTodoLists() {
		System.out.println("*** TodoListServiceImpl:getTodoLists()");
		List<TodoList> list = todolistDao.selectTodo();
		
		return list;
	}
	
	@Override
	public List<TodoList> getDoneLists() {
		System.out.println("*** TodoListServiceImpl:getDoneLists()");
		List<TodoList> list = todolistDao.selectDone();
		
		return list;
	}
	
	@Override
	public TodoList getTodoListById(int id) {
		System.out.println("*** TodoListServiceImpl:getTodoListById()");

		return todolistDao.selectById(id);
	}

	@Override
	@Transactional(readOnly=false)
	public TodoList addTodoList(TodoList todoList) {
		System.out.println("*** TodoListServiceImpl:addTodoList()");
		int id = todolistDao.insert(todoList);
		todoList.setId(id);
		
		return todoList;
	}
	
	@Override
	@Transactional(readOnly=false)
	public void editTodoList(TodoList todoList) {
		System.out.println("*** TodoListServiceImpl:editTodoList()");
		todolistDao.edit(todoList);
	}

	@Override
	@Transactional(readOnly=false)
	public void removeTodoList(int id) {
		System.out.println("*** TodoListServiceImpl:removeTodoList()");
		todolistDao.remove(id);
	}

	@Override
	public void completeTodoList(int id) {
		System.out.println("*** TodoListServiceImpl:completeTodoList()");
		todolistDao.complete(id);	
	}

	@Override
	public void cancelTodoList(int id) {
		System.out.println("*** TodoListServiceImpl:cancelTodoList()");
		todolistDao.cancel(id);	
	}
	
}
