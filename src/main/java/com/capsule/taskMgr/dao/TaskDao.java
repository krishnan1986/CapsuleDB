package com.capsule.taskMgr.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.capsule.taskMgr.model.Task;
import com.capsule.taskMgr.util.HibernateUtil;

public class TaskDao implements TaskOperations {
	
	@Autowired
	HibernateUtil hibernateUtil;
	
	Transaction tx;
	Session session;
	SessionFactory sessionfactory;

	
	@Override
	public List<Task> fetchTasks(Task filter) {
		// TODO Auto-generated method stub
		//set up
		setup();
		List<Task> fromDB= new ArrayList<Task>();
		// build criteria
		Criteria tc = session.createCriteria(Task.class);
		Criterion name= Restrictions.eq("name", filter.getName());
		
		Criterion priority= Restrictions.eq("priority", filter.getPriority());
		
		Criterion startDate= Restrictions.eq("StartDate", filter.getStartDate());
		
		Criterion endDate= Restrictions.eq("EndDate", filter.getEndDate());
		
		tc.add(Restrictions.or(name,priority,startDate,endDate));
		
		fromDB= (List<Task>)tc.list();
		return fromDB;
	}

	@Override
	public void insertTask(Task task) {
		// TODO Auto-generated method stub
		
	}
	
	public void setup()
	{
		 sessionfactory= HibernateUtil.getSessionFactory();
		 session= sessionfactory.openSession(); // create new session

		 tx=session.beginTransaction();
	}

	@Override
	public void updateTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	
}
