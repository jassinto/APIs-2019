package com.softtek.model;

import java.util.List;

public class Task {
	
	private Long id;
	private String title;
	private String description;
	private boolean completed;
	private Category due;
	private List<Tag> tags;
	
	
	public Task(Long id, String title, String description, Category due, List<Tag> tags) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.due = due;
		this.tags = tags;
	}
	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public Category getDue() {
		return due;
	}
	public void setDue(Category due) {
		this.due = due;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	
}
