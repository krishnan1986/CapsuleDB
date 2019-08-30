package com.capsule.taskMgr.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.capsule.taskMgr.model.ParentTask;
import com.capsule.taskMgr.model.Task;
import com.capsule.taskMgr.util.HibernateUtil;

public class HibernateMain {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
		
		//SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession(); // create new session

		
		Transaction tx=session.beginTransaction();
		
				

		Task task1=new Task();
		//ramesh.setId(1008);
		task1.setName("task1");
		task1.setPriority(1);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
		
		///Date startdate= Calendar.getInstance().getTime();
		task1.setStartDate(sdf.parse("12-08-2018"));
		
		///Date enddate= new Date("12-08-2019");
		task1.setEndDate(sdf.parse("12-08-2019"));
		
		
		Task task2=new Task();
		//ramesh.setId(1008);
		task2.setName("task1");
		task2.setPriority(1);
		
		
		//Date startdate1= new Date("12-07-2018");
		task1.setStartDate(sdf.parse("12-07-2018"));
		
		//Date enddate1= new Date("12-08-2019");
		task1.setEndDate(sdf.parse("12-08-2019"));
		
		
		ParentTask ptask=new ParentTask();
		ptask.setName("High Priortiy");
		//ptask.setParent_task_id(1);
		
		session.save(task1);
		session.save(task2);
		session.save(ptask);
		tx.commit();
		session.close();
		
		
		
		
	}

}