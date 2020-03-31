package com.crud.softtek.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.softtek.model.Category;
import com.crud.softtek.model.Task;
import com.crud.softtek.service.TaskService;

/**
 * 
 * @author jasso
 * Mapping is established according project´s document request
 * "This is an extra endpoint in which are defined extra methods, 
 * just to show all methods declared in TaskStub"
 */
@RestController
@RequestMapping("todo/api/v1/json/someday")
public class ResourceSomeDay {

	/**
	 * 
	 * @Instance of Service defined is injected
	 */
	private TaskService service;
	
	
	/**
	 * 
	 * @param service is declared in order to initialize the object 
	 */
	public ResourceSomeDay(TaskService service) {
		this.service = service;
	}
	

	/**
	 * 
	 * @Http methods are declared below
	 */
	@GetMapping()
	public List<Task> getAllTasks( Category SOMEDAY) {
		
		return service.getAllSomeDayTasks();
		
	}
	
	
	@PostMapping
	public Task createTask(@RequestBody Task task) {
		
		return service.createTask(task, 3);
		
	}
	
	
	@DeleteMapping("{id}")
	public String deleteTask(@PathVariable Long id) {
		
		return service.deleteTask(id);
	}
	

	
	/**
	 * 
	 * @param id to specify the value of getting data
	 * @return Task by its id
	 * "An extra method"
	 */
	@GetMapping(value="{id}")
	public Task getTaskById(@PathVariable Long id) {
		
		return service.getTaskById(id);
	}
	

	/**
	 * 
	 * @param List of Task to get all tasks 
	 * @return All tasks created 
	 * "An extra method"
	 */
	@GetMapping(value="/alltasks")
	public List<Task> getAllTasks() {
		
		return service.getAllTasks();
		
	}
	
}	