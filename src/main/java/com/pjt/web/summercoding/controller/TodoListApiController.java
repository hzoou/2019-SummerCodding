package com.pjt.web.summercoding.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjt.web.summercoding.dto.TodoList;
import com.pjt.web.summercoding.service.TodoListService;

@RestController
@RequestMapping(path="/todolists")
public class TodoListApiController {
	@Autowired
	TodoListService todoListService;
	
	@GetMapping
	public Map<String, Object> list() {
		
		List<TodoList> list = todoListService.getTodoLists();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
	
	@PostMapping
	public TodoList register(@RequestBody TodoList todoList,
							HttpServletRequest request) {
		TodoList resultTodoList = todoListService.addTodoList(todoList);
		return resultTodoList;
	}

}
