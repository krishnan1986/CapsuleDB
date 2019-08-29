package com.capsule.taskMgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capsule.taskMgr.dao.TaskDao;
import com.capsule.taskMgr.model.Task;;

@RestController
@RequestMapping("task")
public class ViewTaskController {
	
	@Autowired
	TaskDao taskdao;
	
	@GetMapping(value="getTasklist")
	public  List<Task> getTaskFromUI(@RequestBody Task filterCriteria)
	{
		return taskdao.fetchTasks(filterCriteria);
	}
	
	@PostMapping(value="addTask")
	public void addTasktoDB(@RequestBody Task taskRequest)
	{
		taskdao.insertTask(taskRequest);
	}
	
	@PutMapping(value="updateTask")
	public void updateTasktoDB(@RequestBody Task taskRequest)
	{
		taskdao.updateTask(taskRequest);
	}

}
