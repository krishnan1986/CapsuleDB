package com.capsule.taskMgr.dao;

import java.util.List;

import com.capsule.taskMgr.model.Task;

public interface TaskOperations {
	
	public List<Task> fetchTasks();
	public List<Task> fetchTasks(Task filter);
	public void insertTask(Task task);
	
	public void updateTask(Task task);
	

}
