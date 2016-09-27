package org.random_access.todo.tasks;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.random_access.todo.internationalization.MessagesBean;

@Named
@SessionScoped
public class TaskHandler implements Serializable {

	private static final long serialVersionUID = -6208794536836495365L;

	@Inject
	private Task currentTask;
	
	@Inject
	private MessagesBean messages;
	
	@EJB
	private TaskManager manager;
	
	private List<Task> tasks;
	
	@PostConstruct
	private void loadTasks() {
		this.tasks = manager.getTasks();
	}
	
	public String addTask(){
		// currentTask needs to be cloned because JPA cannot handle proxies
		manager.save(currentTask.cloneTask());
		messages.showInfo("success", "success-adding-task");
		return "add_success";
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void deleteTask(Task task) {
		manager.remove(task);
		loadTasks();
		messages.showInfo("success", "success-removing-task");
	}

	public String updateTask(Task task) {
		manager.update(task);
		messages.showInfo("success", "success-updating-task");
		return "upd_success";
	}
	

	
}
