package org.random_access.todo.store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.random_access.todo.model.TaskBean;

@ApplicationScoped
public class TaskHandler implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static int current_id;
	
	private ArrayList<Task> taskList;
	
	public TaskHandler () {
		taskList = new ArrayList<>();
	}
	
	public boolean addTask(TaskBean taskBean){
		Task task = new Task(++current_id, taskBean.getName(), taskBean.getDescription(), taskBean.getProject());
		return taskList.add(task);
	}

	public List<Task> getTasks() {
		return taskList;
	}

	public boolean deleteTask(Task task) {
		System.out.println("Removed task");
		return taskList.remove(task);
	}

	// TODO: there must be an easier way... (will be changed when using persistence anyway)
	public boolean updateTask(TaskBean taskBean) {
		Task task = null;
		
		// search for task with ID from taskBean
		for (Task t : taskList) {
			if (t.getId() == taskBean.getId()) {
				task = t;
			}
		}
		
		// task not found
		if (task == null) {
			System.out.println("Task not found");
			return false;
		}
		task.setDescription(taskBean.getDescription());
		task.setName(taskBean.getName());
		task.setProject(taskBean.getProject());
		return true;
	}
	
	
}
