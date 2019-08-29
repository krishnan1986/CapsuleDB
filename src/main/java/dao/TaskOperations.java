package dao;

import java.util.List;

import model.Task;

public interface TaskOperations {
	
	public List<Task> fetchTasks(Task fitler);
	public void insertTask(Task task);
	
	public void updateTask(Task task);
	

}
