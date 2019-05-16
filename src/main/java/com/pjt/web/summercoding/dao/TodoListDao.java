package com.pjt.web.summercoding.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.mysql.fabric.xmlrpc.base.Params;
import com.pjt.web.summercoding.dto.TodoList;

import static com.pjt.web.summercoding.dao.TodoListDaoSqls.*;

@Repository
public class TodoListDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<TodoList> rowMapper = BeanPropertyRowMapper.newInstance(TodoList.class);
	
	public TodoListDao(DataSource dataSource) {
		System.out.println("*** TodoListDao:TodoListDao()");
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("todo")
                .usingGeneratedKeyColumns("id");
	}
	
	public List<TodoList> selectTodo() {
		System.out.println("*** TodoListDao:selectTodo()");
		
		return jdbc.query(SELECT_TODO, rowMapper);
	}
	
	public List<TodoList> selectDone() {
		System.out.println("*** TodoListDao:selectDone()");
		
		return jdbc.query(SELECT_DONE, rowMapper);
	}
	
	public TodoList selectById(int id) {
		System.out.println("*** TodoListDao:selectById()");
		Map<String, ?> params = Collections.singletonMap("id", id);
		
		return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper);
	}
	
	public int insert(TodoList todoList) {
		System.out.println("*** TodoListDao:insert()");
		SqlParameterSource params = new BeanPropertySqlParameterSource(todoList);
		
		return insertAction.execute(params);
	}
	
	public int edit(TodoList todoList) {
		System.out.println("*** TodoListDao:edit()");
		System.out.println(todoList);
		SqlParameterSource params = new BeanPropertySqlParameterSource(todoList);
		
		return jdbc.update(EDIT, params);
	}
	
	public int remove(int id) {
		System.out.println("*** TodoListDao:remove()");
		Map<String, ?> params = Collections.singletonMap("id", id);
		
		return jdbc.update(REMOVE, params);
	}
	
	public int complete(int id) {
		System.out.println("*** TodoListDao:complete()");
		Map<String, ?> params = Collections.singletonMap("id", id);
		
		return jdbc.update(COMPLETE, params);
	}
	
	public int cancel(int id) {
		System.out.println("*** TodoListDao:cancel()");
		Map<String, ?> params = Collections.singletonMap("id", id);
		
		return jdbc.update(CANCEL, params);
	}
}
