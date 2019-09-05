package com.capsule.taskMgr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer task_id;
	
	/*
	 * public void setTask_id(Integer task_id) { this.task_id = task_id; }
	 */

	@Column(name="name")
	private String taskname;
	
	@Column(name="priority" ,nullable = false)
	private int priority;
	
	@Column(name="start_date")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date StartDate;
	
	@Column(name="end_date")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date EndDate;
	
	// foreign key relation
	@ManyToOne
	@JoinColumn(name="parent_task_id")
	//@JsonIgnore
	@JsonManagedReference
	private ParentTask parentTask;

	public ParentTask getPtask() {
		return parentTask;
	}

	public Integer getTask_id() {
		return task_id;
	}

	public void setPtask(ParentTask ptask) {
		this.parentTask = ptask;
	}

	/*
	 * public int getTask_id() { return task_id; }
	 * 
	 * public void setTask_id(int task_id) { this.task_id = task_id; }
	 */

	public String getName() {
		return taskname;
	}

	public void setName(String taskname) {
		this.taskname = taskname;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	
	

}