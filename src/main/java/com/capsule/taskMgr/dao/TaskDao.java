package com.capsule.taskMgr.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capsule.taskMgr.model.Task;
import com.capsule.taskMgr.util.HibernateUtil;
@Component
public class TaskDao implements TaskOperations {
	
	@Autowired
	HibernateUtil hibernateUtil;
	
	Transaction tx;
	Session session;
	SessionFactory sessionfactory;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Task> fetchTasks() {
		// TODO Auto-generated method stub
		//set up
		setup();
		String hql = "FROM Task";
		Query query =  session.createQuery(hql);
		List<Task> results = query.list();
		
		return results;
	}

	@Override
	public void insertTask(Task task) {
		// TODO Auto-generated method stub
		setup();
		session.save(task);
		tx.commit();
		session.close();
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

	@Override
	public List<Task> fetchTasks(String taskname) {
		// TODO Auto-generated method stub
		//List<Task> fromDB= new ArrayList<Task>();
		
		  // build criteria
		//	session
		 setup();
		
		/*
		 * SQLQuery q
		 * =session.createSQLQuery("select * from task where name=:taskname");
		 * q.addEntity(Task.class); q.setParameter("taskname", taskname);
		 */
		
		 /* CriteriaBuilder cb =session.getCriteriaBuilder(); CriteriaQuery<Task> tc ;
		  Criterion name= Restrictions.eq("name", filter.getName());
		 */
		/*
		 * Criterion priority= Restrictions.eq("priority", filter.getPriority());
		 * 
		 * Criterion startDate= Restrictions.eq("StartDate", filter.getStartDate());
		 * 
		 * Criterion endDate= Restrictions.eq("EndDate", filter.getEndDate());
		 */
		 // tc.add(Restrictions.or(name);//priority,startDate,endDate));
		  //tc.add(name);
		
		  Criteria c= session.createCriteria(Task.class);
		  c.add(Restrictions.eq("taskname",taskname));
		 
		 // List<Task>fromDB= (List<Task>)q.list();
		 List<Task> fromDB=c.list();
		return fromDB;
	}

	
	public void deleteTask(Task task)
	{
		setup();
		session.delete(task);
		session.close();
		
	}
	
}
