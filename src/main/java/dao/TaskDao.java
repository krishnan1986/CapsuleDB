package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import model.Task;
import util.HibernateUtil;

public class TaskDao implements TaskOperations {
	
	@Autowired
	HibernateUtil hibernateUtil;
	
	Transaction tx;

	public TaskDao() {
		//set up session
		setup();
		
	}

	@Override
	public List<Task> fetchTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertTask(Task task) {
		// TODO Auto-generated method stub
		
	}
	
	public void setup()
	{
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession(); // create new session

		tx=session.beginTransaction();
	}

	@Override
	public void updateTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	
}
