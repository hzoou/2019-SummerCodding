package com.pjt.web.summercoding.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.pjt.web.summercoding.dto.TodoList;

import static com.pjt.web.summercoding.dao.TodoListDaoSqls.*;

@Repository
public class TodoListDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<TodoList> rowMapper = BeanPropertyRowMapper.newInstance(TodoList.class);
	
	public TodoListDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("todo")
                .usingGeneratedKeyColumns("id");
	}
	
	public List<TodoList> selectAll() {
		return jdbc.query(SELECT_ALL, rowMapper);
	}
	
	public Long insert(TodoList todoList) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(todoList);
		return insertAction.executeAndReturnKey(params).longValue();
	}
}
