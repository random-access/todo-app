package org.random_access.todo.tasks;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class TaskHandler implements Serializable {

	private static final long serialVersionUID = -6208794536836495365L;

	@Inject
	private Task currentTask;
	
	@EJB
	private TaskManager manager;
	
	public String addTask(){
		// currentTask needs to be cloned because JPA cannot handle proxies
		manager.save(currentTask.cloneTask());
		return "add_success";
	}

	public List<Task> getTasks() {
		return manager.getTasks();
	}

	public void deleteTask(Task task) {
		manager.remove(task);
	}

	public String updateTask(Task task) {
		manager.update(task);
		return "upd_success";
	}
	
}
