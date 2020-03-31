package com.crud.softtek.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.crud.softtek.model.Category;
import com.crud.softtek.model.Task;


/**
 * 
 * @author jasso
 * Interface Repository is created in order to implements JPA Repository
 * which shall use H2DB embedded in order to persist data 
 *
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	/**
	 * 
	 * @param due to get category type to each endpoint defined
	 * 
	 */
	public List<Task> findByDue(Category due);
	
	/**
	 * 
	 * @param id to make sure the id we are about to update is the correct one
	 * @return task with the param we want to update, this case boolean true 
	 * 
	 */
	public default Task updateTask(Long id) {
	
	Optional<Task> taskById = findById(id);
	Task task;
		
	if(taskById.isPresent()) {
		task = taskById.get();
		task.setCompleted(true);
			
			return saveAndFlush(task);
		
	}
	
	return null;
		
	}
	
}
