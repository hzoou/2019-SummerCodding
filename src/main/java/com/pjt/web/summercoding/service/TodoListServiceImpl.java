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
		List<TodoList> list = todolistDao.selectAll();
		return list;
	}

	@Override
	@Transactional(readOnly=false)
	public TodoList addTodoList(TodoList todoList) {
		Long id = todolistDao.insert(todoList);
		todoList.setId(id);
		todoList.setType("TODO");
		
		return todoList;
	}
}
