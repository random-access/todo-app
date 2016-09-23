package org.random_access.todo.model;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("TaskBean")
@RequestScoped
public class TaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private Project project;
	
	public TaskBean() {
		System.out.println("New TaskBean created!");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	

}
