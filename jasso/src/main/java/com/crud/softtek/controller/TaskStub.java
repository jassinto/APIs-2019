package com.crud.softtek.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crud.softtek.model.Category;
import com.crud.softtek.model.Task;


/**
 * 
 * @author jasso
 * TaskStub class is used as reference to create a db
 *
 */
public class TaskStub {
	
	/**
	 * 
	 * @DataBase by H2 was used in regards of use JPA, this means 
	 * statics methods and the collection are not used
	 * 
	 */
	
	private static Map<Long, Task> tasks = new HashMap<>();
	private static Long idIndex = 3L;
	
	/**
	 * 
	 * This methods are used no longer in order to create data based 
	 * on JPA Repository implementation 
	 */
	
	
	/**
	 * 
	 * @Methods to be declared and be used by Service are declared below
	 * 
	 */
	public static List<Task> get() {
		return new ArrayList<Task>(tasks.values());
	}
	
	public static Task create(String title, String description, int categorycode) {
		idIndex += idIndex;
		Task task = new Task(idIndex, title, 
				description, Category.valueOf(categorycode));
		tasks.put(idIndex, task);
		return task;
	}
	
	public static Task update(Long id, boolean completed) {
		Task task = tasks.get(id);
		task.setCompleted(completed);
		return task;
	}
	
	public static void delete(Long id) {
		tasks.remove(id);
	}
	
	/*
	 * GetTaskById method was added to implement individual requests
	 */
	
	public static Task getTaskById(Long id) {
		return tasks.get(id);
	}
	
	public static List<Task> getByCategory() {
		
		return null;//new List<Task>(tasks.containsValue(Category.TODAY));
	}


}
