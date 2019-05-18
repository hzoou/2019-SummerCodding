package com.pjt.web.summercoding.dto;

/**
 * DTO 객체
 * 
 * @author hzoou
 *
 */
public class TodoList {
	private int id; // 필수, Auto Increment
	private String title; // 필수
	private String content; // 필수
	private String type; // 필수
	private int sequence; // 필수
	private String deadline; // optional
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	@Override
	public String toString() {
		return "TodoList [id=" + id + ", title=" + title + ", content=" + content + ", type=" + type + ", sequence="
				+ sequence + ", deadline=" + deadline + "]";
	}
}
