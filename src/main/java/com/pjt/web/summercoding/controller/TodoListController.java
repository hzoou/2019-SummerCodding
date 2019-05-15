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
	TodoListService todoListService;

	@GetMapping(path="/list")
	public String list(ModelMap model) throws Exception {
		System.out.println("*** TodoListController:list()");
		List<TodoList> todoList = todoListService.getTodoLists();
		List<TodoList> doneList = todoListService.getDoneLists();
		model.addAttribute("todoList", todoList);
		model.addAttribute("doneList", doneList);
				
		return "todo_list";
	}
	
	@RequestMapping("/reg_btn")
	public String reg_btn() {
		System.out.println("*** TodoListController:reg_btn()");
		
		return "todo_reg";
	}
	
	@PostMapping(path="/register")
	public String register(@ModelAttribute TodoList todoList, HttpServletRequest request) throws Exception {
		System.out.println("*** TodoListController:register()");
		todoListService.addTodoList(todoList);
		
		return "redirect:list";
	}
	
	@GetMapping(path="/edit_btn")
	public String edit_btn(ModelMap model, HttpServletRequest request) throws Exception {
		System.out.println("*** TodoListController:edit_btn()");
		TodoList todolist = todoListService.getTodoListById(Integer.parseInt(request.getParameter("id")));
		model.addAttribute("list", todolist);
		
		return "todo_edit";
	}
	
	@PostMapping(path="/edit")
	public String edit(@ModelAttribute TodoList todoList, HttpServletRequest request) throws Exception {
		System.out.println("*** TodoListController:edit()");
		todoListService.editTodoList(todoList);
		
		return "redirect:list";
	}
	
	@RequestMapping("/remove")
	public String remove(HttpServletRequest request) throws Exception {
		System.out.println("*** TodoListController:remove()");
		String id = request.getParameter("id");
		todoListService.removeTodoList(Integer.parseInt(id));
		
		return "redirect:list";
	}
}
