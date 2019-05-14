package com.pjt.web.summercoding.dto;

import java.util.Date;

public class TodoList {
	private Long id;
	private String title;
	private String content;
	private String type;
	private int sequence;
	private Date limitdate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public Date getLimitdate() {
		return limitdate;
	}
	public void setLimitdate(Date limitdate) {
		this.limitdate = limitdate;
	}
	
	@Override
	public String toString() {
		return "TodoList [id=" + id + ", title=" + title + ", content=" + content + ", type=" + type + ", sequence="
				+ sequence + ", limitdate=" + limitdate + "]";
	}
}
