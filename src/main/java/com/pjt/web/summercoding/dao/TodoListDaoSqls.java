package com.pjt.web.summercoding.dao;

public class TodoListDaoSqls {
	public static final String SELECT_TODO = "SELECT * FROM todo WHERE type IS NULL";
	public static final String SELECT_DONE = "SELECT * FROM todo WHERE type IS NOT NULL";
	public static final String REMOVE = "DELETE FROM todo WHERE id = :id";
}
