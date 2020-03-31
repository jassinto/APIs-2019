package com.crud.softtek.service;

import java.util.List;

import com.crud.softtek.model.Task;

/**
 * 
 * @author jasso
 * In order to let Methods to be implemented (in service) more structured,
 * an Interface was defined.
 *
 */
public interface TaskService {

	/**
	 * 
	 * @Requests are defined here, in regards of project´s document
	 * noticed the method getById was added just to make sure individual requests
	 * 
	 */
	public List<Task> getAllTasks();
	
	
	public Task getTaskById(final Long id);
	
	
	public Task createTask(Task task, int taskCategory);
	
	
	public String deleteTask(Long id);


	public List<Task> getAllTodayTasks();
	
	public List<Task> getAllSomeDayTasks();
	
	public List<Task> getAllFollowingTasks();


	public Task updateTask(Long id);
	
}
