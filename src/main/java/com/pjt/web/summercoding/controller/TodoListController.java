package com.pjt.web.summercoding.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pjt.web.summercoding.dto.TodoList;
import com.pjt.web.summercoding.service.TodoListService;

@Controller
public class TodoListController {
	@Autowired
	TodoListService todolistService;

	@GetMapping(path="/list")
	public String list(ModelMap model) {
		List<TodoList> list = todolistService.getTodoLists();
		
		model.addAttribute("list", list);
				
		return "todo_list";
	}
	
	@PostMapping(path="/register")
	public String register(@ModelAttribute TodoList todoList,
							HttpServletRequest request) {
		
		todolistService.addTodoList(todoList);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reg_btn")
	public String reg_btn() {
		return "todo_reg";
	}
}
