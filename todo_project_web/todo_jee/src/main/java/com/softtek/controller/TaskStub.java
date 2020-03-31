package com.softtek.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.softtek.model.Category;
import com.softtek.model.Tag;
import com.softtek.model.Task;

public class TaskStub {
	
	private static Map<Long, Task> tasks = new HashMap<>();
	private static Long idIndex = 3L;
	
	static {
		Tag security = new Tag(1L, "Security");
		Tag pl = new Tag(2L, "PL");
		
		List<Tag> task1Tags = new ArrayList<>();
		List<Tag> task2Tags = new ArrayList<>();
		
		Task task1 = new Task(1L, "SSECPRO Scans", 
				"Send email to request scans to apps", 
				Category.TODAY, task1Tags);
		
		Task task2 = new Task(2L, "Project Metrics", 
				"Reliability variance & Task completed", 
				Category.TODAY, task2Tags);
		
		Task task3 = new Task(3L, "US23145", 
				"Send email to Jsoh to clarify odd behavior", 
				Category.TODAY, null);
		
		task1Tags.add(security);
		task1Tags.add(pl);
		
		task2Tags.add(pl);
		
		tasks.put(1L, task1);
		tasks.put(2L, task2);
		tasks.put(3L, task3);
	}
	
	public static List<Task> get() {
		return new ArrayList<Task>(tasks.values());
	}
	
	public static Task create(String title, String description, int categorycode) {
		idIndex += idIndex;
		Task task = new Task(idIndex, title, 
				description, Category.valueOf(categorycode), null);
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
}
