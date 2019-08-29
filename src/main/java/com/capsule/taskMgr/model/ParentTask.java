package com.capsule.taskMgr.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="parent_task")
public class ParentTask {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int parent_task_id;
	
	public int getParent_task_id() {
		return parent_task_id;
	}

	public void setParent_task_id(int parent_task_id) {
		this.parent_task_id = parent_task_id;
	}

	@Column(name="parent_task_name")
	private String name;
	
	@OneToMany(mappedBy="ptask")
	Set subtasks= new HashSet();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getSubtasks() {
		return subtasks;
	}

	public void setSubtasks(Set subtasks) {
		this.subtasks = subtasks;
	}
	
	

}
