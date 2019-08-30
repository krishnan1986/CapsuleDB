package com.capsule.taskMgr.rest.model;

import java.util.List;

import com.capsule.taskMgr.model.Task;

/**
 * @author Admin
 *
 */
public class Tasks {
	
	private List<Task> tasks;

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	

}
