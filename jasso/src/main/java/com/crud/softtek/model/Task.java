package com.crud.softtek.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author jasso
 * @JPA entity was set here as the main table which has the primary key 
 * and it is going to be the entity class called by JPA interface
 *
 */
@Entity
public class Task {
	
	/**
	 * @Id Primary key 
	 */
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private boolean completed;
	private Category due;
	
	
	/**
	 * 
	 * @param id
	 * @param title
	 * @param description
	 * @param due
	 * @param tags
	 * Constructor is defined with its parameters and getters and setters 
	 * are defined below 
	 * 
	 */
	public Task(Long id, String title, String description, Category due) {
		
		this.id = id;
		this.title = title;
		this.description = description;
		this.due = due;
		
	}
	
	
	/**
	 * void Constructor was set initializing Task 
	 */
	public Task() {
		
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
	
	
}
