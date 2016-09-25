package org.random_access.todo.tasks;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.random_access.todo.projects.Project;

@Named("currentTask")
@ConversationScoped
@Entity
@Table(name = "tasks")
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "project")
	private Project project;
	
	public Task() {}
	
	public Task(int id, String name, String description, Project project) {
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Task cloneTask() {
		Task clone = new Task();
		clone.id = this.id;
		clone.name = this.name;
		clone.description = this.description;
		clone.project = this.project;
		return clone;
	}

}
