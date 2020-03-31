package com.softtek.service;

import java.util.List;

import com.softtek.model.Task;

public interface TaskService {

	public List<Task> get();
	public Task create(String title, String description, int category);
	public void delete(Long taskId);
}
