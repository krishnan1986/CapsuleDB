package dao;

import java.util.List;

import model.Task;

public interface TaskOperations {
	
	public List<Task> fetchTasks();
	public void insertTask(Task task);
	
	public void updateTask(Task task);
	

}
