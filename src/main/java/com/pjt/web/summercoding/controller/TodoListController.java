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

	/**
	 * 리스트 조회
	 * 
	 * @param model ModelMap(todoList, doneList)
	 * @return "todo_list" // call todo_list.jsp
	 * @throws Exception 
	 */
	@GetMapping(path="/list")
	public String list(ModelMap model) throws Exception {
		System.out.println("*** TodoListController:list()");
		List<TodoList> todoList = todoListService.getTodoLists();
		List<TodoList> doneList = todoListService.getDoneLists();
		model.addAttribute("todoList", todoList);
		model.addAttribute("doneList", doneList);
				
		return "todo_list";
	}
	
	/**
	 * 등록버튼 클릭
	 * 
	 * @return "todo_reg" // call todo_reg.jsp
	 */
	@RequestMapping("/reg_btn")
	public String reg_btn() {
		System.out.println("*** TodoListController:reg_btn()");
		
		return "todo_reg";
	}
	
	/**
	 * 데이터 등록
	 * 
	 * @param todoList TodoList
	 * @return "list" // call method list()
	 * @throws Exception
	 */
	@PostMapping(path="/register")
	public String register(@ModelAttribute TodoList todoList) throws Exception {
		System.out.println("*** TodoListController:register()");
	
		todoListService.addTodoList(todoList);
		
		return "redirect:list";
	}
	
	
	/**
	 * 수정버튼 클릭
	 * 
	 * @param model ModelMap(todoList)
	 * @param request HttpServletRequest
	 * @return "todo_edit" // call todo_edit.jsp
	 * @throws Exception
	 */
	@GetMapping(path="/edit_btn")
	public String edit_btn(ModelMap model, HttpServletRequest request) throws Exception {
		System.out.println("*** TodoListController:edit_btn()");
		TodoList todolist = todoListService.getTodoListById(Integer.parseInt(request.getParameter("id")));
		model.addAttribute("list", todolist);
		
		return "todo_edit";
	}
	
	
	/**
	 * 데이터 수정
	 * 
	 * @param todoList TodoList
	 * @param request HttpServletRequest
	 * @return "list" // call method list()
	 * @throws Exception
	 */
	@PostMapping(path="/edit")
	public String edit(@ModelAttribute TodoList todoList, HttpServletRequest request) throws Exception {
		System.out.println("*** TodoListController:edit()");
		todoListService.editTodoList(todoList);
		
		return "redirect:list";
	}
	
	
	/**
	 * 데이터 삭제
	 * 
	 * @param request HttpServletRequest
	 * @return "list" // call method list()
	 * @throws Exception
	 */
	@RequestMapping("/remove")
	public String remove(HttpServletRequest request) throws Exception {
		System.out.println("*** TodoListController:remove()");
		String id = request.getParameter("id");
		todoListService.removeTodoList(Integer.parseInt(id));
		
		return "redirect:list";
	}
	
	
	/**
	 * 데이터 완료 처리 (todo->done)
	 * 
	 * @param request HttpServletRequest
	 * @return "list" // call method list()
	 * @throws Exception
	 */
	@RequestMapping("/complete")
	public String complete(HttpServletRequest request) throws Exception {
		System.out.println("*** TodoListController:complete()");
		String id = request.getParameter("id");
		todoListService.completeTodoList(Integer.parseInt(id));
		
		return "redirect:list";
	}
	
	
	/**
	 * 데이터 완료 취소 (done->todo)
	 * 
	 * @param request HttpServletRequest
	 * @return "list" // call method list()
	 * @throws Exception
	 */
	@RequestMapping("/cancel")
	public String cancel(HttpServletRequest request) throws Exception {
		System.out.println("*** TodoListController:cancel()");
		String id = request.getParameter("id");
		todoListService.cancelTodoList(Integer.parseInt(id));
		
		return "redirect:list";
	}
}
