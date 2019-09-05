package com.capsule.taskMgr.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.capsule.taskMgr.dao.TaskDao;
import com.capsule.taskMgr.model.Task;
import com.capsule.taskMgr.rest.model.Tasks;;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ViewTaskController {
	
	 private static Tasks list = new Tasks();
	@Autowired
	TaskDao taskdao;
	
	//@GetMapping(path="/", produces = "application/json")
	                @RequestMapping(value = "/tasks", method = RequestMethod.GET, produces = "application/json")
	public  List<Task> getTaskFromUI()
	{ 
  
		List<Task> results =taskdao.fetchTasks();
		//list.setTasks(results);
	    return results;
		
	}
	
	//@PostMapping
	                @RequestMapping(value="/addTask",method=RequestMethod.POST,produces="application/json")
	public void addTasktoDB(@RequestBody Task taskRequest)
	{
		taskdao.insertTask(taskRequest);
	}
	
	@PutMapping(value="/updateTask")
	public void updateTasktoDB(@RequestBody Task taskRequest)
	{
		taskdao.updateTask(taskRequest);
	}
	
	 @RequestMapping(value = "/searchTask", method = RequestMethod.POST, produces = "application/json")
	 public List<Task> searchTasksinDB(@RequestBody Task taskfilter)
	 {
		 List<Task> results =taskdao.fetchTasks(taskfilter);
			//list.setTasks(results);
		    return results;
	 }
	
	

}