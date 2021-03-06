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
 * Notice this Resource was not be requested in project¨s document
 * was added just to complete the reference in TaskStub
 *
 */
@RestController
@RequestMapping("todo/api/v1/json/next")
public class ResourceNext {


	/**
	 * 
	 * @Instance of Service defined is injected
	 * 
	 */
	private TaskService service;
	
	
	/**
	 * 
	 * @param service is declared in order to initialize the object 
	 * 
	 */
	public ResourceNext(TaskService service) {
		this.service = service;
	}
	
	
	/**
	 * 
	 * @Http methods are declared below
	 * 
	 */
	@GetMapping()
	public List<Task> getAllTasks( Category FOLLOWING ) {
		
		
		return service.getAllFollowingTasks();
		
	}
	
	
	@PostMapping
	public Task createTask(@RequestBody Task task) {
		
		return service.createTask(task, 2);
		
	}
	
	
	@DeleteMapping("{id}")
	public String deleteTask(@PathVariable Long id) {
		
		return service.deleteTask(id);
	}
	
	
}
