package com.capsule.taskMgr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int task_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="priority" ,nullable = false)
	private int priority;
	
	@Column(name="start_date")
	private String StartDate;
	
	@Column(name="end_date")
	private String EndDate;
	
	// foreign key relation
	@ManyToOne
	@JoinColumn(name="parent_task_id")
	private ParentTask ptask;

	public ParentTask getPtask() {
		return ptask;
	}

	public void setPtask(ParentTask ptask) {
		this.ptask = ptask;
	}

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	

}
