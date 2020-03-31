package com.softtek.service;

import java.util.List;

import com.softtek.controller.TaskStub;
import com.softtek.model.Task;

public class TaskServiceImpl implements TaskService {

	@Override
	public List<Task> get() {
		return TaskStub.get();
	}

	@Override
	public Task create(String title, String description, int category) {
		return TaskStub.create(title, description, category);
	}

	@Override
	public void delete(Long taskId) {
		TaskStub.delete(taskId);
	}

	
}
