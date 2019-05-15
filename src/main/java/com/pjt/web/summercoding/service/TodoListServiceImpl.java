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
	public List<TodoList> getTodoLists() throws Exception {
		System.out.println("*** TodoListServiceImpl:getTodoLists");
		List<TodoList> list = todolistDao.selectTodo();
		
		return list;
	}
	
	@Override
	public List<TodoList> getDoneLists() throws Exception {
		System.out.println("*** TodoListServiceImpl:getDoneLists()");
		List<TodoList> list = todolistDao.selectDone();
		
		return list;
	}

	@Override
	@Transactional(readOnly=false)
	public TodoList addTodoList(TodoList todoList) throws Exception {
		System.out.println("*** TodoListServiceImpl:addTodoList()");
		Long id = todolistDao.insert(todoList);
		todoList.setId(id);
		todoList.setType("TODO");
		
		return todoList;
	}

	@Override
	@Transactional(readOnly=false)
	public int removeTodoList(Long id) throws Exception {
		System.out.println("*** TodoListServiceImpl:removeTodoList()");
		int delCount = todolistDao.remove(id);
		return delCount;
		
	}
}
