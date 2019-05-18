package com.pjt.web.summercoding.dao;

public class TodoListDaoSqls {
	public static final String SELECT_TODO = "SELECT * FROM todo WHERE type IS NULL ORDER BY sequence";
	public static final String SELECT_DONE = "SELECT * FROM todo WHERE type IS NOT NULL ORDER BY sequence";
	public static final String SELECT_BY_ID = "SELECT * FROM todo WHERE id = :id";
	public static final String REMOVE = "DELETE FROM todo WHERE id = :id";
	public static final String EDIT = "UPDATE todo SET title = :title, content = :content, sequence = :sequence, deadline = :deadline WHERE id = :id";
	public static final String COMPLETE = "UPDATE todo SET type = 'DONE' WHERE id = :id"; 
	public static final String CANCEL = "UPDATE todo SET type = NULL WHERE id = :id";  
}
