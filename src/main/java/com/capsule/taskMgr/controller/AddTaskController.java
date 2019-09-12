package com.capsule.taskMgr.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capsule.taskMgr.dao.TaskDao;
import com.capsule.taskMgr.model.ParentTask;
import com.capsule.taskMgr.model.Task;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class AddTaskController {
	@Autowired
	TaskDao taskdao;
	
	@PostMapping(path="/addTask",produces="application/json", consumes="application/json")
//    @RequestMapping(value="/addTask",method=RequestMethod.POST,  headers="Accept=application/json")
/*
* @POST
* 
* @Path("/addTask")
* 
* @Consumes(MediaType.APPLICATION_JSON_UTF8_VALUE)
* 
*/
/*public ResponseEntity<Object> addTasktoDB(@RequestParam(name= "taskname") String taskname,
				@RequestParam(name="priority") String priority,
				@RequestParam(name="parentTaskid")String ptaskid,
				@RequestParam(name="startDate") LocalDate startDate,
				@RequestParam(name="endDate") LocalDate endDate)
*/
public ResponseEntity<String> addTask(@RequestBody Map<String,String> task,HttpServletRequest request)
{
		Task requestTask = new Task();
		ParentTask pt = new ParentTask();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		requestTask.setName((String) task.get("taskname"));
		try {
			requestTask.setStartDate(sdf.parse((String) (task.get("startDate"))));
			requestTask.setEndDate(sdf.parse((String) task.get("endDate")));
			pt.setName((String) task.get("parentTask"));
			requestTask.setPriority(Integer.valueOf(task.get("Priority")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
taskdao.insertTask(requestTask);
return ResponseEntity.status(HttpStatus.CREATED).build();
//System.out.println(taskname+":"+priority+ptaskid+""+startDate.toString()+endDate.toString());
}
}
