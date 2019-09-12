package com.capsule.taskMgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capsule.taskMgr.dao.TaskDao;
import com.capsule.taskMgr.model.Task;;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ViewTask")
public class ViewTaskController {
	
	 
		@Autowired
		TaskDao taskdao;
	
	@GetMapping(path="/tasks",produces="application/json")
	      //          @RequestMapping(value = "/tasks", method = RequestMethod.GET, produces = "application/json")
	public  List<Task> getTaskFromUI()
	{ 
  
		List<Task> results =taskdao.fetchTasks();
		//list.setTasks(results);
	    return results;
		
	}
	
	
	
	@PutMapping
	//(value="/updateTask")
	public void updateTasktoDB(@RequestBody Task taskRequest)
	{
		taskdao.updateTask(taskRequest);
	}
	
		//@DeleteMapping(value="/endTask/{taskname}")
	 @RequestMapping(value = "/endTask", method = RequestMethod.DELETE)
	public void removeTask(@RequestParam String taskName )
	{
		// find by name 
		taskdao.deleteTask(taskName);
		//taskdao.deleteTask(restask);
	}

	// @RequestMapping(value = "/searchTask", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
		@GetMapping(value="/searchTask")
		@ResponseBody
		 public List<Task> searchTasksinDB(@RequestParam  String name)
		 {
			/*
			 * Task taskfilter =new Task(); taskfilter.setName(name);
			 */
			List<Task> results =taskdao.fetchTasks(name );
				//list.setTasks(results);
			    return results;
		 }
		
		
}