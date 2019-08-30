package com.capsule.taskMgr.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capsule.taskMgr.dao.TaskDao;
import com.capsule.taskMgr.model.Task;
import com.capsule.taskMgr.rest.model.Tasks;;

@RestController
@RequestMapping(path="/task")
public class ViewTaskController {
	
	 private static Tasks list = new Tasks();
	@Autowired
	TaskDao taskdao;
	
	@GetMapping(path="/", produces = "application/json")
	public  List<Task> getTaskFromUI()
	{ 
  
		List<Task> results =taskdao.fetchTasks();
		//list.setTasks(results);
	    return results;
		
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
