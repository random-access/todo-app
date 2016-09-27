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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.random_access.todo.projects.Project;

@Named("currentTask")
@ConversationScoped

@Entity
@Table(name = "tasks")

@NamedQueries({
	@NamedQuery(name="find_all_tasks", query="SELECT t FROM Task t")
})
public class Task implements Serializable {

	private static final long serialVersionUID = -3921883190512551720L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	private String name;
	
	@NotEmpty
	private String description;
	
	@Version
	private int version;
	
	@ManyToOne
	@JoinColumn(name = "project")
	private Project project;
	
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
	
	// !this is only a shallow copy as project is not cloned
	public Task cloneTask() {
		Task clone = new Task();
		clone.id = this.id;
		clone.name = this.name;
		clone.description = this.description;
		clone.project = this.project;
		return clone;
	}

}
