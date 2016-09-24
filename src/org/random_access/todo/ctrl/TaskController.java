package org.random_access.todo.ctrl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.random_access.todo.model.Project;
import org.random_access.todo.model.TaskBean;
import org.random_access.todo.store.Task;
import org.random_access.todo.store.TaskHandler;

@Named("TaskController")
@SessionScoped
public class TaskController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TaskBean taskBean;
	
	@Inject
	private TaskHandler taskHandler;
	
	public String addTask() {
		return taskHandler.addTask(taskBean) ? "add_success" : "add_failure";
	}
	
	public String deleteTask(Task task) {
		return taskHandler.deleteTask(task) ? "del_success" : "del_failure";	
	}
	
	public String updateDiesenVerficktenTask() {
		return taskHandler.updateTask(taskBean) ? "upd_success" : "upd_failure";
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
