package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.TaskDao;
import model.Task;;

@RestController
@RequestMapping("task")
public class ViewTaskController {
	
	@Autowired
	TaskDao taskdao;
	
	@GetMapping(value="getTasklist")
	public  List<Task> getTaskFromUI()
	{
		return taskdao.fetchTasks();
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
