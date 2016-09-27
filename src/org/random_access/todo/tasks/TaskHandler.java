package org.random_access.todo.tasks;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.random_access.todo.internationalization.MessagesBean;

@Named
@ApplicationScoped
public class TaskHandler implements Serializable {

	private static final long serialVersionUID = -6208794536836495365L;

	@Inject
	private Task currentTask;
	
	@Inject
	private MessagesBean messages;
	
	@EJB
	private TaskManager manager;
	
	public String addTask(){
		// currentTask needs to be cloned because JPA cannot handle proxies
		manager.save(currentTask.cloneTask());
		messages.showInfo("success", "success-adding-task");
		return "add_success";
	}

	public List<Task> getTasks() {
		return manager.getTasks();
	}

	public void deleteTask(Task task) {
		manager.remove(task);
		messages.showInfo("success", "success-removing-task");
	}

	public String updateTask(Task task) {
		manager.update(task);
		messages.showInfo("success", "success-updating-task");
		return "upd_success";
	}
	

	
}
