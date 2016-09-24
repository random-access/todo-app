package org.random_access.todo.ctrl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.random_access.todo.model.Project;
import org.random_access.todo.model.TaskBean;
import org.random_access.todo.store.Task;
import org.random_access.todo.store.TaskHandler;

@Named("TaskController")
@RequestScoped
public class TaskController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TaskBean taskBean;
	
	@Inject
	private TaskHandler taskHandler;
	
	public String addTask() {
		System.out.println("Form for adding task submitted");
		taskHandler.addTask(taskBean);
		return "success";
	}
	
	public List<SelectItem> getProjects() {
		ArrayList<SelectItem> projects = new ArrayList<>();
		projects.add(new SelectItem(Project.personal.toString(), "Privat"));
		projects.add(new SelectItem(Project.uni.toString(), "Uni"));
		projects.add(new SelectItem(Project.work.toString(), "Arbeit"));
		return projects;
	}
	
	public List<Task> getTasks() {
		return taskHandler.getTasks();
	}

}
