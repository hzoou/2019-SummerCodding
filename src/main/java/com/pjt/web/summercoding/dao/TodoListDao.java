package com.pjt.web.summercoding.dao;

import java.io.IOException;
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
	
	/**
	 * TODO항목에 대한 전체 List 조회 쿼리 실행
	 * 
	 * @return List<TodoList>
	 */
	public List<TodoList> selectTodo() {
		System.out.println("*** TodoListDao:selectTodo()");
		
		return jdbc.query(SELECT_TODO, rowMapper);
	}
	
	/**
	 * DONE항목에 대한 전체 List 조회 쿼리 실행
	 * 
	 * @return List<TodoList>
	 */
	public List<TodoList> selectDone() {
		System.out.println("*** TodoListDao:selectDone()");
		
		return jdbc.query(SELECT_DONE, rowMapper);
	}
	
	/**
	 * 수정 시, 해당 item에 대한 정보 불러오기
	 * 
	 * @param id item Id
	 * @return TodoList
	 */
	public TodoList selectById(int id) {
		System.out.println("*** TodoListDao:selectById()");
		Map<String, ?> params = Collections.singletonMap("id", id);
		
		return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper);
	}
	
	/**
	 * 데이터 등록
	 * 
	 * @param todoList TodoList
	 * @return 1 - 성공 / 0 - 실패
	 */
	// TODO insert된 row 없을 경우(0, 실패) alert 처리 필요
	public int insert(TodoList todoList) {
		System.out.println("*** TodoListDao:insert()");
		SqlParameterSource params = new BeanPropertySqlParameterSource(todoList);
		
		return insertAction.execute(params);
	}
	
	/**
	 * 데이터 수정
	 * 
	 * @param todoList TodoList
	 * @return 1 - 성공 / 0 - 실패
	 */
	public int edit(TodoList todoList) {
		System.out.println("*** TodoListDao:edit()");
		SqlParameterSource params = new BeanPropertySqlParameterSource(todoList);
		
		return jdbc.update(EDIT, params);
	}
	
	/**
	 * 데이터 삭제
	 * 
	 * @param id item Id
	 * @return 1 - 성공 / 0 - 실패
	 */
	public int remove(int id) {
		System.out.println("*** TodoListDao:remove()");
		Map<String, ?> params = Collections.singletonMap("id", id);
		
		return jdbc.update(REMOVE, params);
	}
	
	/**
	 * 데이터 완료 처리 (todo -> done)
	 * 
	 * @param id item Id
	 * @return 1 - 성공 / 0 - 실패
	 */
	public int complete(int id) {
		System.out.println("*** TodoListDao:complete()");
		Map<String, ?> params = Collections.singletonMap("id", id);
		
		return jdbc.update(COMPLETE, params);
	}
	
	/**
	 * 데이터 완료 취소 처리 (done -> todo)
	 * 
	 * @param id item Id
	 * @return 1 - 성공 / 0 - 실패
	 */
	public int cancel(int id) {
		System.out.println("*** TodoListDao:cancel()");
		Map<String, ?> params = Collections.singletonMap("id", id);
		
		return jdbc.update(CANCEL, params);
	}
}
