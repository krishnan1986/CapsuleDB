package com.capsule.taskMgr.dao;

import java.util.List;

import com.capsule.taskMgr.model.Task;

public interface TaskOperations {
	
	public List<Task> fetchTasks();
	public List<Task> fetchTasks(String name);
	public void insertTask(Task task);
	
	public void updateTask(Task task);
	

}
