package com.crud.softtek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.softtek.DAO.TaskRepository;
import com.crud.softtek.controller.TaskStub;
import com.crud.softtek.model.Category;
import com.crud.softtek.model.Task;

/**
 * 
 * @author jasso
 * @JPA Service was set here in which requests from controller are established
 * @Methods from Server interface are implemented here keeping a more structured code
 * 
 */

@Service
public class TaskServiceImpl implements TaskService{

	/**
	 * 
	 * @Instance from Repository in order to implement JPA interface is injected
	 * 
	 */
	private TaskRepository taskrepository;
	

	/**
	 * 
	 * @param taskrepository constructed to initialize the instance just defined
	 * 
	 */
	public TaskServiceImpl(TaskRepository inTaskrepository) {
		
		this.taskrepository = inTaskrepository;
		
	}
	
	/**
	 *
	 *Methods based on project´s document are implemented below 
	 *
	 */
	
	@Override
	public Task createTask(Task task, int taskCategory) {
						
		return taskrepository.saveAndFlush(TaskStub.create(task.getTitle(), 
				task.getDescription(), taskCategory)); 
	
	}

	@Override
	public String deleteTask(Long id) {
		taskrepository.deleteById(id);
		
		return "task deleted";
	
	}

	
	@Override
	public Task updateTask(Long id) {
		
		return taskrepository.updateTask(id);
	
	}
	

	@Override
	public List<Task> getAllTasks() {
		
		return taskrepository.findAll();
		
	}
	
	/**
	 *
	 * Next three methods were set to get the specific category 
	 * we are seeking and show in response
	 */
	@Override
	public List<Task> getAllSomeDayTasks(){
		return taskrepository.findByDue(Category.SOMEDAY);
	}
	
	@Override
	public List<Task> getAllFollowingTasks(){
		return taskrepository.findByDue(Category.FOLLOWING);
	}
	
	@Override
	public List<Task> getAllTodayTasks(){
		return taskrepository.findByDue(Category.TODAY);
	}

	/**
	 * 
	 * This method could be omitted, was set just to ensure
	 * an individual request of getting any task by its id
	 */
	
	@Override
	public Task getTaskById(Long id) {
		Optional<Task> optTask = taskrepository.findById(id);
		
		if (optTask.isPresent())
			return optTask.get();
		else
			return null;

	}

}
