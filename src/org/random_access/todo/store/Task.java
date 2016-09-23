package org.random_access.todo.store;

import org.random_access.todo.model.Project;

public class Task {
	
	private String name;
	private String description;
	private Project project;
	
	public Task(String name, String description, Project project) {
		super();
		this.name = name;
		this.description = description;
		this.project = project;
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
